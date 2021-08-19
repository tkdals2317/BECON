<template>
  <div>
    <Nav />
    <PageHeader title="내 정보" />
    <MyPage />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import MyPage from "../components/user/MyPage";

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
