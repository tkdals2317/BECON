<template>
  <div class="sidebar-page-container">
    <div class="auto-container">
      <div class="row clearfix">
        <!--Content Side-->
        <div class="content-side col-lg-8 col-md-12 col-sm-12">
          <div class="blog-details">
            <!--News Block-->
            <div class="post-details">
              <div class="inner-box">
                <div class="image-box">
                  <!-- <img src="@/common/images/resource/news-7.jpg" alt=""> -->
                  <h2 id="room-header"></h2>
                  <div id="participants"></div>
                </div>
                <div class="lower-box">
                  <div class="post-meta">
                    <ul class="clearfix">
                      <li><span class="far fa-clock"></span> <span>{{minute}}분</span><span>{{second}}초</span> </li>
                      <li><span class="far fa-user-circle"></span> {{getConcert.user.name}}</li>
                      <li><span class="far fa-comments"></span> 2 People</li>
                    </ul>
                  </div>
                  <h4>{{getConcert.title}}</h4>
                  <div class="text">
                    <p>
                      {{getConcert.description}}
                    </p>
                  </div>
                  <div class="info-row clearfix">
                    <div class="tags-info">
                      <strong>Tags:</strong> <a href="#">{{getConcert.user.name}}</a>,
                      <a href="#">{{getConcert.title}}</a>
                    </div>
                    <div class="cat-info">
                      <strong>Category:</strong> <a href="#">{{ getConcert.category.name }}</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <!--Sidebar Side-->
        <div class="sidebar-side col-lg-4 col-md-12 col-sm-12">
          <aside class="sidebar blog-sidebar">
            <!--Sidebar Widget-->
            <div class="sidebar-widget recent-posts" style="height: 730px">
              <div class="widget-inner" style="height: 100%">
                <div class="sidebar-title">
                  <h4>Chat</h4>
                </div>

                <div
                  class="post"
                  v-for="(message, index) in messages"
                  :key="index"
                >
                  <figure class="post-thumb">
                    <img :src="require('@/common/images/resource/author-1.jpg')"/>
                  </figure>
                  <div style="font-size: 15px">
                    {{ message.sender }} - {{ message.message }}
                  </div>
                </div>
              </div>
            </div>

            <div class="sidebar-widget search-box">
              <div class="widget-inner">
                <div class="form-group">
                  <input
                    type="text"
                    name="search-field"
                    v-model="message"
                    v-on:keypress.enter="sendMessage"
                    style="font-size: 15px"
                  />
                  <button @click="sendMessage">
                    <span class="icon flaticon-chat-comment-oval-speech-bubble-with-text-lines"></span>
                  </button>
                </div>
              </div>
            </div>
          </aside>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { Participant } from "@/common/lib/participant";
import { stomp, webSocket } from "@/common/lib/socket";
import kurentoUtils from "kurento-utils";
import { mapGetters } from 'vuex';

