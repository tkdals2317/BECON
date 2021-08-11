<template>
  <div>
    <Nav />
    <PageHeader title="Contact" />
    <ContactPage />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import ContactPage from "../components/user/ContactPage";
import Footer from "../components/layout/Footer";

export default {
  components: {
    ContactPage,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "Linoor | Contact Us",
    };
  },
};
</script>
