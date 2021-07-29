<template>
  <header
    :class="`main-header header-style-one ${sticky ? 'fixed-header' : ''}`"
  >
    <!-- Header Upper -->
    <div class="header-upper">
      <div class="inner-container clearfix">
        <!--Logo-->
        <div class="logo-box">
          <div class="logo">
            <a href="/" title="Linoor - Digital Agency Template">
            <img
                src="@/common/images/be-conlogo.png"
                id="thm-logo"
                alt="Linoor - DIgital Agency HTML Template"
                title="Linoor - DIgital Agency Template"
            /></a>
          </div>
        </div>
        <div class="nav-outer clearfix">
          <!--Mobile Navigation Toggler-->
          <div class="mobile-nav-toggler">
            <span @click="mobileToggle = !mobileToggle" class="icon flaticon-menu-2"></span><span class="txt">Menu</span>
          </div>

          <!-- Main Menu -->
          <nav class="main-menu navbar-expand-md navbar-light">
            <div class="collapse navbar-collapse show clearfix">
              <ul class="navigation clearfix">
                <li class="current dropdown">
                  <a href="/">Home</a>
                  <ul>
                    <li><router-link to="/">Home</router-link></li>
                    <!-- <li><router-link to="/contact">Page1</router-link></li>
                    <li><router-link to="/faqs">Page2</router-link></li>
                    <li><router-link to="/notfound">Page3</router-link></li> -->
                  </ul>
                </li>
                <li class="dropdown">
                  <a href="#">Concert</a>
                  <ul>
                    <li><router-link to="/concertRegist">Concert Regist</router-link></li>
                    <li><router-link to="/concertPage">Concert Enter</router-link></li>
                    <li><router-link to="/testimonials">Concert Schedule</router-link></li>
                    <li><router-link to="/not-found">Concert Search</router-link></li>
                  </ul>
                </li>
                <li class="dropdown">
                  <a href="#">Services</a>
                  <ul>
                    <li><router-link to="/services">FAQs</router-link></li>
                    <li><router-link to="/web-development">Q&A</router-link>
                  </li>
                  </ul>
                </li>
              </ul>
            </div>
          </nav>
        </div>
        <div class="other-links clearfix">
          <div class="fun-box">
            <div class="call-us">
              <a class="link">
                <span class="icon"></span>
                <div v-if="!isLogin">
                  <span class="funBtn"><router-link to="/regist" class="nav1">SignUp</router-link></span>
                  <span class="funBtn"><router-link to="/login" class="nav1">Login</router-link></span>
                </div>
                <div v-if="isLogin">
                  <span class="funBtn"><router-link to="/service" class="nav1">MyService</router-link></span>
                  <span class="funBtn" @click="clickLogout">Logout</span>
                </div>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--End Header Upper-->

    <nav class="mobile-nav__container">
      <!-- content is loading via js -->

      <div
        :class="`collapse navbar-collapse ${
          mobileToggle ? 'show' : ''
        } clearfix`"
      >
        <ul class="navigation clearfix">
                <li class="current dropdown">
                  <a href="/">Home</a>
                  <ul>
                    <li><router-link to="/">Home</router-link></li>
                    <!-- <li><router-link to="/contact">Page1</router-link></li>
                    <li><router-link to="/faqs">Page2</router-link></li>
                    <li><router-link to="/notfound">Page3</router-link></li> -->
                  </ul>
                </li>
                <li class="dropdown">
                  <a href="#">Concert</a>
                  <ul>
                    <li><router-link to="/concertRegist">Concert Regist</router-link></li>
                    <li><router-link to="/EX">Concert EX</router-link></li>
                    <li><router-link to="/testimonials">Concert Schedule</router-link></li>
                    <li><router-link to="/not-found">Concert Search</router-link></li>
                  </ul>
                </li>
                <li class="dropdown">
                  <a href="#">Services</a>
                  <ul>
                    <li><router-link to="/services">FAQs</router-link></li>
                    <li><router-link to="/web-development">Q&A</router-link>
                  </li>
                  </ul>
                </li>
              </ul>
      </div>
    </nav>
  </header>
</template>

<script>
import {mapState, mapGetters} from 'vuex';
export default {
  name: "Nav",
  data() {
    return {
      isLogin:false,
      sticky: false,
      mobileToggle: false,
    };
  },
  created(){
    if(localStorage.getItem("accessToken")!=null){
        this.isLogin=true;
    }
  },
  mounted() {
    window.addEventListener("scroll", this.handleScroll);

    const mobileNav = document.querySelector(".mobile-nav__container");
    const dropdownMenu = mobileNav.querySelectorAll(".dropdown");

    for (let i = 0; i < dropdownMenu.length; i++) {
      dropdownMenu[i].addEventListener("click", function () {
        this.classList.toggle("open");
        this.classList.toggle("current");
      });
    }
  },
  computed:{
    ...mapGetters('user',["getAccessToken"]),
    ...mapState('user',["accessToken"])
  },
  methods: {
    handleScroll() {
      if (window.scrollY > 70) {
        this.sticky = true;
      } else if (window.scrollY < 70) {
        this.sticky = false;
      }
    },
    clickLogout() {
      localStorage.removeItem('accessToken');
      location.href = "/";
    },
  },
};
</script>

<style scoped>
.main-header .other-links .fun-box {
  position: relative;
  float: left;
  padding: 35px 0px;
}

.main-header .other-links .fun-box .link {
  position: relative;
  display: block;
  padding-top: 4px;
  text-transform: uppercase;
  letter-spacing: 0.05em;
  padding-left: 60px;
  color: #ffffff;
}

.header-style-two.fixed-header .other-links .fun-box .link {
  color: #ffffff;
}

.main-header .other-links .fun-box .link .icon {
  position: absolute;
  left: 0;
  top: 0;
  width: 44px;
  height: 42px;
  background: url(../common/images/icons/chat-icon.png) left center no-repeat;
}

.main-header .other-links .fun-box .sub-text {
  position: relative;
  display: block;
  font-size: 14px;
  font-weight: 500;
  line-height: 18px;
}

.main-header .other-links .fun-box .funBtn {
  position: relative;
  display: block;
  font-size: 20px;
  font-weight: 400;
  line-height: 24px;
}

.main-header .other-links .fun-box .funBtn:hover {
  text-decoration: underline;
}

.nav1 {
  color: #ffffff;
}
</style>
