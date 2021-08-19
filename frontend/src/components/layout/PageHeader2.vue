<template>
  <section class="page-banner">
    <div class="image-layer"></div>
    <div class="banner-inner">
      <div class="auto-container">
        <div class="inner-container clearfix">
          <h1>{{ title }}</h1>
          <div class="page-nav">
            <ul class="bread-crumb clearfix">
              <li><router-link to="/">Home</router-link></li>
              <li class="active">{{ title }}</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "PageHeader2",
  props: {
    title: {
      type: String,
    },
  },
};
</script>

<style scoped>
.image-layer {
  background-image: url('../../common/images/banner2.jpg');
  background-position: center;
  background-size: cover;
  background-repeat: no-repeat;
  opacity: 1 !important;
}
.page-banner .bread-crumb li {
  line-height: unset;
}
h1 {
  color: antiquewhite;
  text-shadow: 1px 0 black, 0 1px black, 1px 0 black, 0 1px black;
}
</style>
