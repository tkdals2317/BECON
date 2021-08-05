<template>
  <div>
    <Nav />
    <PageHeader title="MYconcert"/>
    <Myconcert :concertId="$route.params.concertId"/>
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/Nav";
import PageHeader from "../components/PageHeader";
import Footer from "../components/Footer";
import Myconcert from "../components/Myconcert";
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
