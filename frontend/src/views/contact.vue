<template>
  <div>
    <Nav />
    <PageHeader title="Contact" />
    <ContactPage />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/Nav";
import PageHeader from "../components/PageHeader";
import ContactPage from "../components/ContactPage";
import Footer from "../components/Footer";
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
