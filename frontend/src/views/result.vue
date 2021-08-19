<template>
  <div>
    <Nav />
    <PageHeader title="결제 확인" />
    <PayResult />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import PayResult from "../components/pay/PayResult";

export default {
  components: {
    PayResult,
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
