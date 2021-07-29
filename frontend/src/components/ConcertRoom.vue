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
                  <!-- <input type="button" id="button-leave" value="Leave room" /> -->
                </div>
                <div class="lower-box">
                  <div class="post-meta">
                    <ul class="clearfix">
                      <li><span class="far fa-clock"></span> 20 Mar</li>
                      <li><span class="far fa-user-circle"></span> Admin</li>
                      <li><span class="far fa-comments"></span> 2 Comments</li>
                    </ul>
                  </div>
                  <h4>basic rules of running web agency business</h4>
                  <div class="text">
                    <p>
                      There are many variations of passages of Lorem Ipsum
                      available, but the majority have suffered alteration in
                      some form, by injected humour, or randomised words which
                      don't look even slightly believable. If you are going to
                      use a passage of Lorem Ipsum, you need to be sure there
                      isn't anything embarrassing hidden in the middle of text.
                      All the Lorem Ipsum generators on the Internet tend to
                      repeat predefined chunks as necessary, making this the
                      first true generator on the Internet. It uses a dictionary
                      of over 200 Latin words, combined with a handful of model
                      sentence structures, to generate Lorem Ipsum which looks
                      reasonable. The generated Lorem Ipsum is therefore always
                      free from repetition, injected humour, or
                      non-characteristic words etc.
                    </p>
                    <p>
                      It is a long established fact that a reader will be
                      distracted by the readable content of a page when looking
                      at its layout. The point of using Lorem Ipsum is that it
                      has a more-or-less normal distribution of letters, as
                      opposed to using 'Content here, content here', making it
                      look like readable English. Many desktop publishing
                      packages and web page editors now use Lorem Ipsum as their
                      default model text, and a search for 'lorem ipsum' will
                      uncover many web sites still in their infancy. Various
                      versions have evolved over the years, sometimes by
                      accident, sometimes on purpose injected humour and the
                      like.
                    </p>
                  </div>
                </div>
              </div>
              <div class="info-row clearfix">
                <div class="tags-info">
                  <strong>Tags:</strong> <a href="#">Business</a>,
                  <a href="#">Agency</a>, <a href="#">Technology</a>
                </div>
                <div class="cat-info">
                  <strong>Category:</strong> <a href="#">Business</a>,
                  <a href="#">Agency</a>
                </div>
              </div>
            </div>
            <div class="post-control-two">
              <div class="row clearfix">
                <div class="control-col col-md-6 col-sm-12">
                  <div class="control-inner">
                    <h4>
                      <a href="#">A DEEP UNDERSTANDING OF OUR AUDIENCE</a>
                    </h4>
                    <a href="#" class="over-link"></a>
                  </div>
                </div>
                <div class="control-col col-md-6 col-sm-12">
                  <div class="control-inner">
                    <h4>
                      <a href="#">EXPERIENCES THAT CONNECT WITH PEOPLE</a>
                    </h4>
                    <a href="#" class="over-link"></a>
                  </div>
                </div>
              </div>
            </div>
            <!--Comments Area-->
            <div class="comments-area">
              <div class="comments-title">
                <h3>2 Comments</h3>
              </div>
              <div class="comment-box">
                <div class="comment">
                  <div class="author-thumb">
                    <figure class="thumb">
                      <img src="@/common/images/resource/author-7.jpg" alt="" />
                    </figure>
                  </div>
                  <div class="info">
                    <div class="name">Jessica Brown</div>
                    <div class="date">20 May, 2020 . 4:00 pm</div>
                  </div>
                  <div class="text">
                    Lorem Ipsum is simply dummy free text of the available
                    printing and typesetting been the industry standard dummy
                    text ever sincer condimentum purus.
                  </div>
                  <div class="reply-btn">
                    <a class="theme-btn btn-style-one" href="/about">
                      <i class="btn-curve"></i>
                      <span class="btn-title">Reply</span>
                    </a>
                  </div>
                </div>
              </div>

              <div class="comment-box">
                <div class="comment">
                  <div class="author-thumb">
                    <figure class="thumb">
                      <img src="@/common/images/resource/author-8.jpg" alt="" />
                    </figure>
                  </div>
                  <div class="info">
                    <div class="name">David Martin</div>
                    <div class="date">20 May, 2020 . 4:00 pm</div>
                  </div>
                  <div class="text">
                    Lorem Ipsum is simply dummy free text of the available
                    printing and typesetting been the industry standard dummy
                    text ever sincer condimentum purus.
                  </div>
                  <div class="reply-btn">
                    <a class="theme-btn btn-style-one" href="/about">
                      <i class="btn-curve"></i>
                      <span class="btn-title">Reply</span>
                    </a>
                  </div>
                </div>
              </div>
            </div>

            <!--Leave Comment Form-->
            <div class="leave-comments">
              <div class="comments-title">
                <h3>Leave a comment</h3>
              </div>
              <div class="default-form comment-form">
                <form method="post" action="#">
                  <div class="row clearfix">
                    <div class="col-md-6 col-sm-12 form-group">
                      <input
                        type="text"
                        name="username"
                        placeholder="Your Name"
                        required=""
                      />
                    </div>

                    <div class="col-md-6 col-sm-12 form-group">
                      <input
                        type="email"
                        name="email"
                        placeholder="Email Address"
                        required=""
                      />
                    </div>

                    <div class="col-md-6 col-sm-12 form-group">
                      <input
                        type="text"
                        name="username"
                        placeholder="Phone Number"
                        required=""
                      />
                    </div>

                    <div class="col-md-6 col-sm-12 form-group">
                      <input
                        type="text"
                        name="username"
                        placeholder="Subject"
                        required=""
                      />
                    </div>

                    <div class="col-md-12 col-sm-12 form-group">
                      <textarea
                        name="message"
                        placeholder="Your Comments"
                      ></textarea>
                    </div>

                    <div class="col-md-12 col-sm-12 form-group">
                      <button type="submit" class="theme-btn btn-style-one">
                        <i class="btn-curve"></i>
                        <span class="btn-title">Submit Comment</span>
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>

        <!--Sidebar Side-->
        <div class="sidebar-side col-lg-4 col-md-12 col-sm-12">
          <aside class="sidebar blog-sidebar">
            <!--Sidebar Widget-->
            <div class="sidebar-widget recent-posts" style="height: 400px">
              <div class="widget-inner" style="height: 100%">
                <!-- <div class="sidebar-title">
                  <h4>Chat</h4>
                </div>

                <div
                  class="post"
                  v-for="(message, index) in messages"
                  :key="index"
                  :ref="chatForm"
                >
                  <figure class="post-thumb"></figure>
                  <div class="text" style="font-size: 15px">
                    {{ message.sender }} - {{ message.message }}
                  </div>
                </div> -->
              </div>
            </div>

            <div class="sidebar-widget search-box">
              <div class="widget-inner">
                <div class="form-group">
                  <!-- <input
                    type="text"
                    name="search-field"
                    v-model="message"
                    v-on:keypress.enter="sendMessage"
                  />
                  <button @click="sendMessage">
                    <span class="icon flaticon-magnifying-glass-1"></span>
                  </button> -->
                </div>
              </div>
            </div>

            <div class="sidebar-widget archives">
              <div class="widget-inner">
                <div class="sidebar-title">
                  <h4>Categories</h4>
                </div>
                <ul>
                  <li><a href="/blog">Business</a></li>
                  <li class="active"><a href="/blog">Introductions</a></li>
                  <li><a href="/blog">One Page Template</a></li>
                  <li><a href="/blog">Parallax Effects</a></li>
                  <li><a href="/blog">New Technologies</a></li>
                  <li><a href="/blog">Video Backgrounds</a></li>
                </ul>
              </div>
            </div>

            <div class="sidebar-widget popular-tags">
              <div class="widget-inner">
                <div class="sidebar-title">
                  <h4>Tags</h4>
                </div>
                <div class="tags-list clearfix">
                  <a href="#">Business</a>, <a href="#">Agency</a>,
                  <a href="#">Technology</a>,<a href="#">Parallax</a>,
                  <a href="#">Innovative</a>, <a href="#">Professional</a>,<a
                    href="#"
                    >Experience</a
                  >
                </div>
              </div>
            </div>

            <div class="sidebar-widget recent-comments">
              <div class="widget-inner">
                <div class="sidebar-title">
                  <h4>Comments</h4>
                </div>

                <div class="comment">
                  <div class="icon">
                    <span class="flaticon-speech-bubble-2"></span>
                  </div>
                  <h5 class="text">
                    <a href="#"
                      >A Wordpress Commenter on Launch New Mobile App</a
                    >
                  </h5>
                </div>

                <div class="comment">
                  <div class="icon">
                    <span class="flaticon-speech-bubble-2"></span>
                  </div>
                  <h5 class="text">
                    <a href="#">John Doe on Template: <br />Comments</a>
                  </h5>
                </div>

                <div class="comment">
                  <div class="icon">
                    <span class="flaticon-speech-bubble-2"></span>
                  </div>
                  <h5 class="text">
                    <a href="#"
                      >A Wordpress Commenter on Launch New Mobile App</a
                    >
                  </h5>
                </div>

                <div class="comment">
                  <div class="icon">
                    <span class="flaticon-speech-bubble-2"></span>
                  </div>
                  <h5 class="text">
                    <a href="#">John Doe on Template: <br />Comments</a>
                  </h5>
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
import { Participant } from "../common/lib/participant";
import kurentoUtils from "kurento-utils";
// import Stomp from "webstomp-client";
// import SockJS from "sockjs-client";
// import axios from "axios";

