<template>
  <div>
    <Nav />
    <PageHeader title="공연이름" />
    <ConcertRoom :roomId="$route.params.roomId"/>
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/Nav";
import PageHeader from "../components/PageHeader";
import Footer from "../components/Footer";
import ConcertRoom from "../components/ConcertRoom";
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
