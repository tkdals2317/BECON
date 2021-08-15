<template>
  <div>
    <Nav />
    <PageHeader :title="getConcert.title" />
    <ConcertRoom />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import ConcertRoom from "../components/concert/ConcertRoom";
import { mapGetters } from "vuex";

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
  computed: {
    ...mapGetters("room", ["getConcert"]),
  }
};
</script>
