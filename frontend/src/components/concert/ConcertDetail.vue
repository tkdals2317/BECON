<template>
  <div>
    <section class="project-single style-two">
      <div class="auto-container">
        <figure class="image-box">
          <img :src="`https://i5d102.p.ssafy.io/thumbnailImg/${getDetail.thumbnail.originName}`" alt="">
        </figure>
        <div class="text-content">
          <div class="row clearfix">
            <!-- Text COl -->
            <div class="text-col col-lg-8 col-md-12 col-sm-12">
              <div class="inner">
                <h5>Concert description</h5>
                <p>{{ getDetail.decription }}</p>
              </div>
            </div>
            <!-- Text COl -->
            <div class="text-col col-lg-4 col-md-12 col-sm-12">
              <div class="inner">
                <ul class="info">
                  <li><strong>Concert</strong> <br><br>{{ getDetail.title }}</li>
                  <li><strong>Category</strong> <br><br>{{ getDetail.category }}</li>
                  <li><strong>Date</strong> <br><br>{{ getDetail.startTime }}</li>
                  <li><strong>관람등급</strong> <br><br>연령 정보</li>
                  <button class="theme-btn btn-style-one">
                    <i class="btn-curve"></i>
                    <span class="btn-title" type="button" @click="goTicketing(getDetail)">Ticket!</span>
                  </button>
                </ul>
              </div>
            </div>

          </div>
        </div>
      </div>
    </section>

  </div>
</template>

<script>
import GLightbox from "glightbox";
import { mapActions, mapGetters } from "vuex";
// import "compass/css3";
  export default {
    name: "ConcertDetail",
    props: {
      concertId: Number,
    },
    computed: {
      ...mapGetters("concert", ["getDetail"]),
    },
    methods: {
      ...mapActions("concert", ["getConcertDetail"]),
      init() {
        this.getConcertDetail();
      },
      goTicketing(concertId) {
        this.$router.push({name: 'Ticketing', params:{ concertId: concertId } })
      },
    },
    create(){
      window.scrollTo(0, 0);
    },
    mounted() {
      window.scrollTo(0, 0);
      new GLightbox({
        selector: '.portfolio',
      });
      new GLightbox({
        selector: '.portfolio-gallery',
      });
      this.init();
    },
    created() {
      this.getConcertDetail(this.concertId);
    }
  }
</script>

<style scoped>
p {
  font-size: 24px;
}
.info {
  margin-top: 30px;
  padding-left: 100px;
}
.project-single .text-content .info li {
  font-size: 24px;
  margin-bottom: 20px;
}
.project-single .text-content .info li strong {
  font-size: 36px;
  color: black;
}
</style>
