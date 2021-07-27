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
                src="@/common/images/logo.png"
                id="thm-logo"
                alt="Linoor - DIgital Agency HTML Template"
                title="Linoor - DIgital Agency Template"
            /></a>
          </div>
        </div>
        <div class="nav-outer clearfix">
          <!--Mobile Navigation Toggler-->
          <div class="mobile-nav-toggler">
            <span
              @click="mobileToggle = !mobileToggle"
              class="icon flaticon-menu-2"
            ></span
            ><span class="txt">Menu</span>
          </div>

          <!-- Main Menu -->
          <nav class="main-menu navbar-expand-md navbar-light">
            <div class="collapse navbar-collapse show clearfix">
              <ul class="navigation clearfix">
                <li class="current dropdown">
                  <a href="/">Home</a>
                  <ul>
                    <li><router-link to="/">Home</router-link></li>
                    <li><router-link to="/contact">Page1</router-link></li>
                    <li><router-link to="/faqs">Page2</router-link></li>
                    <li><router-link to="/notfound">Page3</router-link></li>
                  </ul>
                </li>
                <li class="dropdown">
                  <a href="/team">Concert</a>
                  <ul>
                    <li><router-link to="/concertRegist">Concert Regist</router-link></li>
                    <li><router-link to="/EX">Concert EX</router-link></li>
                    <li><router-link to="/testimonials">Concert Schedule</router-link></li>
                    <li><router-link to="/not-found">Concert Search</router-link></li>
                  </ul>
                </li>
                <li class="dropdown">
                  <router-link to="/services">Services</router-link>
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
                  <span class="number"><router-link to="/regist" class="nav1">SignUp</router-link></span>
                  <span class="funBtn"><router-link to="/login" class="nav1">Login</router-link></span>
                </div>
                <div v-if="isLogin">
                  <span class="number"><router-link to="/myPage" class="nav1">MyPage</router-link></span>
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
          <li class="dropdown">
            <a href="#"
              >Home
              <div class="dropdown-btn">
                <span class="fa fa-angle-right"></span></div
            ></a>
            <ul class="sub-menu">
              <li><router-link to="/">Home Style 01</router-link></li>
              <li><router-link to="/index-2">Home Style 02</router-link></li>
              <li><router-link to="/index-3">Home Style 03</router-link></li>
            </ul>
          </li>
          <li class="dropdown">
            <a href="#"
              >Concert
              <div class="dropdown-btn">
                <span class="fa fa-angle-right"></span></div
            ></a>
            <ul class="sub-menu">
              <li><router-link to="/team">Concert Regist</router-link></li>
              <li><router-link to="/EX">Concert EX</router-link></li>
              <li><router-link to="/testimonials">Concert Schedule</router-link></li>
              <li><router-link to="/faqs">Concert Search</router-link></li>
              <!-- <li><router-link to="/not-found">404 Page</router-link></li> -->
            </ul>
          </li>
          <li class="dropdown">
            <router-link to="#">Services<div class="dropdown-btn"><span class="fa fa-angle-right"></span></div></router-link>
            <ul class="sub-menu">
              <li><router-link to="/faqs">FAQs</router-link></li>
              <li><router-link to="/web-development">Q&A</router-link></li>
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
  padding: 26px 0px;
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