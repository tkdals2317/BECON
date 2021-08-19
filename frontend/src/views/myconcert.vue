<template>
  <div>
    <Nav />
    <PageHeader title="공연 예매 내역"/>
    <Myconcert/>
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import Myconcert from "../components/user/Myconcert";
export default {
  components: {
    Myconcert,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "Be-con | My concert",
    };
  },
};
</script>
