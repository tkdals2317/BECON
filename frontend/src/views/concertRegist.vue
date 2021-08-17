<template>
  <div>
    <Nav />
    <PageHeader2 title="콘서트 등록" />
    <ConcertRegistPage />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader2 from "../components/layout/PageHeader2";
import Footer from "../components/layout/Footer";
import ConcertRegistPage from "../components/concert/ConcertRegistPage";

export default {
  components: {
    ConcertRegistPage,
    Footer,
    PageHeader2,
    Nav,
  },
  head() {
    return {
      title: "BeCon | Concert Regist",
    };
  },
};
</script>