export default {
  name: "concertRoom",

  data() {
    return {
      message: "",
      messages: [],
      participants: [],
      userId: '',
      roomId: '',
      minute: 0,
      second: 0,
    };
  },

  created() {
    window.scrollTo(0, 0);
    this.userId = this.getUserId;
    this.roomId = this.getRoomId;
    this.minute = -this.getConcert.minute;
    this.second = -this.getConcert.second;
    
    console.log('아이디:'+this.userId);
    console.log('방번호:'+this.roomId);

    this.connect();
    this.connection();
    this.register();
    this.setTimer();
  },

  destroyed() {
    this.leaveRoom();
    clearInterval(this.timer);
  },

  computed: {
    ...mapGetters('user', ['getUserId']),
    ...mapGetters('room', ['getRoomId', 'getConcert']),
  },

  methods: {
    setTimer() {
      var app = this;
      this.timer = setInterval(function() {
        app.second += 1;
        if (app.second >= 60) {
          app.minute += 1;
          app.second = 0;
        }
      }, 1000);
    },
    // WebSocket
    sendMessage() {
      this.ws.send(
        "/pub/chat/message",
        JSON.stringify({
          type: "TALK",
          roomId: this.roomId,
          sender: this.userId,
          message: this.message,
        }),
        {},
      );
      this.message = "";
    },
    recvMessage(recv) {
      this.messages.unshift({
        type: recv.type,
        sender: recv.sender,
        message: recv.message,
      });
    },
    connect() {
      this.ws = stomp();
      var app = this;

      this.ws.connect(
        {},
        function () {
          app.ws.subscribe("/sub/chat/room/" + app.roomId, function (message) {
            var recv = JSON.parse(message.body);
            app.recvMessage(recv);
          });
          app.ws.send(
            "/pub/chat/message",
            JSON.stringify({
              type: "ENTER",
              roomId: app.roomId,
              sender: app.userId,
            }),
            {},
          );
        },
      );
    },
    // WebRTC
    connection() {
      this.wss = webSocket();
      console.info("message: ");
      this.wss.onmessage = (message) => {
        var parsedMessage = JSON.parse(message.data);
        console.info("Received message: "+parsedMessage);

        switch (parsedMessage.id) {
          case "existingParticipants":
            console.log(parsedMessage);
            this.onExistingParticipants(parsedMessage);
            break;
          case "newParticipantArrived":
            this.onNewParticipant(parsedMessage);
            break;
          case "participantLeft":
            this.onParticipantLeft(parsedMessage);
            break;
          case "receiveVideoAnswer":
            this.receiveVideoResponse(parsedMessage);
            break;
          case "iceCandidate":
            this.participants[parsedMessage.name].rtcPeer.addIceCandidate(
              parsedMessage.candidate,
              function (error) {
                if (error) {
                  console.error("Error adding candidate: " + error);
                  return;
                }
              }
            );
            break;
          default:
            console.error("Unrecognized message", parsedMessage);
        }
      };
    },
    register() {
      var message = {
        id: "joinRoom",
        name: this.userId,
        room: this.roomId,
      };
      this.sendMessageRTC(message);
    },
    onNewParticipant(request) {
      this.receiveVideo(request.name);
    },
    receiveVideoResponse(result) {
      this.participants[result.name].rtcPeer.processAnswer(
        result.sdpAnswer,
        function (error) {
          if (error) return console.error(error);
        }
      );
    },
    callResponse(message) {
      if (message.response != "accepted") {
        console.info("Call not accepted by peer. Closing call");
        stop();
      } else {
        this.webRtcPeer.processAnswer(message.sdpAnswer, function (error) {
          if (error) return console.error(error);
        });
      }
    },
    onExistingParticipants: function (msg) {
      var constraints = {
        audio: true,
        video: {
          mandatory: {
            maxFrameRate: 15,
            minFrameRate: 15,
          },
        },
      };
      console.log(this.userId + " registered in room " + this.roomId);
      var participant = new Participant(this.userId, this.sendMessageRTC);
      this.participants[this.userId] = participant;
      var video = participant.getVideoElement();
      
      var options = {
        localVideo: video,
        mediaConstraints: constraints,
        onicecandidate: participant.onIceCandidate.bind(participant),
      };

      console.log(options);
      
      participant.rtcPeer = new kurentoUtils.WebRtcPeer.WebRtcPeerSendonly(
        options,
        function (error) {
          if (error) {
            return console.error(error);
          }
          this.generateOffer(participant.offerToReceiveVideo.bind(participant));
        }
      );
      
      msg.data.forEach(this.receiveVideo);
      console.log(this.participants);
    },
    leaveRoom() {
        this.sendMessageRTC({
            id : 'leaveRoom'
        });

        for ( var key in this.participants) {
            this.participants[key].dispose();
        }
        this.wss.close();
    },
    receiveVideo(sender) {
      var participant = new Participant(sender, this.sendMessageRTC);
      this.participants[sender] = participant;
      var video = participant.getVideoElement();

      var options = {
        remoteVideo: video,
        onicecandidate: participant.onIceCandidate.bind(participant),
      };

      participant.rtcPeer = new kurentoUtils.WebRtcPeer.WebRtcPeerRecvonly(
        options,
        function (error) {
          if (error) {
            return console.error(error);
          }
          this.generateOffer(participant.offerToReceiveVideo.bind(participant));
        }
      );
    },
    onParticipantLeft(request) {
      console.log("Participant " + request.name + " left");
      var participant = this.participants[request.name];
      participant.dispose();
      delete this.participants[request.name];
    },
    sendMessageRTC(message) {
      this.wss.onopen = () => {
        var jsonMessage = JSON.stringify(message);
        console.log("Sending message: " + jsonMessage);
        this.wss.send(jsonMessage);
      }
    },
  },
};
</script>

