<template>
  <div>
    <Nav />
    <PageHeader title="Singer" />
    <Singer />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import Singer from "../components/user/Singer";

export default {
  components: {
    Footer,
    PageHeader,
    Nav,
    Singer,
  },
  head() {
    return {
      title: "Linoor | Singer",
    };
  },
};
</script>
