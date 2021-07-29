<template>
  <div>
    <Nav />
    <PageHeader title="공연이름" />
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
};
</script>