<style scoped>
.post {
  min-height: 20px !important;
  margin-bottom: 0px !important;
}
.sidebar-widget {
  background: #f4f5f8 !important;
}
.sidebar .recent-posts .post {
  position: relative;
  font-size: 20px;
  color: var(--thm-text);
  padding: 20px 0px 0px 85px;
  min-height: 62px;
  margin-bottom: 30px;
}
.sidebar .sidebar-widget {
  position: relative;
  display: block;
  margin-bottom: 30px;
  overflow: auto;
}
.auto-container {
  max-width: 1600px;
}
.post-details .lower-box .text p {
  position: relative;
  line-height: 2;
  margin-bottom: 35px;
  font-size: 20px;
}
.post-details .info-row {
  position: relative;
  display: block;
  padding: 0px 0px 0px;
  border-bottom: 1px solid #e9ebee !important;
  font-size: 20px;
  line-height: 30px;   
  font-weight: 300;
  letter-spacing: 0.05em;
}

.post-details .info-row strong {
  font-size: 20px;
  text-transform: uppercase;
  font-weight: 400;
}

.post-details .info-row a {
  color: var(--thm-text);
  font-size: 14px;
}

.post-details .info-row a:hover {
  text-decoration: underline;
}

.post-details .info-row .tags-info {
  position: relative;
  float: left;
}

.post-details .info-row .cat-info {
  position: relative;
  float: right;
}
figure {
  display: block;
  width: 150px;
  height: 150px;
  margin-top: 1em;
  margin-bottom: 1em;
  /* margin-left: 40px;
  margin-right: 40px; */
}
.left-col {
  position: relative;
  padding: 0 4px;
  margin-bottom: 30px;
}
.left-col .inner {
  position: relative;
  display: block;
  font-size: 25px;
}
.right-col {
  position: relative;
  padding: 0px 4px;
  margin-bottom: 30px;
  z-index: 3;
}
.right-col .inner {
  position: relative;
  display: block;
  font-size: 25px;
}
.right-col .inner:before {
  content: "";
  position: absolute;
  left: 100%;
  top: 0;
  margin-left: -1px;
  width: 2000px;
  height: 100%;
  background: #ffffff;
}
</style>

<style>
.participant {
	 border-radius: 4px;
	 /* border: 2px groove; */
	 margin-left: 5;
	 margin-right: 5;
	 width: 150;
	 text-align: center;
	 overflow: hide;
	 float: left;
	 padding: 5px;
	 border-radius: 10px;
	 -webkit-box-shadow: 0 0 200px rgba(255, 255, 255, 0.5), 0 1px 2px
		 rgba(0, 0, 0, 0.3);
	 box-shadow: 0 0 200px rgba(255, 255, 255, 0.5), 0 1px 2px
		 rgba(0, 0, 0, 0.3);
	 /*Transition*/
	 -webkit-transition: all 0.3s linear;
	 -moz-transition: all 0.3s linear;
	 -o-transition: all 0.3s linear;
	 transition: all 0.3s linear;
 }
 
 .participant:before {
	 content: '';
	 position: absolute;
	 top: -8px;
	 right: -8px;
	 bottom: -8px;
	 left: -8px;
	 z-index: -1;
	 background: rgba(0, 0, 0, 0.08);
	 border-radius: 4px;
 }
 
 .participant:hover {
	 opacity: 1;
	 background-color: 0A33B6;
	 -webkit-transition: all 0.5s linear;
	 transition: all 0.5s linear;
 }
 
 .participant video, .participant.main video {
	 width: 100%;
	 height: auto;
 }
 
 .participant.main {
	 width: 100%;
	 margin: 0 auto;
 }
 
 .participant.main video {
	 height: auto;
 }

.form-group > input {
   background-color: #f4f5f8 !important;
   border: none !important;
 }
 .post > .text {
   max-width: none !important;
 }
 .post-thumb > img {
   width: 60% !important;
 }

</style>