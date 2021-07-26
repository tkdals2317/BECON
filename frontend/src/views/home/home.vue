<template>
  <div>
    <div class="row">
        <div class="col-md-12">
            <h3>채팅방 리스트</h3>
        </div>
    </div>

    <div class="input-group">
        <div class="input-group-prepend">
            <label class="input-group-text">방제목</label>
        </div>

        <input type="text" class="form-control" v-model="room_name" v-on:keyup.enter="createRoom">

        <div class="input-group-append">
            <button class="btn btn-primary" type="button" @click="createRoom">채팅방 개설</button>
        </div>
    </div>

    <ul class="infinite-list" v-infinite-scroll="load" style="overflow:auto">
      <li v-for="room in chatrooms" @click="clickConcert(room.roomId)" class="infinite-list-item" :key="room.roomId" >
        <conference :title="room.name"/>
      </li>
    </ul>
  </div>
</template>
<style>
.infinite-list {
  padding-left: 0;
  max-height: calc(100% - 35px);
}

@media (min-width: 701px) and (max-width: 1269px) {
  .infinite-list {
    min-width: 700px;
  }
}

@media (min-width: 1270px) {
  .infinite-list {
    min-width: 1021px;
  }
}

.infinite-list .infinite-list-item {
  min-width: 335px;
  max-width: 25%;
  display: inline-block;
  cursor: pointer;
}
</style>
<script>
import Conference from './components/conference'
import { reactive } from 'vue'
import { useRouter } from 'vue-router'
import axios from 'axios'

export default {
  name: 'Home',

  components: {
    Conference
  },

  data() {
    return {
      room_name : '',
      chatrooms: [],
    }
  },

  created() {
    this.findAllRoom();
  },

  methods: {
      findAllRoom: function() {
        axios.get('/chat/rooms').then(response => {
          console.log(response);
          this.chatrooms = response.data;
        });
      },
      createRoom: function() {
          if("" === this.room_name) {
              alert("방 제목을 입력해 주십시요.");
              return;
          } else {
              axios.post('/chat/room', {
                name: this.room_name,
              })
              .then(
                  response => {
                      alert(response.data.name+"방 개설에 성공하였습니다.")
                      this.room_name = '';
                      this.findAllRoom();
                  }
              )
              .catch(function (err) {
                alert(err.response.data.message);
                alert("채팅방 개설에 실패하였습니다.");
              });
          }
      },
  },

  setup () {
    const router = useRouter()

    const state = reactive({
      count: 12
    })

    const load = function () {
      state.count += 4
    }

    const clickConcert = function (roomId) {
      var sender = prompt('대화명을 입력해 주세요.');

      if(sender != "") {
          localStorage.setItem('wschat.sender',sender);
          localStorage.setItem('wschat.roomId',roomId);

          router.push({
            name: 'concert-detail',
            params: {
              concertId: roomId
            }
          })
      }
    }

    return { state, load, clickConcert }
  }
}
</script>
