<template>
  <div>
    <Nav />
    <PageHeader :title="state.room.name"/>
    <BlogSingle />
    <Footer />
  </div>
</template>
<script>
  import Nav from "./conferences/Nav";
  import PageHeader from "./conferences/PageHeader";
  import BlogSingle from "./conferences/BlogSingle";
  import Footer from "./conferences/Footer";

  import { reactive, computed } from 'vue'
  import axios from 'axios'

export default {
  name: 'concert-detail',
    components: {
      Footer,
      PageHeader,
      BlogSingle,
      Nav
    },

  created() {
    this.findRoom();
  },

  setup() {
    const state = reactive({
      roomId: computed(() => {
        return localStorage.getItem('wschat.roomId');
      }),
      room: {},
    })

    const findRoom =  function () {
      axios.get('/chat/room/'+state.roomId).then(response => {
          state.room = response.data;
      });
    }

    return { state, findRoom }
  }
}
</script>
