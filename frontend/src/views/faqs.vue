<template>
  <div>
    <Nav />
    <PageHeader3 title="FAQS" />
    <FAQS />
    <CallToActionThree />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader3 from "../components/layout/PageHeader3";
import Footer from "../components/layout/Footer";
import FAQS from "../components/user/FAQS";
import CallToActionThree from "../components/unused/CallToActionThree";

export default {
  components: {
    CallToActionThree,
    FAQS,
    Footer,
    PageHeader3,
    Nav,
  },
  head() {
    return {
      title: "BeCon | FAQs",
    };
  },
};
</script>
