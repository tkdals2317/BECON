<template>
  <div>
    <Nav />
    <PageHeader title="Ticketing" />
    <Ticket :concertId="$route.params.concertId"/>
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/Nav";
import PageHeader from "../components/PageHeader";
import Footer from "../components/Footer";
import Ticket from "../components/Ticket";
export default {
  components: {
    Ticket,
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
