<template>
  <div>
    <Nav />
    <PageHeader title="Concert Check" />
    <ConcertCheck />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import ConcertCheck from "../components/concert/ConcertCheck";

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
