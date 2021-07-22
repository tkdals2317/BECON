<template>
  <div>
    <Nav />
    <PageHeader title="404 Error" />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/Nav";
import PageHeader from "../components/PageHeader";
import Footer from "../components/Footer";
export default {
  components: {
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "Linoor | 404 Error",
    };
  },
};
</script>
