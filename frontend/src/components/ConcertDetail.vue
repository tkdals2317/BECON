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
                  <!-- <button @click="goTicketing(getDetail)">Ticket!</button> -->
                  <div class='container' @click="goTicketing(getDetail)">
                    <span class='pulse-button'>Ticket!</span>
                  </div>
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

body, html {
  height: 100%;
  background: #fff;
}

.container {
  width: 200px;
  height: 100%;
  margin: 0 auto 0;
  -webkit-perspective: 1000;
  -webkit-backface-visibility: hidden;
  background: #fff;
}

.pulse-button {
  position: relative;
  top: 50%;
  left: 50%;
  margin-left: -50px;
  margin-top: -50px;
  display: block;
  width: 100px;
  height: 100px;
  font-size: 1.3em;
  font-weight: light;
  font-family: 'Trebuchet MS', sans-serif;
  text-transform: uppercase;
  text-align: center;
  line-height: 100px;
  letter-spacing: -1px;
  color: white;
  border: none;
  border-radius: 50%;
  background: #5a99d4;
  cursor: pointer;
  box-shadow: 0 0 0 0 rgba(#5a99d4, .5);
  -webkit-animation: pulse 1.5s infinite;
}
.pulse-button:hover {
  -webkit-animation: none;
}

@-webkit-keyframes pulse {
  0% {
    @include transform(scale(.9));
  }
  70% {
    @include transform(scale(1));
    box-shadow: 0 0 0 50px rgba(#5a99d4, 0);
  }
    100% {
    @include transform(scale(.9));
    box-shadow: 0 0 0 0 rgba(#5a99d4, 0);
  }
}
</style>
