<template>
  <div>
    <section class="project-single style-two">
      <div class="auto-container">
        <figure class="image-box">
          <img :src="`https://i5d102.p.ssafy.io/posterImg/${getDetail.poster.originName}`" alt="">
        </figure>
        <div class="text-content">
          <div class="row clearfix">
            <!-- Text COl -->
            <div class="text-col col-lg-8 col-md-12 col-sm-12">
              <div class="inner">
                <h5>Concert description</h5>
                <p>{{ getDetail.description }}</p>
              </div>
            </div>
            <!-- Text COl -->
            <div class="text-col col-lg-4 col-md-12 col-sm-12">
              <div class="inner">
                <ul class="info">
                  <li><strong>Concert</strong> <br><br>{{ getDetail.title }}</li>
                  <li><strong>Category</strong> <br><br>{{ getDetail.category.name }}</li>
                  <li><strong>Date</strong> <br><br>{{ getDetail.startTime }}</li>
                  <li><strong>관람등급</strong> <br><br>{{ getDetail.minAge }}세 관람가</li>

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
        this.selectTicket(concert)
        this.$router.push({name: 'Ticketing'})
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
    created() {
      window.scrollTo(0, 0);
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
