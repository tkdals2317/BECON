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
    this.requestUserInfo();
    this.setTimer();
  },

  destroyed() {
    clearInterval(this.timer);
  },

  computed: {
    ...mapGetters('concert', ["getComingConcert"]),
    ...mapGetters('ticket', ["getEnterTicket"]),
    ...mapGetters('user', ["getUserInfo"]),
  },

  watch: {
    getEnterTicket(val) {
      if (val) {
        this.setEnterConcert(val.concert);
        this.$router.push('/waiting');
      } else {
        alert('티켓이 일치하지 않습니다.');
      }
    }
  },

  methods: {
    ...mapActions('concert', ["findComingConcert"]),
    ...mapActions('room', ["setEnterConcert"]),
    ...mapActions('ticket', ["findBuyTicket"]),
    ...mapActions('user', ["requestUserInfo"]),

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
      var app = this;
      
      this.$prompt("티켓 번호를 입력해주세요.", '', '콘서트 입장', 'success').then(code => {
        app.findBuyTicket({
          userId: app.getUserInfo.id,
          concertId: concert.id,
          code: code
        });
      }).catch(err => {
          if (err) console.log(err);
      });
    },
  }
};
</script>

<style scoped>
.news-block {
  max-width: none !important;
}
.image-box img {
  width: 360px;
  height: 270px;
}
</style>
