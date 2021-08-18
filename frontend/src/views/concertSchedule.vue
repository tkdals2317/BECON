<template>
  <div>
    <Nav />
    <PageHeader2 title="콘서트 스케줄" />
    <ConcertSchedule />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader2 from "../components/layout/PageHeader2";
import Footer from "../components/layout/Footer";
import ConcertSchedule from "../components/concert/ConcertSchedule";

export default {
  components: {
    ConcertSchedule,
    Footer,
    PageHeader2,
    Nav,
  },
  head() {
    return {
      title: "BeCon | Concert Schedule",
    };
  },
};
</script>
