<template>
  <div>
    <footer class="main-footer">
      <div class="auto-container">
        <!--Widgets Section-->
        <div class="widgets-section">
          <div class="row clearfix">
            <!--Column-->
            <div class="column col-xl-3 col-lg-6 col-md-6 col-sm-12">
              <div class="footer-widget logo-widget">
                <div class="widget-content">
                  <div class="logo">
                    <router-link to="/service"
                      ><img
                        id="fLogo"
                        src="@/common/images/be-con.jpg"
                        alt=""
                    /></router-link>
                  </div>
                  <div class="text">
                    Welcome to our BeCon
                  </div>
                  <ul class="social-links clearfix">
                    <li>
                      <a href="https://ko-kr.facebook.com/login/web/"><span class="fab fa-facebook-square"></span></a>
                    </li>
                    <li>
                      <a href="https://www.instagram.com/accounts/login/"><span class="fab fa-instagram"></span></a>
                    </li>
                    <li>
                      <a href="service"><span class="fab fa-pinterest-p"></span></a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>

            <!--Column-->
            <div class="column col-xl-3 col-lg-6 col-md-6 col-sm-12">
              <div class="footer-widget links-widget">
                <div class="widget-content">
                  <h6>Concert</h6>
                  <div class="row clearfix">
                    <div class="col-md-12 col-sm-12">
                      <ul>
                        <li><router-link to="/concertRegist">공연 신청</router-link></li>
                        <li><router-link to="/concertSchedule">공연 스케줄</router-link></li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!--Column-->
            <div class="column col-xl-3 col-lg-6 col-md-6 col-sm-12">
              <div class="footer-widget links-widget">
                <div class="widget-content">
                  <h6>Services</h6>
                  <div class="row clearfix">
                    <div class="col-md-6 col-sm-12">
                      <ul>
                        <li><router-link to="/concertRegist">FAQS</router-link></li>
                        <li><router-link to="/concertRegist">Q&A</router-link></li>
                      </ul>
                    </div> 
                  </div>
                </div>
              </div>
            </div>

            <!--Column-->
            <div class="column col-xl-3 col-lg-6 col-md-6 col-sm-12">
              <div class="footer-widget info-widget">
                <div class="widget-content">
                  <h6>CONTACT</h6>
                  <ul class="contact-info">
                    <li>
                      <span class="icon flaticon-pin-1"></span> 경상북도 구미시 진평동 498-2 그레이 503호
                    </li>
                    <li>
                      <span class="icon flaticon-call"></span
                      >010 5137 8979 (Tel. 055 363 8972)
                    </li>
                    <li>
                      <span class="icon flaticon-email-2"></span
                      >beconManager@gmail.com
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- Footer Bottom -->
      <div class="footer-bottom">
        <div class="auto-container">
          <div class="inner clearfix">
            <div class="copyright">&copy; copyright 2021 by Be-Con.com</div>
          </div>
        </div>
      </div>
    </footer>

    <a
      @click="scrollTop"
      class="scroll-to-target scroll-to-top"
      :style="`display: ${scrollBtn ? 'inline' : 'none'}`"
      href="#"
      ><i class="fa fa-angle-up"></i
    ></a>
  </div>
</template>

<script>
export default {
  name: "Footer",
  data() {
    return {
      scrollBtn: false,
    };
  },
  mounted() {
    window.addEventListener("scroll", this.handleScroll);
  },

  methods: {
    handleScroll() {
      if (window.scrollY > 70) {
        this.scrollBtn = true;
      } else if (window.scrollY < 70) {
        this.scrollBtn = false;
      }
    },

    scrollTop() {
      window.scrollTo(0, 0);
    },
  },
};
</script>

<style scoped>
.row {
  margin: 0 -15px;
  justify-content: center;
}</style>
