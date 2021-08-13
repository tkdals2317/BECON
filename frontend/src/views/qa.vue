<template>
  <div>
    <Nav />
    <PageHeader title="Q&A" />
    <QA />
    <CallToActionThree />
    <Footer />
  </div>  
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import QA from "../components/user/QA";
import Footer from "../components/layout/Footer";
import CallToActionThree from "../components/unused/CallToActionThree";


export default {
  components: {
    QA,
    CallToActionThree,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "Be-con | QA ",
    };
  },
};
</script>
