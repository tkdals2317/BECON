<template>
  <section class="faqs-section">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>Weekly Concert<span class="dot">.</span></h2>
      </div>
    </div>
    <div class="auto-container">
      <div class="row clearfix">
        <div class="btn-nav">
          <div style="float: left;" @click="preWeek"><button>지난 주</button></div>
          <div style="float: right;" @click="nextWeek"><button>다음 주</button></div>
        </div>
        <no-ssr>
          <carousel :perPage="2">
            <slide
              v-for="(list, index) in date"
              :key="list.id"
            >
              <div class="faq-block col-lg-12 col-md-12 col-sm-12">
                <div class="accordion-container-one">
                  <div class="ac">
                    <div class="row clearfix">
                      <div class="ac-q col-lg-12 col-md-12 col-sm-12">
                        <h2
                          class="ac-q accordion__title-text centered"
                          tabIndex="0"
                        >
                          {{ list }}
                        </h2>
                      </div>
                    </div>
                  </div>
                  <div
                    class="ac"
                    v-for="item in getWeeklyConcert[week[index]]"
                    :key="item.concert.id"
                  >
                    <label
                      class="row clearfix"
                      @click="item.isShow = !item.isShow"
                    >
                      <div class="ac-q col-lg-5 col-md-12 col-sm-12">
                        <h2
                          class="ac-q accordion__title-text_left"
                          tabIndex="0"
                        >
                          <font-awesome-icon icon="clock" />
                          {{ item.concert.startTime.split(" ")[1] }}~{{
                            item.concert.endTime.split(" ")[1]
                          }}<br />
                          <font-awesome-icon icon="microphone" />
                          {{ item.concert.user.name }}
                        </h2>
                      </div>
                      <div class="ac-q col-lg-5 col-md-10 col-sm-12">
                        <h2
                          class="ac-q accordion__title-text_right text-title"
                          tabIndex="0"
                        >
                          {{ item.concert.title }}
                        </h2>
                        
                      </div>
                      <div class="ac-q col-lg-2 col-md-2 col-sm-12">
                        <img
                          style="
                            width: 40px;
                            height: 40px;
                            border-radius: 15px;
                          "
                          :src="`https://i5d102.p.ssafy.io/profileImg/${item.concert.user.userId}.png`"
                        />
                      </div>
                    </label>
                    <div
                      v-if="item.isShow"
                    >
                      <div class="ac-a accordion__content row clearfix">
                        <div class="ac-q col-lg-5 col-md-12 col-sm-12">
                          <img
                            style="width: 100%; height: 250px"
                            :src="`https://i5d102.p.ssafy.io/posterImg/${item.concert.poster.originName}`"
                          />
                        </div>
                        <div class="ac-q col-lg-7 col-md-12 col-sm-12 mt-4">
                          <h2 class="ac-q accordion__title-text_right">
                            {{ item.concert.description }}
                          </h2>
                          <div class="detail-btn" @click="moveDetail(item.concert)">
                            <button>상세보기</button>
                          </div>
                        </div>
                      </div>
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
import GLightbox from "glightbox";
import { mapActions, mapGetters } from "vuex";
import { Carousel, Slide } from "vue-carousel";
import NoSsr from "vue-no-ssr";

