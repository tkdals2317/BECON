<template>
  <section class="parallax-section">
    <div
      class="image-layer"
    ></div>
    <div class="auto-container">
      <div class="content-box">
        <div class="icon-box">
          <span class="flaticon-app-development"></span>
        </div>
        <h2>
          BE-CON은 공연문화를 바꾸고,<br>
          <span>우리는 BE-CON을 만듭니다.</span>
        </h2>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "ParallaxSection",
};
</script>

<style scoped>
.parallax-section .content-box h2 {
  position: relative;
  display: block;
  font-size: 60px;
  line-height: 1.2em;
  text-transform: uppercase;
  color: #ffffff;
  font-weight: 500;
  margin-bottom: 0px;
}
</style>
