<template>
  <div>
    <Nav />
    <PageHeader title="공연신청" />
    <ConcertRegist />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import ConcertRegist from "../components/concert/ConcertRegist";

export default {
  components: {
    ConcertRegist,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "BeCon | Concert Regist",
    };
  },
};
</script>
