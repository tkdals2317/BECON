<template>
  <div>
    <Nav />
    <PageHeader title="콘서트 등록" />
    <ConcertRegistPage />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import ConcertRegistPage from "../components/concert/ConcertRegistPage";

export default {
  components: {
    ConcertRegistPage,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "BeCon | Concert Regist",
    };
  },
};
</script>
