<template>
  <div>
    <section class="project-single style-two">
      <div class="auto-container">
        <figure class="image-box">
          <img :src="`https://i5d102.p.ssafy.io/posterImg/${getDetail.poster.originName}`" alt="">
        </figure>
        <div class="text-content mb-5">
          <div class="row clearfix">
            <!-- Text COl -->
            <div class="text-col col-lg-8 col-md-12 col-sm-12">
              <div class="inner">
                <h5>title</h5>
                <p>{{ getDetail.title }}</p>
                <h5>description</h5>
                <p>{{ getDetail.description }}</p>
              </div>
            </div>
            <!-- Text COl -->
            <div class="text-col col-lg-4 col-md-12 col-sm-12">
              <div class="inner">
                <ul class="info">
                  <li><strong>Category</strong> <div>{{ getDetail.category.name }}</div></li>
                  <li><strong>Date</strong> <div>{{ getDetail.startTime.split(" ")[0] }}</div></li>
                  <li><strong>Time</strong> <div>{{ getDetail.startTime.split(" ")[1] }} ~ {{ getDetail.endTime.split(" ")[1] }}</div></li>
                  <li><strong>관람등급</strong> <div>{{ getDetail.minAge }}세 관람가</div></li>

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

  export default {
    name: "ConcertDetail",
    computed: {
      ...mapGetters("concert", ["getDetail"]),
    },
    methods: {
      ...mapActions("concert", ["findConcertDetail"]),
      ...mapActions("ticket", ["selectTicket"]),
      goTicketing(concert) {
        var startTime = new Date(this.getDetail.startTime);
        var now = new Date();
        // var diff = (startTime.getTime() - 3600000 ) - now.getTime();
        var diff = startTime.getTime() - now.getTime();
        
        if (diff > 0) {
          this.selectTicket(concert)
          this.$router.push('ticketing')
        } else {
          this.$alert('콘서트 시간을 확인해주세요.', '티켓 구매가 마감되었습니다.', 'warning');
        }
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
    },
  }
</script>

<style scoped>
small {
  font-size: 80% !important;
}
.time {
  font-size: 18px;
}
h5 {
  margin-bottom: 10px;
}
p {
  font-size: 24px;
}
.info {
  margin-top: 30px;
  padding-left: 100px;
}
.image-box img {
  object-fit: unset;
  width: 470px;
  height: 580px;
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
