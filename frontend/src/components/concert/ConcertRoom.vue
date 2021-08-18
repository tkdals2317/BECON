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
                  <div id="participants" class="row clearfix">
                    <div id="mainStage" class="col-lg-12 col-md-12 col-sm-12">
                      <div :id="getConcert.user.userId" class="participant main">
                        <video :id="`video-${getConcert.user.userId}`" :autoplay="true" :ref="getConcert.user.userId"></video>
                        <div style="line-height: 1.3;">{{getConcert.user.name}}</div>
                      </div>
                    </div>
                    <div id="subStage" class="col-lg-12 col-md-12 col-sm-12">
                      <no-ssr>
                        <carousel :perPage="5" id="carousel">
                          <slide v-for="(name, index) in slides" :key="index">
                            <div :id="name" class="participant">
                              <video :id="`video-${name}`" :autoplay="true" :ref="name"></video>
                              <div class="video-text">{{name}}</div>
                            </div>
                          </slide>
                        </carousel>
                      </no-ssr>
                    </div>
                  </div>
                </div>
                <div class="lower-box">
                  <div class="post-meta" style="float: left;">
                    <ul class="clearfix">
                      <li><span class="far fa-clock"></span> <span>{{minute}}분 </span><span>{{second}}초</span> </li>
                      <li><span class="far fa-user-circle"></span> {{getConcert.user.name}}</li>
                      <li><span class="far fa-comments"></span> {{participants.size}} People</li>
                    </ul>
                  </div>
                  <figure class="ownerProfile" style="float: right; clear: right;">
                    <img :src="`https://i5d102.p.ssafy.io/profileImg/${getConcert.user.userId}.png`"/>
                  </figure>
                  <h4 style="clear: left;">{{getConcert.title}}</h4>
                  <div class="text">
                    <p>
                      {{getConcert.description}}
                    </p>
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
            <div class="sidebar-widget recent-posts" style="height: 660px" ref="messages">
              <div class="widget-inner" style="height: 100%">
                <div class="sidebar-title">
                  <h4>Chat</h4>
                </div>

                <div
                  class="post"
                  v-for="(message, index) in messages"
                  :key="index"
                >
                  <div v-if="message.sender !== '[알림]'">
                    <figure class="post-thumb" >
                      <img :src="`https://i5d102.p.ssafy.io/profileImg/${message.sender}.png`"/>
                    </figure>
                    <div style="font-size: 17px; color: red;" v-if="message.sender === getConcert.user.userId">
                      {{ message.sender }} - {{ message.message }}
                    </div>
                    <div style="font-size: 17px" v-if="message.sender !== getConcert.user.userId">
                      {{ message.sender }} - {{ message.message }}
                    </div>
                  </div>
                  <div v-if="message.sender === '[알림]'">
                    <div style="font-size: 17px">
                      {{ message.sender }} - {{ message.message }}
                    </div>
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
                    autocomplete="false"
                  />
                  <!-- <twemoji-textarea 
                    :emojiData="emojiDataAll" 
                    :emojiGroups="emojiGroups" 
                    :enableSendBtn="true"
                    :pickerArrowEnabled="false"
                    :skinsSelection="true"
                    idTextarea="idTextarea"
                    pickerWidth="#idTextarea"
                    @enterKey="sendMessage">
                  </twemoji-textarea> -->
                  <button @click="sendMessage">
                    <span class="icon flaticon-chat-comment-oval-speech-bubble-with-text-lines"></span>
                  </button>
                </div>
              </div>
            </div>
          </aside>
        </div>
      </div>
      <div class="button-info text-right">
        <button @click="leaveConcert">나가기</button>
      </div>
      <div class="info-row">
        <div class="tags-info">
          <strong>Tags:</strong> <a>{{getConcert.user.name}}</a>,
          <a>{{getConcert.title}}</a>
        </div>
        <div class="cat-info">
          <strong>Category:</strong> <a>{{ getConcert.category.name }}</a>
        </div>
        
      </div>
    </div>
  </div>
</template>

<script>
import { Participant } from "@/common/lib/participant";
import { stomp, webSocket } from "@/common/lib/socket";
import kurentoUtils from "kurento-utils";
import { mapActions, mapGetters } from 'vuex';
import VueSimpleAlert from "vue-simple-alert";
import NoSsr from "vue-no-ssr";
import { Carousel, Slide } from "vue-carousel";