export default {
  name: "ConcertSchedule",
  components: {
    NoSsr,
    Carousel,
    Slide,
  },
  data() {
    return {
      week: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
      date: [],
      add: 0,
      Days: "",
      plus7Days: "",
    };
  },
  created() {
    window.scrollTo(0, 0);
    this.getDate();
    this.findWeeklyConcert({start: this.Days, end: this.plus7Days});
  },
  mounted() {
    new GLightbox({
      selector: ".lightbox-image",
      touchNavigation: true,
      loop: true,
      autoplayVideos: true,
    });
  },
  computed: {
    ...mapGetters("concert", ['getWeeklyConcert']),
  },
  methods: {
    ...mapActions('concert', ['findWeeklyConcert', 'findConcertDetail']),
    preWeek() {
      this.add -= 7;
      this.getDate();
      this.findWeeklyConcert({start: this.Days, end: this.plus7Days});
    },
    nextWeek() {
      this.add += 7;
      this.getDate();
      this.findWeeklyConcert({start: this.Days, end: this.plus7Days});
    },
    moveDetail(concert) {
      this.findConcertDetail(concert)
      this.$router.push("concertDetail");
    },
    getDate() {
      var moment = require("moment");
      var now = moment().add(this.add, 'days');
      var today = now.day();

      if (today == 1) {
        this.Days = now.format("YYYY-MM-DD");
        this.plus7Days = now.add(6, "days").format("YYYY-MM-DD");
        for (let i = 0; i < 7; i++) {
          this.date[i] = moment()
            .add(this.add + i, "days")
            .format("YYYY-MM-DD");
        }
      } else if (today == 2) {
        this.Days = moment().add(this.add, 'days').subtract(1, "days").format("YYYY-MM-DD");
        this.plus7Days = moment().add(this.add, 'days').add(5, "days").format("YYYY-MM-DD");
        for (let i = -1; i < 6; i++) {
          this.date[i + 1] = moment()
            .add(this.add + i, "days")
            .format("YYYY-MM-DD");
        }
      } else if (today == 3) {
        this.Days = moment().add(this.add, 'days').subtract(2, "days").format("YYYY-MM-DD");
        this.plus7Days = moment().add(this.add, 'days').add(4, "days").format("YYYY-MM-DD");
        for (let i = -2; i < 5; i++) {
          this.date[i + 2] = moment()
            .add(this.add + i, "days")
            .format("YYYY-MM-DD");
        }
      } else if (today == 4) {
        this.Days = moment().add(this.add, 'days').subtract(3, "days").format("YYYY-MM-DD");
        this.plus7Days = moment().add(this.add, 'days').add(3, "days").format("YYYY-MM-DD");
        for (let i = -3; i < 4; i++) {
          this.date[i + 3] = moment()
            .add(this.add + i, "days")
            .format("YYYY-MM-DD");
        }
      } else if (today == 5) {
        this.Days = moment().add(this.add, 'days').subtract(4, "days").format("YYYY-MM-DD");
        this.plus7Days = moment().add(this.add, 'days').add(2, "days").format("YYYY-MM-DD");
        for (let i = -4; i < 3; i++) {
          this.date[i + 4] = moment()
            .add(this.add + i, "days")
            .format("YYYY-MM-DD");
        }
      } else if (today == 6) {
        this.Days = moment().add(this.add, 'days').subtract(5, "days").format("YYYY-MM-DD");
        this.plus7Days = moment().add(this.add, 'days').add(1, "days").format("YYYY-MM-DD");
        for (let i = -5; i < 2; i++) {
          this.date[i + 5] = moment()
            .add(this.add + i, "days")
            .format("YYYY-MM-DD");
        }
      } else {
        this.Days = moment().add(this.add, 'days').add(1, "days").format("YYYY-MM-DD");
        this.plus7Days = moment().add(this.add, 'days').add(7, "days").format("YYYY-MM-DD");
        for (let i = -6; i < 1; i++) {
          this.date[i + 6] = moment()
            .add(this.add + i, "days")
            .format("YYYY-MM-DD");
        }
      }
    },
  },
};
</script>

<style scoped>
.detail-btn {
  font-size: 16px;
  margin-top: 30px;
}
.detail-btn button {
  width: 90px;
  height: 30px;
}
.btn-nav button {
  width: 100px;
  height: 50px;
}
.project-tab * {
  padding: 1px 0px 0px 0px;
}
.tabs {
  display: flex;
  flex-wrap: wrap;
}
.ac {
  margin-top: 10px;
  padding: 10px;
  background: #ffffff;
  box-sizing: border-box;
}
.accordion__title-text_left,
.accordion__title-text_right {
  font-size: 15px;
  margin: -5px 0px -15px 0px;
}
.accordion__title-text {
  font-size: 15px;
  margin: 0px 0px 0px 0px;
}
.text-title {
  font-size: 20px;
}
.ac > .ac-q {
  font: bold 15px Arial, sans-serif;
  font-size: 23px;
  color: #444;
  padding: 10px 10px 10px 10px;
  margin: 0;
  text-decoration: none;
  display: block;
  cursor: pointer;
  position: relative;
  font-weight: 400;
  font-family: Teko;
}

.ac.is-active .ac-q {
  color: #ffaa17 !important;
}

.ac > .ac-a {
  overflow: hidden;
  -webkit-transition-property: all;
  transition-property: all;
  -webkit-transition-timing-function: ease;
  transition-timing-function: ease;
}

.ac > .ac-a p {
  font: 16px/1.5 Arial, sans-serif;
  color: #878e9c;
  margin: 0;
  padding: 10px;
  font-size: 18px;
  font-weight: 600;
}

.ac.js-enabled > .ac-a {
  visibility: hidden;
}

.ac.is-active > .ac-a {
  visibility: visible;
}

.ac.is-active > .ac-q::after {
  content: "\2013";
  color: #ffaa17;
}
</style>
