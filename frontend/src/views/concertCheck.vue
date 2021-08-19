<template>
  <div>
    <Nav />
    <PageHeader title="공연 신청 내역" />
    <ConcertCheck />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import ConcertCheck from "../components/user/ConcertCheck";

export default {
  components: {
    ConcertCheck,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "Be-con | My Services | Check Concert",
    };
  },
};
</script>
