<template>
  <div>
    <Nav />
    <PageHeader title="Concert Schedule" />
    <ConcertSchedule :getConcertInfos="$route.params.getConcertInfos"/>
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/Nav";
import PageHeader from "../components/PageHeader";
import Footer from "../components/Footer";
import ConcertSchedule from "../components/ConcertSchedule";
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
