<template>
  <section class="contact-section">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>내가 신청한 가수<span class="dot">.</span></h2>
      </div>

      <div class="upper-info">
        <div class="row clearfix">
          <div
            class="info-block col-xl-3 col-lg-6 col-md-6 col-sm-12 wow fadeInUp"
            data-wow-delay="0ms"
            data-wow-duration="1500ms"
          >
            <div class="inner-box">
              <h5>블랙핑크</h5>
              <div class="text">
                <ul class="info">
                  <li>YG</li>
                  <!-- <li>
                    <a href="mailto:needhelp@linoor.com">needhelp@linoor.com</a>
                  </li> -->
                    <img src="@/common/images/suji.jpg" alt=""/>
                </ul>
              </div>
            </div>
          </div>

          <div
            class="info-block col-xl-3 col-lg-6 col-md-6 col-sm-12 wow fadeInUp"
            data-wow-delay="300ms"
            data-wow-duration="1500ms"
          >
            <div class="inner-box">
              <h5>원더걸스</h5>
              <div class="text">
                <ul class="info">
                  <li>JYP</li>
                  <!-- <li>
                    <a href="mailto:needhelp@linoor.com">needhelp@linoor.com</a>
                  </li> -->
                    <img src="@/common/images/suji.jpg" alt=""/>
                </ul>
              </div>
            </div>
          </div>

          <div
            class="info-block col-xl-3 col-lg-6 col-md-6 col-sm-12 wow fadeInUp"
            data-wow-delay="600ms"
            data-wow-duration="1500ms"
          >
            <div class="inner-box">
              <h5>소녀시대</h5>
              <div class="text">
                <ul class="info">
                  <li>SM</li>
                  <!-- <li>
                    <a href="mailto:needhelp@linoor.com">needhelp@linoor.com</a>
                  </li> -->
                    <img src="@/common/images/suji.jpg" alt=""/>
                </ul>
              </div>
            </div>
          </div>

          <div
            class="info-block col-xl-3 col-lg-6 col-md-6 col-sm-12 wow fadeInUp"
            data-wow-delay="900ms"
            data-wow-duration="1500ms"
          >
            <div class="inner-box">
              <h5>빅뱅</h5>
              <div class="text">
                <ul class="info">
                  <li>YG</li>
                  <!-- <li>
                    <a href="mailto:needhelp@linoor.com">needhelp@linoor.com</a>
                  </li> -->
                    <img src="@/common/images/suji.jpg" alt=""/>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>

      
      <div class="form-box">
        <div class="sec-title">
          <h2>예매한 콘서트<span class="dot">.</span></h2>
        </div>
      </div>
      <div class="upper-info">
        <div class="row clearfix">
          <div
            class="info-block col-xl-3 col-lg-6 col-md-6 col-sm-12 wow fadeInUp"
            data-wow-delay="0ms"
            data-wow-duration="1500ms"
          >
            <div class="inner-box">
              <h5>블랙핑크</h5>
              <div class="text">
                <ul class="info">
                  <li>YG</li>
                    <img src="@/common/images/backcon4.jpg" alt=""/>
                </ul>
              </div>
            </div>
          </div>

          <div
            class="info-block col-xl-3 col-lg-6 col-md-6 col-sm-12 wow fadeInUp"
            data-wow-delay="300ms"
            data-wow-duration="1500ms"
          >
            <div class="inner-box">
              <h5>원더걸스</h5>
              <div class="text">
                <ul class="info">
                  <li>JYP</li>
                    <img src="@/common/images/backcon6.jpg" alt=""/>
                </ul>
              </div>
            </div>
          </div>

          <div
            class="info-block col-xl-3 col-lg-6 col-md-6 col-sm-12 wow fadeInUp"
            data-wow-delay="600ms"
            data-wow-duration="1500ms"
          >
            <div class="inner-box">
              <h5>잔나비</h5>
              <div class="text">
                <ul class="info">
                  <li>17:00</li>
                    <img src="@/common/images/backcon4.jpg" alt=""/>
                </ul>
              </div>
            </div>
          </div>

          <div class="service-block-two col-xl-3 col-lg-6 col-md-6 col-sm-12 wow fadeInUp animated" data-wow-delay="0ms" data-wow-duration="1500ms" style="visibility: visible; animation-duration: 1500ms; animation-delay: 0ms; animation-name: fadeInUp;">
            <div class="inner-box">
              <div class="bottom-curve"></div>
              <div class="icon-box"><span class="flaticon-vector"></span></div>
              <h5><div @click="moveMyPage">잔나비</div></h5>
              <div class="text">헤어져야하는 연인 <br>17:00</div>
              <div class="link-box"><div @click="moveMyPage"><span class="fa fa-angle-right"></span></div></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "ContactPage",
};
</script>

<style scoped></style>
