<template>
  <div>
    <Nav />
    <PageHeader2 title="티켓팅" />
    <Ticket :concertId="$route.params.concertId" />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader2 from "../components/layout/PageHeader2";
import Footer from "../components/layout/Footer";
import Ticket from "../components/user/Ticket";

export default {
  components: {
    Ticket,
    Footer,
    PageHeader2,
    Nav,
  },
  head() {
    return {
      title: "BeCon | ticketing",
    };
  },
};
</script>
