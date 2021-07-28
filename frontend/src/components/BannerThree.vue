<template>
  <section class="banner-section banner-three">
    <div class="left-based-text">
      <div class="base-inner">
        <div class="hours">
          <ul class="clearfix">
            <li><span>mon - fri</span></li>
            <li><span>9am - 7pm</span></li>
          </ul>
        </div>
        <div class="social-links">
          <ul class="clearfix">
            <li><a href="#"><span>Twitter</span></a></li>
            <li><a href="#"><span>Facebook</span></a></li>
            <li><a href="#"><span>Youtube</span></a></li>
          </ul>
        </div>
      </div>
    </div>

    <div class="bg-image"></div>
    <div class="banner-carousel">
      <no-ssr>
      <carousel :perPage="1">
      <!-- Slide Item -->
      <slide>
        <div class="slide-item">
          <div class="round-shape-1"></div>
          <div class="round-image">
            <div class="image"></div>
          </div>
          <div class="auto-container">
            <div class="content-box">
              <div class="content">
                <div class="inner">
                  <h1>Best Digital <br>Marketing <br>Agency</h1>
                  <div class="text">We are committed to providing our customers with exceptional
                    service while offering our employees the best training.</div>
                  <div class="link-box">
                    <router-link class="theme-btn btn-style-two" to="/about">
                      <i class="btn-curve"></i>
                      <span class="btn-title">Discover More</span>
                    </router-link>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </slide>

      <!-- Slide Item -->
      <slide>
      <div class="slide-item">
        <div class="round-shape-1"></div>
        <div class="round-image">
          <div class="image"></div>
        </div>
        <div class="auto-container">
          <div class="content-box">
            <div class="content">
              <div class="inner" style="color: black;">
                <h1>Best Digital <br>Marketing <br>Agency</h1>
                <div class="text">We are committed to providing our customers with exceptional
                  service while offering our employees the best training.</div>
                <div class="link-box">
                  <router-link class="theme-btn btn-style-two" to="/about">
                    <i class="btn-curve"></i>
                    <span class="btn-title">Discover More</span>
                  </router-link>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      </slide>

      <!-- Slide Item -->
      <slide>
      <div class="slide-item">
        <div class="round-shape-1"></div>
        <div class="round-image">
          <div class="image"></div>
        </div>
        <div class="auto-container">
          <div class="content-box">
            <div class="content">
              <div class="inner">
                <h1>Best Digital <br>Marketing <br>Agency</h1>
                <div class="text">We are committed to providing our customers with exceptional
                  service while offering our employees the best training.</div>
                <div class="link-box">
                  <router-link class="theme-btn btn-style-two" to="/about">
                    <i class="btn-curve"></i>
                    <span class="btn-title">Discover More</span>
                  </router-link>
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
  </section>
</template>

<script>
import NoSsr from "vue-no-ssr";
import { Carousel, Slide } from "vue-carousel";

export default {
  name: "BannerThree",
  components: {
    NoSsr,
    Carousel,
    Slide,
  },
}
</script>

<style scoped>
.bg-image {
  background-image: url('../common/images/main-slider/banner-bg-shape-3.png');
}
.content * {
  opacity: 1 !important;
}
.round-shape-1 {
  opacity: 1 !important;
  transform: none !important;
}
.round-image:before {
  opacity: 0.1 !important;
  transform: none !important;
}
.round-image::after {
  opacity: 1 !important;
  transform: none !important;
}
.image {
  background-image: url('../common/images/main-slider/image-1.jpg');
  opacity: 1 !important;
  transform: none !important;
}
</style>
