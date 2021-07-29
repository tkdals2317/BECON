<template>
  <div>
    <Nav />
    <PageHeader title="Concert Check" />
    <ConcertCheck />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/Nav";
import PageHeader from "../components/PageHeader";
import Footer from "../components/Footer";
import ConcertCheck from "../components/ConcertCheck";
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
