<template>
  <div>
    <Nav />
    <PageHeader2 title="Singer" />
    <Singer />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader2 from "../components/layout/PageHeader2";
import Footer from "../components/layout/Footer";
import Singer from "../components/user/Singer";

export default {
  components: {
    Footer,
    PageHeader2,
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
