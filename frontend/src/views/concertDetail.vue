<template>
  <div>
    <Nav />
    <PageHeader title="ConcertDetail" />
    <ConcertDetail :concertId="$route.params.concertId"/>
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/Nav";
import PageHeader from "../components/PageHeader";
import Footer from "../components/Footer";
import ConcertDetail from "../components/ConcertDetail";
export default {
  components: {
    ConcertDetail,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "BeCon | Concert Detail",
    };
  },
};
</script>
