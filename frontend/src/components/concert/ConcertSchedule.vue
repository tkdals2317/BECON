<template>
  <section class="gallery-section-two alternate">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>Concert Schedule <span class="dot">.</span></h2>
      </div>
    </div>
    <!--Porfolio Tabs-->
    <div class="project-tab">
      <!--Tabs Content-->
      <div class="p-tabs-content">
        <div class="auto-container">
        <!--Portfolio Tab / Active Tab-->
        <div class="p-tab active-tab" id="p-tab-1">
          <div class="project-carousel-two">
            <no-ssr>

            <carousel 
              v-if="getConcertInfos && requestConcert"
              :dots="false" 
              :margin="30" 
              :responsive="{0: {items: 1},640: {items: 2},992: {items: 3},1200: {items: 3}}"
            >

              <!-- Gallery Item -->
              <div class="gallery-item" v-for="concertInfo in getConcertInfos" :key="concertInfo.id">
                <div class="h4 centered">
                  {{ concertInfo.startTime }}
                </div>
                <div class="inner-box">
                  <figure class="image"><img src="@/common/images/resource/thumbnail/rucidfall.jpg" alt=""></figure>
                  <a href="#" class="lightbox-image overlay-box"
                     data-fancybox="gallery"></a>
                  <div class="cap-box">
                    <div class="cap-inner">
                      <div class="cat"><span>{{ concertInfo.title }}</span></div>
                      <div class="title">
                        <h5><a href="/">{{ concertInfo.description | truncate(50) }}</a></h5>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </carousel>
            </no-ssr>
          </div>
        </div>

      </div>
      </div>
    </div>
  </section>
</template>

<script>
import NoSsr from "vue-no-ssr";
import carousel from "vue-owl-carousel";
import GLightbox from "glightbox";
import { mapActions, mapGetters } from "vuex";
  export default {
    name: "ConcertSchedule",
    components: {
      NoSsr,
      carousel,
    },
    computed: {
      ...mapGetters("concert", ["getCategories", "getConcertInfos"]),
    },
    methods: {
      ...mapActions("concert", ["requestCategory", "requestConcert"]),
    },
    mounted () {
      window.scrollTo(0, 0);
      new GLightbox({
        selector: '.lightbox-image',
        touchNavigation: true,
        loop: true,
        autoplayVideos: true
      });
    },
    // created: function () {
    //   this.requestConcert("All");
    // },
  }
</script>

<style scoped>
.project-tab * {
  padding: 1px 0px 0px 0px;
}
</style>
