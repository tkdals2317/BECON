<template>
  <div>
    <Nav />
    <PageHeader title="Ticketing" />
    <ConcertRegistPage />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/Nav";
import PageHeader from "../components/PageHeader";
import Footer from "../components/Footer";
import ConcertRegistPage from "../components/Ticket";
export default {
  components: {
    ConcertRegistPage,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "BeCon | ticketing",
    };
  },
};
</script>
