<template>
  <div>
    <Nav />
    <PageHeader title="내 서비스" />
    <ServicesPage />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import ServicesPage from "../components/user/ServicesPage";

export default {
  components: {
    ServicesPage,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "BeCone | My Services",
    };
  },
};
</script>
