<template>
  <div>
    <Nav />
    <PageHeader title="Login" />
    <ContactPage />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/Nav";
import PageHeader from "../components/PageHeader";
import Footer from "../components/Footer";
import ContactPage from "../components/LoginPage";
export default {
  components: {
    ContactPage,
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