// const sock = new SockJS("http://localhost:8080/ws-stomp");
// const ws = Stomp.over(sock);

export default {
  name: "concertRoom",

  data() {
    return {
      // roomId: "",
      // sender: "",
      // room: {},
      // message: "",
      // messages: [],
      // reconnect: 0,

      participants: [],
      roomId: '1',
      userName: 'heung',
    };
  },

  created() {
    // this.connect();
    // this.findRoom();
    
    this.connection();
    this.register();
  },

  // computed: {
  //   getRoomId() {
  //     return localStorage.getItem("wschat.roomId");
  //   },
  //   getSender() {
  //     return localStorage.getItem("wschat.sender");
  //   },
  // },

  methods: {
    // findRoom() {
    //   console.log("초기화");
    //   axios.get("/chat/room/" + this.roomId).then((response) => {
    //     this.room = response.data;
    //   });
    // },
    // sendMessage() {
    //   ws.send(
    //     "/pub/chat/message",
    //     JSON.stringify({
    //       type: "TALK",
    //       roomId: this.roomId,
    //       sender: this.sender,
    //       message: this.message,
    //     }),
    //     {}
    //   );
    //   this.message = "";
    // },
    // recvMessage(recv) {
    //   this.messages.unshift({
    //     type: recv.type,
    //     sender: recv.type == "ENTER" ? "[알림]" : recv.sender,
    //     message: recv.message,
    //   });
    // },
    // connect() {
    //   ws.connect(
    //     {},
    //     function () {
    //       ws.subscribe("/sub/chat/room/" + this.roomId, function (message) {
    //         var recv = JSON.parse(message.body);
    //         this.recvMessage(recv);
    //       });
    //       ws.send(
    //         "/pub/chat/message",
    //         JSON.stringify({
    //           type: "ENTER",
    //           roomId: this.roomId,
    //           sender: this.sender,
    //         }),
    //         {}
    //       );
    //     },
    //     function (error) {
    //       console.log(error);
    //       // if(this.reconnect++ <= 5) {
    //       //     setTimeout(function() {
    //       //         console.log("connection reconnect");
    //       //         sock = new SockJS("http://localhost:8080/ws-stomp");
    //       //         ws = Stomp.over(sock);
    //       //         connect();
    //       //     },10*1000);
    //       // }
    //     }
    //   );
    // },
    // WebRTC
    connection() {
      this.ws = new WebSocket("ws://localhost:8080/groupcall");
      console.info("message: ");
      this.ws.onmessage = (message) => {
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
      console.log("regist");
      // var name = document.getElementById('name').value;
      // var room = document.getElementById('roomName').value;
      // console.log(name+" "+room)
      // document.getElementById('room-header').innerText = 'ROOM ' + room;
      // document.getElementById('join').style.display = 'none';
      // document.getElementById('room').style.display = 'block';
      var message = {
        id: "joinRoom",
        name: this.userName,
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
            // maxWidth: 100,
            maxFrameRate: 15,
            minFrameRate: 15,
          },
        },
      };
      console.log(this.userName + " registered in room " + this.roomId);
      var participant = new Participant(this.userName, this.sendMessageRTC);
      this.participants[this.userName] = participant;
      var video = participant.getVideoElement();

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
    },
    // leaveRoom() {
    //     this.sendMessage({
    //         id : 'leaveRoom'
    //     });

    //     for ( var key in this.participants) {
    //         this.participants[key].dispose();
    //     }
    //     document.getElementById('join').style.display = 'block';
    //     document.getElementById('room').style.display = 'none';
    //     this.socket.close();
    // },
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
      this.ws.onopen = () => {
        var jsonMessage = JSON.stringify(message);
        console.log("Sending message: " + jsonMessage);
        this.ws.send(jsonMessage);
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
</style>