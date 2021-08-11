<template>
  <div>
    <Nav />
    <PageHeader title="결제" />
    <Payment />
    <!-- <Temp /> -->
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import Payment from "../components/pay/Payment";
// import Temp from "../components/pay/Temp";

export default {
  components: {
    Payment,
    Footer,
    PageHeader,
    Nav,
    // Temp,
  },
  head() {
    return {
      title: "BeCon | Login",
    };
  },
};
</script>
