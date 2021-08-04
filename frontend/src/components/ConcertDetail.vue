<template>
  <div>
    <section class="project-single style-two">
      <div class="auto-container">
        <figure class="image-box">
          <a href="/images/resource/featured-image-20.jpg" class="portfolio" data-fancybox="gallery"><img src="../common/images/resource/featured-image-20.jpg" alt=""></a>
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
                  <li><strong>Concert</strong> <br>{{ getDetail.title }}</li>
                  <li><strong>Category</strong> <br>{{ getDetail.category }}</li>
                  <li><strong>Date</strong> <br>{{ getDetail.startTime }}</li>
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
      goTicketing(concertId) {
        this.$router.push({name: 'Ticketing', params:{ concertId: concertId } })
      },
    },
    mounted() {
      new GLightbox({
        selector: '.portfolio',
      });
      new GLightbox({
        selector: '.portfolio-gallery',
      });
    },
    created() {
      this.getConcertDetail(this.concertId);
    }
  }
</script>

<style scoped>

</style>
