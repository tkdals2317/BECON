<template>
  <section class="news-section">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>Coming Up<span class="dot">.</span></h2>
      </div>
      <div class="row clearfix">
        <no-ssr>
          <carousel :perPage="3">
            <!--News Block-->
            <slide v-for="concertInfo in getComingConcert" :key="concertInfo.id">
            <div
              class="news-block wow fadeInUp mx-3"
              data-wow-delay="0ms"
              data-wow-duration="1500ms"
            >
              <div class="inner-box">
                <div class="image-box">
                  <a @click="concertEnter(concertInfo)"
                    ><img :src="`https://i5d102.p.ssafy.io/thumbnailImg/${concertInfo.thumbnail.originName}`" alt=""
                  /></a>
                </div>
                <div class="lower-box">
                  <div class="post-meta">
                    <ul class="clearfix">
                      <li>
                        <span class="far fa-clock"></span>
                        <span>{{-concertInfo.minute}}</span> 분
                      </li>
                      <li><span class="far fa-user-circle"></span> {{concertInfo.user.name}}</li>
                    </ul>
                  </div>
                  <h5>
                    <a @click="concertEnter(concertInfo)"
                      >{{concertInfo.title}}</a
                    >
                  </h5>
                  <div class="text">
                    {{concertInfo.description}}
                  </div>
                  <div class="link-box">
                    <a class="theme-btn" @click="concertEnter(concertInfo)"
                      ><span class="flaticon-next-1"></span
                    ></a>
                  </div>
                </div>
              </div>
            </div>
            </slide>
          </carousel>
        </no-ssr>
      </div>
    </div>
  </section>
</template>
<script>
import NoSsr from "vue-no-ssr";
import { Carousel, Slide } from "vue-carousel";
import { mapActions, mapGetters } from "vuex";

export default {
  name: "BlogSection",

  components: {
    NoSsr,
    Carousel,
    Slide,
  },

  created() {
    this.findComingConcert();
    this.setTimer();
  },

  destroyed() {
    clearInterval(this.timer);
  },

  computed: {
    ...mapGetters("concert", ["getComingConcert"]),
  },

  methods: {
    ...mapActions("concert", ["findComingConcert"]),
    ...mapActions('room', ["setEnterConcert"]),
    setTimer() {
      var app = this;
      this.timer = setInterval(function() {
        app.findComingConcert();

        app.getComingConcert.forEach(element => {
          element.minute -= 1;
          if (element.minute < 0) {
            element.minute = 0;
          }
        });

      }, 60000);
    },
    concertEnter(concert) {
      let num = prompt('방 번호를 입력해주세요');

      if (concert.id == num) {
        this.setEnterConcert(concert);
        this.$router.push('/waiting');
      }
      else {
        alert('티켓이 일치하지 않습니다.');
      }
    },
  }
};
</script>

<style scoped>
.news-block {
  max-width: none !important;
}
</style>
