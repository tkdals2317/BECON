<template>
  <section class="services-section-three padd-top">
    <div class="auto-container">
      <div class="services">
        <div class="row clearfix">
          <!--Service Block-->
          <div class="service-block-two col-xl-3 col-lg-6 col-md-6 col-sm-12 wow fadeInUp animated" data-wow-delay="0ms" data-wow-duration="1500ms" style="visibility: visible; animation-duration: 1500ms; animation-delay: 0ms; animation-name: fadeInUp;">
            <div class="inner-box">
              <div class="bottom-curve"></div>
              <div class="icon-box"><span class="flaticon-vector"></span></div>
              <h5><div @click="moveMyPage">My Info!</div></h5>
              <div class="text">내 정보 확인 및 <br>수정</div>
              <div class="link-box"><div @click="moveMyPage"><span class="fa fa-angle-right"></span></div></div>
            </div>
          </div>

          <!--Service Block-->
          <div class="service-block-two col-xl-3 col-lg-6 col-md-6 col-sm-12 wow fadeInUp animated" data-wow-delay="300ms" data-wow-duration="1500ms" style="visibility: visible; animation-duration: 1500ms; animation-delay: 300ms; animation-name: fadeInUp;">
            <div class="inner-box">
              <div class="bottom-curve"></div>
              <div class="icon-box"><span class="flaticon-digital"></span></div>
              <h5><div @click="moveConcertCK">콘서트 Check</div></h5>
              <div class="text">신청한 콘서트 실시간 확인</div>
              <div class="link-box"><div @click="moveConcertCK"><span class="fa fa-angle-right"></span></div></div>
            </div>
          </div>

          <!--Service Block-->
          <div class="service-block-two col-xl-3 col-lg-6 col-md-6 col-sm-12 wow fadeInUp animated" data-wow-delay="600ms" data-wow-duration="1500ms" style="visibility: visible; animation-duration: 1500ms; animation-delay: 600ms; animation-name: fadeInUp;">
            <div class="inner-box">
              <div class="bottom-curve"></div>
              <div class="icon-box"><span class="flaticon-instant-camera"></span></div>
              <h5><a href="#">my 콘서트</a></h5>
              <div class="text">예매한 콘서트를 한눈에!</div>
              <div class="link-box"><a href="/myconcert"><span class="fa fa-angle-right"></span></a></div>
            </div>
          </div>

          <!--Service Block-->
          <div class="service-block-two col-xl-3 col-lg-6 col-md-6 col-sm-12 wow fadeInUp animated" data-wow-delay="900ms" data-wow-duration="1500ms" style="visibility: visible; animation-duration: 1500ms; animation-delay: 900ms; animation-name: fadeInUp;">
            <div class="inner-box">
              <div class="bottom-curve"></div>
              <div class="icon-box"><span class="flaticon-monitor"></span></div>
              <h5><a href="#">Q&A</a></h5>
              <div class="text">문의사항이 있다면 여기로!</div>
              <div class="link-box"><a href="#"><span class="fa fa-angle-right"></span></a></div>
            </div>
          </div>

        </div>
      </div>
    </div>
  </section>
</template>

<script>
  export default {
    name: "ServicesPage",
    methods: {
      moveMyPage() {
        this.$router.push("mypage");
      },
      moveConcertCK() {
        this.$router.push("concertCK");        
      },
    }
  }
</script>

<style scoped>

</style>
