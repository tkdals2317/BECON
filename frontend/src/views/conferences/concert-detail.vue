<template>
  <div>
    <div>
    <h2>{{state.room.name}}</h2>
    </div>
    <div class="input-group">
        <div class="input-group-prepend">
            <label class="input-group-text">내용</label>
        </div>

        <input type="text" class="form-control" v-model="state.message" v-on:keypress.enter="sendMessage">
        <div class="input-group-append">
            <button class="btn btn-primary" type="button" @click="sendMessage">보내기</button>
        </div>
    </div>

    <ul class="list-group">
        <li class="list-group-item" v-for="(message, index) in state.messages" :key="index" :ref="chatForm">
            <div>{{message.sender}} - {{message.message}}</div>
        </li>
    </ul>
    <div></div>
  </div>
</template>
<style>
</style>
<script>
import { reactive, computed, ref } from 'vue'
import Stomp from 'webstomp-client'
import SockJS from 'sockjs-client'
import axios from 'axios'

export default {
  name: 'concert-detail',

  created() {
    this.connect();
    this.findRoom();
  },

  setup() {
    const chatForm = ref(null)
    const sock = new SockJS("http://localhost:8080/ws-stomp");
    const ws = Stomp.over(sock);

    const state = reactive({
      roomId: computed(() => {
        return localStorage.getItem('wschat.roomId');
      }),
      sender: computed(() => {
        return localStorage.getItem('wschat.sender');
      }),
      room: {},
      message: '',
      messages: [],
      reconnect: 0,
    })

    const findRoom =  function () {
      console.log('초기화');
      axios.get('/chat/room/'+state.roomId).then(response => {
          state.room = response.data;
      });
    }

    const sendMessage = function () {
      ws.send("/pub/chat/message", JSON.stringify({type:'TALK', roomId:state.roomId, sender:state.sender, message:state.message}), {});
      state.message = '';
    }

    const recvMessage = function(recv) {
      state.messages.unshift({"type":recv.type,"sender":recv.type=='ENTER'?'[알림]':recv.sender,"message":recv.message})
    }

    const connect = function() {
      ws.connect({}, function(frame) {
          ws.subscribe("/sub/chat/room/"+state.roomId, function(message) {
              var recv = JSON.parse(message.body);
              recvMessage(recv);
          });
          ws.send("/pub/chat/message", JSON.stringify({type:'ENTER', roomId:state.roomId, sender:state.sender}), {});
      }, function(error) {
          if(state.reconnect++ <= 5) {
              setTimeout(function() {
                  console.log("connection reconnect");
                  sock = new SockJS("http://localhost:8080/ws-stomp");
                  ws = Stomp.over(sock);
                  connect();
              },10*1000);
          }
      });
    }

    return { chatForm, state, findRoom, sendMessage, connect }
  }
}
</script>
