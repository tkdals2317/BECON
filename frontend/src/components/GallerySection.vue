<template>
  <section class="gallery-section">
    <div class="auto-container">
      <!--MixitUp Galery-->
      <div class="mixitup-gallery">
        <div class="upper-row clearfix">
          <div class="sec-title">
            <h2>공연 목록 <span class="dot">.</span></h2>
          </div>
          <!--Filter-->
          <div class="filters clearfix">
            <ul class="filter-tabs filter-btns clearfix">
              <li class="filter" @click="click('All')">
                All<sup></sup>
              </li>
              <span v-for="category in getCategories" :key="category.id">
                <li class="filter" @click="click(category.name)">
                  {{ category.name }}<sup></sup>
                </li>
              </span>
            </ul>
          </div>
        </div>
        <div class="filter-list row">
          <!-- Gallery Item -->
          <div class="gallery-item mix web-design col-lg-4 col-md-4 col-sm-12" v-for="concertInfo in getConcertInfos" :key="concertInfo.id">
            <div class="inner-box">
              <figure class="image">
                <img src="@/common/images/gallery/1.jpg" alt="" />
              </figure>
              <a
                href="/images/gallery/1.jpg"
                class="lightbox-image overlay-box"
                data-fancybox="gallery"
              ></a>
              <div class="cap-box">
                <div class="cap-inner">
                  <div class="cat">
                    <span>{{ concertInfo.title }}</span>
                  </div>
                  <div class="title">
                    <h5>
                      <router-link to="/portfolio-single">{{
                        concertInfo.description
                      }}</router-link>
                    </h5>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import GLightbox from "glightbox";
import mixitup from "mixitup";
import { mapActions, mapGetters } from "vuex";

export default {
  name: "GallerySection",
  data() {
    return {
      mixer: null,
    };
  },
  computed: {
    ...mapGetters("concert", ["getCategories", "getConcertInfos"]),
  },
  methods: {
    ...mapActions("concert", ["requestCategory", "requestConcert"]),
    click(data) {
      //this.selectedCategory = data;
      console.log(data);
      this.requestConcert(data);
    },
  },
  mounted() {
    const containerEl = document.querySelector(".filter-list");
    this.mixer = new mixitup(containerEl, {});
    new GLightbox({
      selector: ".lightbox-image",
      touchNavigation: true,
      loop: true,
      autoplayVideos: true,
    });
  },
  created: function () {
    this.requestCategory();
    this.requestConcert("All");
  },
};
</script>

<style scoped></style>
