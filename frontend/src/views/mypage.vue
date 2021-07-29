<template>
  <div>
    <Nav />
    <PageHeader title="My Info" />
    <MyPage />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/Nav";
import PageHeader from "../components/PageHeader";
import Footer from "../components/Footer";
import MyPage from "../components/MyPage";
export default {
  components: {
    MyPage,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "Be-con | My Services | My Info",
    };
  },
};
</script>
