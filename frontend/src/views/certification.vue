<template>
  <div>
    <Nav />
    <PageHeader title="본인인증" />
    <Certification />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import Certification from "../components/pay/Certification";

export default {
  components: {
    Certification,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "BeCon | Login",
    };
  },
};
</script>
