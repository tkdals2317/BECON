<template>
  <div>
    <Nav />
    <PageHeader3 title="Q&A" />
    <QA />
    <CallToActionThree />
    <Footer />
  </div>  
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader3 from "../components/layout/PageHeader3";
import QA from "../components/user/QA";
import Footer from "../components/layout/Footer";
import CallToActionThree from "../components/unused/CallToActionThree";


export default {
  components: {
    QA,
    CallToActionThree,
    Footer,
    PageHeader3,
    Nav,
  },
  head() {
    return {
      title: "Be-con | QA ",
    };
  },
};
</script>
