<template>
  <div>
    <Nav />
    <PageHeader title="결제" />
    <Payment />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import Payment from "../components/pay/Payment";

export default {
  components: {
    Payment,
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
