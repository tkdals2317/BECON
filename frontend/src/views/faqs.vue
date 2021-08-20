<template>
  <div>
    <Nav />
    <PageHeader3 title="자주 묻는 질문" />
    <FAQS />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader3 from "../components/layout/PageHeader3";
import Footer from "../components/layout/Footer";
import FAQS from "../components/user/FAQS";

export default {
  components: {
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
