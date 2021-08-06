<template>
  <div>
    <Nav />
    <PageHeader title="FAQ" />
    <!-- <FaqSection /> -->
    <QuoteSectionThree />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import QuoteSectionThree from "../components/unused/QuoteSectionThree";
// import FaqSection from "../components/unused/FaqSection";

export default {
  components: {
    // FaqSection,
    QuoteSectionThree,
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
