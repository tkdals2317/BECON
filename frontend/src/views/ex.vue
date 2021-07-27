<template>
  <div>
    <Nav />
    <PageHeader title="Ex" />
    <EX/>
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/Nav";
import PageHeader from "../components/PageHeader";
import Footer from "../components/Footer";
import EX from "../components/Ex";
export default {
  components: {
    EX,
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
