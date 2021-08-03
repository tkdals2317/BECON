<template>
  <div>
    <Nav />
    <!-- <PageHeader title="공연이름" /> -->
    <ConcertWaiting/>
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/Nav";
// import PageHeader from "../components/PageHeader";
import Footer from "../components/Footer";
import ConcertWaiting from "../components/ConcertWaiting";
export default {
  components: {
    ConcertWaiting,
    Footer,
    // PageHeader,
    Nav,
  },
};
</script>
