<template>
  <div>
    <Nav />
    <PageHeader title="mypage" />
    <QuoteSectionThree />
    <CallToActionThree />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import QuoteSectionThree from "../components/unused/QuoteSectionThree";
import CallToActionThree from "../components/unused/CallToActionThree";

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
      title: "BeCon | FAQs",
    };
  },
};
</script>
