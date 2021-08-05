<template>
  <div>
    <Nav />
    <PageHeader title="공연이름" />
    <ConcertRoom />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import ConcertRoom from "../components/concert/ConcertRoom";

export default {
  components: {
    ConcertRoom,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "Be-con | Ex",
    };
  },
};
</script>
