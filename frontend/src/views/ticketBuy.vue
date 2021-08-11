<template>
  <div>
    <Nav />
    <PageHeader title="Ticket Buy" />
    <TicketBuy :concert="$route.params.concert"/>
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/Nav";
import PageHeader from "../components/PageHeader";
import Footer from "../components/Footer";
import TicketBuy from "../components/TicketBuy.vue";
export default {
  components: {
    TicketBuy,
    Footer,
    PageHeader,
    Nav,
  },
  head() {
    return {
      title: "Be-con | Ticketing | Ticket Info",
    };
  },
};
</script>
