<template>
  <div>
    <Nav />
    <PageHeader title="결제" />
    <QnAResult />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import QnAResult from "../components/user/QnAResult";

export default {
  components: {
    QnAResult,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "BeCon | SUCCESS",
    };
  },
};
</script>
