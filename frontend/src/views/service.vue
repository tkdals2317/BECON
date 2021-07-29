<template>
  <div>
    <Nav />
    <PageHeader title="My Services" />
    <ServicesPage />
    <Footer />
  </div>
</template>
<script>
  import Nav from "../components/Nav";
  import PageHeader from "../components/PageHeader";
  import Footer from "../components/Footer";
  import ServicesPage from "../components/ServicesPage";
    export default {
    components: {
      ServicesPage,
      Footer,
      PageHeader,
      Nav
    },
    head(){
      return {
        title: "BeCone | My Services"
      }
    }
  }
</script>
