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
            <div class="image image1"></div>
          </div>
          <div class="auto-container">
            <div class="content-box">
              <div class="content">
                <div class="inner">
                  <h1>TOP <br>ONE <br>MUSICAIN</h1>
                  <div class="text">best of best music</div>
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
          <div class="image image2"></div>
        </div>
        <div class="auto-container">
          <div class="content-box">
            <div class="content">
              <div class="inner" style="color: black;">
                  <h1>TOP <br>TWO <br>MUSICAIN</h1>
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
          <div class="image image3"></div>
        </div>
        <div class="auto-container">
          <div class="content-box">
            <div class="content">
              <div class="inner">
                  <h1>TOP <br>THREE <br>MUSICAIN</h1>
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
  background-image: url('../../common/images/resource/profile/BeConImg.jpg');
  background-position: center;
  background-size: cover;
  background-repeat: no-repeat;
  opacity: 1 !important;
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
.image1 {
  background-image: url('../../common/images/backcon4.jpg');
  background-size: cover;
  opacity: 1 !important;
  transform: none !important;
  -webkit-filter: none !important;
}
.image2 {
  background-image: url('../../common/images/backcon5.jpg');
  opacity: 1 !important;
  transform: none !important;
}
.image3 {
  background-image: url('../../common/images/backcon6.jpg');
  opacity: 1 !important;
  transform: none !important;
  -webkit-filter: none !important;

}
</style>
