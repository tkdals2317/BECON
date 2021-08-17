<template>
  <div>
    <PageHeader :title="getConcert.title" />
    <ConcertRoom />
  </div>
</template>
<script>
import PageHeader from "../components/layout/PageHeader";
import ConcertRoom from "../components/concert/ConcertRoom";
import { mapGetters } from "vuex";

export default {
  components: {
    ConcertRoom,
    PageHeader,
  },
  head() {
    return {
      title: "Be-con | Ex",
    };
  },
  computed: {
    ...mapGetters("room", ["getConcert"]),
  }
};
</script>
