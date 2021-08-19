<template>
  <div>
    <Nav />
    <PageHeader title="로그인" />
    <LoginPage />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import LoginPage from "../components/user/LoginPage";

export default {
  components: {
    LoginPage,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "BeCon | Login",
    };
  },
};
</script>
