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
              <li
                class="filter mixitup-control-active"
                data-role="button"
                data-filter="all"
              >
                All<sup></sup>
              </li>
              <li class="filter" data-role="button" data-filter=".branding">
                Hip<sup></sup>
              </li>
              <li class="filter" data-role="button" data-filter=".illustration">
                Ballad<sup></sup>
              </li>
              <li class="filter" data-role="button" data-filter=".photography">
                Zazz<sup></sup>
              </li>
              <li class="filter" data-role="button" data-filter=".web-design">
                Indi<sup></sup>
              </li>
            </ul>
          </div>
        </div>
        <div class="filter-list row">
          <!-- Gallery Item -->
          <div
            class="gallery-item mix all web-design col-lg-4 col-md-6 col-sm-12"
          >
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
                  <div class="cat"><span>Artist</span></div>
                  <div class="title">
                    <h5>
                      <router-link to="/portfolio-single"
                        >10cm</router-link
                      >
                    </h5>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <!-- Gallery Item -->
          <div
            class="
              gallery-item
              mix
              all
              photography
              web-design
              col-lg-4 col-md-6 col-sm-12
            "
          >
            <div class="inner-box">
              <figure class="image">
                <img src="@/common/images/gallery/2.jpg" alt="" />
              </figure>
              <a
                href="/images/gallery/2.jpg"
                class="lightbox-image overlay-box"
                data-fancybox="gallery"
              ></a>
              <div class="cap-box">
                <div class="cap-inner">
                  <div class="cat"><span>Artist</span></div>
                  <div class="title">
                    <h5>
                      <router-link to="/portfolio-single"
                        >유재석</router-link
                      >
                    </h5>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <!-- Gallery Item -->
          <div
            class="
              gallery-item
              mix
              all
              branding
              web-design
              col-lg-4 col-md-6 col-sm-12
            "
          >
            <div class="inner-box">
              <figure class="image">
                <img src="@/common/images/gallery/3.jpg" alt="" />
              </figure>
              <a
                href="/images/gallery/3.jpg"
                class="lightbox-image overlay-box"
                data-fancybox="gallery"
              ></a>
              <div class="cap-box">
                <div class="cap-inner">
                  <div class="cat"><span>Artist 명?</span></div>
                  <div class="title">
                    <h5>
                      <router-link to="/portfolio-single"
                        >공연제목?</router-link
                      >
                    </h5>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <!-- Gallery Item -->
          <div
            class="
              gallery-item
              mix
              all
              branding
              illustration
              col-lg-4 col-md-6 col-sm-12
            "
          >
            <div class="inner-box">
              <figure class="image">
                <img src="@/common/images/gallery/4.jpg" alt="" />
              </figure>
              <a
                href="/images/gallery/4.jpg"
                class="lightbox-image overlay-box"
                data-fancybox="gallery"
              ></a>
              <div class="cap-box">
                <div class="cap-inner">
                  <div class="cat"><span>Artist 명?</span></div>
                  <div class="title">
                    <h5>
                      <router-link to="/portfolio-single"
                        >공연제목?</router-link
                      >
                    </h5>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <!-- Gallery Item -->
          <div
            class="
              gallery-item
              mix
              all
              branding
              illustration
              photography
              web-design
              col-lg-4 col-md-6 col-sm-12
            "
          >
            <div class="inner-box">
              <figure class="image">
                <img src="@/common/images/gallery/5.jpg" alt="" />
              </figure>
              <a
                href="/images/gallery/5.jpg"
                class="lightbox-image overlay-box"
                data-fancybox="gallery"
              ></a>
              <div class="cap-box">
                <div class="cap-inner">
                  <div class="cat"><span>Artist 명?</span></div>
                  <div class="title">
                    <h5>
                      <router-link to="/portfolio-single"
                        >공연제목?</router-link
                      >
                    </h5>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <!-- Gallery Item -->
          <div
            class="
              gallery-item
              mix
              all
              illustration
              photography
              col-lg-4 col-md-6 col-sm-12
            "
          >
            <div class="inner-box">
              <figure class="image">
                <img src="@/common/images/gallery/6.jpg" alt="" />
              </figure>
              <a
                href="/images/gallery/6.jpg"
                class="lightbox-image overlay-box"
                data-fancybox="gallery"
              ></a>
              <div class="cap-box">
                <div class="cap-inner">
                  <div class="cat"><span>Artist 명?</span></div>
                  <div class="title">
                    <h5>
                      <router-link to="/portfolio-single"
                        >공연제목?</router-link
                      >
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

export default {
  name: "GallerySection",
  data() {
    return {
      mixer: null,
    };
  },
  computed:{
    
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
};
</script>

<style scoped></style>
