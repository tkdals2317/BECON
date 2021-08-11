<template>
  <div>
    <Nav />
    <PageHeader title="Register" />
    <Register />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import Register from "../components/user/Register";

export default {
  components: {
    Register,
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
