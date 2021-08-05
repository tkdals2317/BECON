<template>
  <div>
    <Nav />
    <PageHeader title="my concert" />
    <Mycon />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import Mycon from "../components/user/Mycon";

export default {
  components: {
    Footer,
    PageHeader,
    Nav,
    Mycon,
  },
  head() {
    return {
      title: "Linoor | 404 Error",
    };
  },
};
</script>
