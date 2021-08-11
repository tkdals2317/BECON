<template>
  <div>
    <Nav />
    <PageHeader title="MYconcert"/>
    <Myconcert :concertId="$route.params.concertId"/>
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
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
