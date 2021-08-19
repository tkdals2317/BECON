<template>
  <div>
    <Nav />
    <PageHeader title="공연 신청 확인" />
    <ConcertConfirm />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import ConcertConfirm from "../components/concert/ConcertConfirm.vue";
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
