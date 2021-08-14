<template>
  <div>
    <Nav />
    <PageHeader title="Ticketing" />
    <Ticket :concert="$route.params.concert" />
    <Footer />
  </div>
</template>
<script>
import Nav from "../components/layout/Nav";
import PageHeader from "../components/layout/PageHeader";
import Footer from "../components/layout/Footer";
import Ticket from "../components/user/Ticket";

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
