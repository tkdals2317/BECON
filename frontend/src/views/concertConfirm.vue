<template>
  <div>
    <Nav />
    <PageHeader title="Concert Confirm" />
    <ConcertConfirm :concert="$route.params.concert"/>
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import ConcertConfirm from "../components/ConcertConfirm.vue";
export default {
  components: {
    ConcertConfirm,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "Be-con | Concert Regist | Concert Confirm",
    };
  },
};
</script>
