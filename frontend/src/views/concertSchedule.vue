<template>
  <div>
    <Nav />
    <PageHeader title="콘서트 스케줄" />
    <ConcertSchedule :getConcertInfos="$route.params.getConcertInfos" />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import ConcertSchedule from "../components/concert/ConcertSchedule";

export default {
  components: {
    ConcertSchedule,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "BeCon | Concert Schedule",
    };
  },
};
</script>
