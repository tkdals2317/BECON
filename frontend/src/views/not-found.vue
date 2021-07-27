<template>
  <div>
    <Nav />
    <PageHeader title="my concert" />
    <Footer />
    <Mycon />
    <CallToActionThree />
  </div>
</template>
<script>
import Nav from "../components/Nav";
import PageHeader from "../components/PageHeader";
import Footer from "../components/Footer";
import Mycon from "../components/Mycon";
import CallToActionThree from "../components/CallToActionThree";


export default {
  components: {
    Footer,
    PageHeader,
    Nav,
    Mycon,
    CallToActionThree,

  },
  head() {
    return {
      title: "Linoor | 404 Error",
    };
  },
};
</script>
