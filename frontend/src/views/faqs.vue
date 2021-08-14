<template>
  <div>
    <Nav />
    <PageHeader title="FAQS" />
    <FAQS />
    <CallToActionThree />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import FAQS from "../components/user/FAQS";
import CallToActionThree from "../components/unused/CallToActionThree";

export default {
  components: {
    CallToActionThree,
    FAQS,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "BeCon | FAQs",
    };
  },
};
</script>
