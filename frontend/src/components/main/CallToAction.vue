<template>
  <section class="call-to-section">
    <div class="auto-container">
      <div class="inner clearfix">
        <div
          class="shape-1 wow slideInRight"
          data-wow-delay="0ms"
          data-wow-duration="1500ms"
        ></div>
        <div
          class="shape-2 wow fadeInDown"
          data-wow-delay="0ms"
          data-wow-duration="1500ms"
        ></div>
        <h2>Let's Get Your Concert <br />Started!</h2>
        <div class="link-box">
          <router-link class="theme-btn btn-style-two" to="/concertRegist">
            <i class="btn-curve"></i>
            <span class="btn-title">Concert Regist</span>
          </router-link>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "CallToAction",
};
</script>

<style scoped></style>
