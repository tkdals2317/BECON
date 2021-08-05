<template>
  <div>
    <Nav />
    <ConcertWaiting />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import Footer from "../components/layout/Footer";
import ConcertWaiting from "../components/concert/ConcertWaiting";

export default {
  components: {
    ConcertWaiting,
    Footer,
    Nav,
  },
};
</script>