export default {
  name: "concertRoom",

  data() {
    return {
      message: "",
      messages: [],
      participants: new Map(),
      userId: '',
      roomId: '',
      minute: 0,
      second: 0,
      people: 0,
      slides: [],
    };
  },

  components: {
    NoSsr,
    Carousel,
    Slide,
  },

  created() {
    window.scrollTo(0, 0);
    this.userId = this.getUserId;
    this.roomId = this.getConcert.id;

    this.connect();
    this.connection();
    this.register();
    this.setTimer();
  },

  // mounted() {
  //   var container = document.getElementById('popper-container');
  //   container.setAttribute('data-show', true);
  // },

  destroyed() {
    this.leaveRoom();
    clearInterval(this.timer);
  },

  computed: {
    ...mapGetters('user', ['getUserId']),
    ...mapGetters('room', ['getConcert']),
    ...mapGetters('ticket', ['getBuyTicket']),
  },

  watch: {
      messages() {
        this.$nextTick(() => {
            let messages = this.$refs.messages;
            messages.scrollTo({ top: messages.scrollHeight });
        });
      },
  },

  methods: {
    ...mapActions('ticket', ['findBuyTicket']),
    setTimer() {
      var startTime = new Date(this.getConcert.startTime);
      var endTime = new Date(this.getConcert.endTime);
      var now = new Date();

      var diff = (now.getTime() - startTime.getTime())/1000;
      var end = (endTime.getTime() - startTime.getTime())/1000;
      var endMinute = Math.floor(end / 60);

      this.minute = Math.floor(diff / 60);
      this.second = Math.floor(diff % 60);

      var app = this;
      this.timer = setInterval(function() {
        app.second += 1;
        
        if (app.second >= 60) {
          app.minute += 1;
          if (endMinute - app.minute == 5) {
            VueSimpleAlert.alert("콘서트가 종료되기까지 5분 남았습니다.");
          }
          else if (endMinute - app.minute == 1) {
            VueSimpleAlert.alert("콘서트가 종료되기까지 1분 남았습니다.");
          }
          app.second = 0;
        }
        
        if (endMinute - app.minute <= 1) {
          // console.log(60-app.second);
          if (endMinute - app.minute == 0 && app.second == 0) {
            VueSimpleAlert.alert("콘서트가 종료됩니다.");
            setTimeout(function() {
              app.$router.push('/');
            }, 5000);
          }
        }
      }, 1000);
    },
    leaveConcert() {
      VueSimpleAlert.confirm("콘서트에서 퇴장하시겠습니까?").then(() => {
        this.$router.push('/');
      });
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
      this.messages.push({
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
      this.wss.onmessage = (message) => {
        var parsedMessage = JSON.parse(message.data);

        switch (parsedMessage.id) {
          case "existingParticipants":
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
            this.participants.get(parsedMessage.name).rtcPeer.addIceCandidate(
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
      this.participants.get(result.name).rtcPeer.processAnswer(
        result.sdpAnswer,
        function (error) {
          if (error) return console.error(error);
        }
      );
    },
    callResponse(message) {
      if (message.response != "accepted") {
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
      var participant = new Participant(this.userId, this.sendMessageRTC, this.getConcert);
      this.participants.set(this.userId, participant);
      
      if (this.getConcert.user.userId !== this.userId) {
        this.slides.push(this.userId);
      }
      
      this.$nextTick(() => {
        var video = '';
        if (this.getConcert.user.userId !== this.userId) {
          video = this.$refs[`${this.userId}`][0];
        } else {
          video = this.$refs[`${this.userId}`];
        }

        var options = {
          localVideo: video,
          mediaConstraints: constraints,
          onicecandidate: participant.onIceCandidate.bind(participant),
        };

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
      });
    },
    leaveRoom() {
        this.sendMessageRTC({
            id : 'leaveRoom'
        });
        var participant = this.participants.get(this.userId);
        participant.dispose();
        for ( var key in this.participants) {
          this.participants.delete(key);
        }
        this.wss.close();
    },
    receiveVideo(sender) {
      var participant = new Participant(sender, this.sendMessageRTC, this.getConcert);
      this.participants.set(sender, participant);

      if (this.getConcert.user.userId !== sender) {
        this.slides.push(sender);
      }

      this.$nextTick(() => {
        var video = '';
        if (this.getConcert.user.userId !== sender) {
          video = this.$refs[`${sender}`][0];
        } else {
          video = this.$refs[`${sender}`];
        }

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
      });
    },
    onParticipantLeft(request) {
      var participant = this.participants.get(request.name);
      participant.dispose();
      this.slides = this.slides.filter((element) => element !== request.name);
      this.participants.delete(request.name);
    },
    sendMessageRTC(message) {
      this.wss.onopen = () => {
        var jsonMessage = JSON.stringify(message);
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
.sidebar-page-container .content-side {
  margin-bottom: 0px;
}
.video-text {
  height: 10px;
  line-height: 0;
  font-size: 14px;
}
/* .form-group >>> #btn-emoji-default {
  right: unset !important;
}
.form-group >>> #popper-container {
  transform: translate(4px, 260px) !important;
}
.form-group >>> #btn-emoji-default {
  display: none !important;
}
.form-group >>> #send-btn {
  margin-top: unset !important;
  margin-bottom: unset !important;
  padding: unset !important;
  margin-right: 10px !important;
  font-size: 50px !important;
  line-height: 1.5 !important;
} */
.sidebar .recent-posts .post {
  position: relative;
  font-size: 20px;
  color: var(--thm-text);
  padding: 20px 0px 0px 55px;
  min-height: 62px;
  margin-bottom: 30px;
}
.recent-posts {
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
  margin-top: 0.8em;
  margin-bottom: 0.8em;
}
figure img {
  -webkit-filter: none !important;
}
.post > div {
  overflow-wrap: anywhere;
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
.ownerProfile img {
  border-radius: 50%;
  max-width: 100px;
  height: auto;
}
.info-row {
  clear: both;
  position: relative;
  padding: 0px 0px 0px;
  border-bottom: 1px solid #e9ebee !important;
  font-size: 16px;
  line-height: 30px;
  font-weight: 300;
  letter-spacing: 0.05em;
}
.tags-info {
  float: left;
  margin-right: 30px;
}
.button-info {
  margin-right: 30px;
}
.button-info button {
  width: 100px;
  height: 50px;
}
.participant:before {
  display: none;
}
#subStage >>> .VueCarousel-wrapper {
  background: rgba(0, 0, 0, 0.08);
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
	 height: 121px;
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