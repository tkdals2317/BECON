<template>
  <div>
    <Nav />
    <PageHeader title="회원가입" />
    <Regist />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import Regist from "../components/user/Regist";

export default {
  components: {
    Regist,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "BeCon | SignUp",
    };
  },
};
</script>
