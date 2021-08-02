<template>
  <section class="error-section">
    <div class="auto-container">
      <div class="big-text">
          <div class="row text-center">
            <div class="col-5">00</div>
            <div class="col-2">:</div>
            <div class="col-5">00</div>
          </div>
        </div>
      <div class="content">
        <h2>공연이 곧 시작됩니다.</h2>
        <div class="text">
          잠시만 기다려주세요.
        </div>
        <div class="error-form">
          <div id="participants-img" class="row"></div>
        </div>
        <div class="link-box">
          <router-link class="theme-btn btn-style-one" :to="{ name: 'ConcertPage', params: { roomId: roomId }}">
            <i class="btn-curve"></i>
            <span class="btn-title">입장하기</span>
          </router-link>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { Participant } from "@/common/lib/participant";
import { webSocket } from "@/common/lib/socket";
import { mapGetters } from 'vuex';

export default {
  name: "ConcertWaiting",

  data() {
    return {
      participants: [],
      userId: '',
      roomId: '',
    };
  },

  created() {
    this.userId = this.getUserId;
    this.roomId = this.getRoomId;

    console.log('아이디:'+this.userId);
    console.log('방번호:'+this.roomId+'x');
    this.connection();
    this.register();
  },

  destroyed() {
    this.leaveRoom();
  },

  computed:{
    ...mapGetters('user', ['getUserId']),
    ...mapGetters('room', ['getRoomId']),
  },

  methods: {
    connection() {
      this.ws = webSocket();
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
        room: this.roomId+'x',
      };
      this.sendMessageRTC(message);
    },
    onNewParticipant(request) {
      this.receiveVideo(request.name);
    },
    leaveRoom() {
        this.sendMessageRTC({
            id : 'leaveRoom'
        });
        for ( var key in this.participants) {
            this.participants[key].dispose();
        }
        this.ws.close();
    },
    onExistingParticipants(response) {
      console.log(this.userId + " registered in room " + this.roomId);
      for (var name in response.data) {
        var person = new Participant(response.data[name], this.sendMessageRTC);
        this.participants[response.data[name]] = person;
      }
      var participant = new Participant(this.userId, this.sendMessageRTC);
      this.participants[this.userId] = participant;
    },
    receiveVideo(sender) {
      var participant = new Participant(sender, this.sendMessageRTC);
      this.participants[sender] = participant;
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
.big-text {
  font-size: 200px;
  margin-bottom: 50px;
}
.link-box {
  margin-top: 100px;
}
</style>
