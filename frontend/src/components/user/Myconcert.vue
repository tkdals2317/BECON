<template>
    <div>
      <section class="gallery-section similar-gallery">
        <div class="auto-container">
          <div class="sec-title centered">
            <h2>예매한 콘서트<span class="dot">.</span></h2>
          </div>
          <div class="row clearfix">
          </div>
        </div>
      </section>
      <section class="project-single">
        <div class="auto-container">
          <div class="row clearfix" v-for="myTicket in getMyConcertTicket" :key="myTicket.id">

            <div class="image-col col-lg-6 col-md-12 col-sm-12">
              <div class="inner"> 
                <figure class="image-box" @click="goDetail(myTicket.concert)">
                  <img :src="`https://i5d102.p.ssafy.io/thumbnailImg/${myTicket.concert.thumbnail.originName}`" class="image">
                </figure>
              </div>
            </div>

            <div class="text-col col-lg-4 col-md-12 col-sm-12">
              <div class="inner">
                <div class="text-content">
                  <h5>{{ myTicket.concert.title }}</h5>
                  <ul class="info">
                    <!-- <li><strong>가수:</strong> <br>{{ myTicket.concert.title }}</li> -->
                    <li><strong>Ticket</strong> <br>{{ myTicket.type }}</li>
                    <li><strong>price:</strong> <br>{{ myTicket.price }} 원</li>
                    <li><strong>Category:</strong> <br>{{ myTicket.concert.category.name }}</li>
                    <li><strong>Date:</strong> <br>{{ myTicket.concert.startTime }}</li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';
    export default {
      name: "Myconcert",
      created() {
        window.scrollTo(0, 0);
        this.requestUserInfo();
      },
      computed: {
        ...mapGetters("user",["getUserInfo"]),
        ...mapGetters("ticket", ["getMyConcertTicket"])
      },
      methods: {
        ...mapActions("user", ["requestUserInfo"]),
        ...mapActions("ticket", ["findMyTicket"]),
        ...mapActions("concert", ["findConcertDetail"]),
        goDetail(concertInfo) {
          this.findConcertDetail(concertInfo)
          this.$router.push({
            name: "ConcertDetail",
          });
        },
      }
    }
</script>

<style scoped>
.image {
  width: 770px !important;
  height: 466px !important;
}
</style>
