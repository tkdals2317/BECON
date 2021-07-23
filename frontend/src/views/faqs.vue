<template>
  <div>
    <Nav />
    <PageHeader title="FAQs" />
    <QuoteSectionThree />
    <CallToActionThree />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/Nav";
import PageHeader from "../components/PageHeader";
import Footer from "../components/Footer";
import QuoteSectionThree from "../components/QuoteSectionThree";
import CallToActionThree from "../components/CallToActionThree";
export default {
  components: {
    CallToActionThree,
    QuoteSectionThree,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "Linoor | FAQs",
    };
  },
};
</script>
