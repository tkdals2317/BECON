<template>
  <div>
    <Nav />
    <PageHeader title="ConcertRegist" />
    <ConcertRegistPage />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/Nav";
import PageHeader from "../components/PageHeader";
import Footer from "../components/Footer";
import ConcertRegistPage from "../components/ConcertRegistPage";
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
