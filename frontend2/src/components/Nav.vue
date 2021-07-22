<template>
  <header :class="`main-header header-style-one ${sticky ? 'fixed-header' : ''}`">

    <!-- Header Upper -->
    <div class="header-upper">
      <div class="inner-container clearfix">
        <!--Logo-->
        <div class="logo-box">
          <div class="logo"><a href="/" title="Linoor - Digital Agency Template"><img
            src="@/common/images/logo.png" id="thm-logo" alt="Linoor - DIgital Agency HTML Template"
            title="Linoor - DIgital Agency Template"></a></div>
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
                <li class="current dropdown"><a href="/">Home</a>
                  <ul>
                    <li><router-link to="/">Home Style 01</router-link></li>
                    <li><router-link to="/index-2">Home Style 02</router-link></li>
                    <li><router-link to="/index-3">Home Style 03</router-link></li>
                  </ul>
                </li>
                <li><router-link to="/about">About Us</router-link></li>
                <li class="dropdown"><a href="/team">Pages</a>
                  <ul>
                    <li><router-link to="/team">Our Team</router-link></li>
                    <li><router-link to="/testimonials">Testimonials</router-link></li>
                    <li><router-link to="/faqs">FAQs</router-link></li>
                    <li><router-link to="/not-found">404 Page</router-link></li>
                  </ul>
                </li>
                <li class="dropdown"><router-link to="/services">Services</router-link>
                  <ul>
                    <li><router-link to="/services">All Services</router-link></li>
                    <li><router-link to="/web-development">Website Development</router-link></li>
                    <li><router-link to="/graphic-designing">Graphic Designing</router-link></li>
                    <li><router-link to="/digital-marketing">Digital Marketing</router-link></li>
                    <li><router-link to="/seo">SEO & Content Writting</router-link></li>
                    <li><router-link to="/app-development">App Development</router-link></li>
                    <li><router-link to="/ui-designing">UI/UX Designing</router-link></li>
                  </ul>
                </li>
                <li class="dropdown"><router-link to="/portfolio">Portfolio</router-link>
                  <ul>
                    <li><router-link to="/portfolio">Portfolio</router-link></li>
                    <li><router-link to="/portfolio-single">Portfolio Single 01</router-link></li>
                    <li><router-link to="/portfolio-single-2">Portfolio Single 02</router-link></li>
                  </ul>
                </li>
                <li class="dropdown"><router-link to="/blog-grid">Blog</router-link>
                  <ul>
                    <li><router-link to="/blog">Blog Sidebar</router-link></li>
                    <li><router-link to="/blog-grid">Blog Grid View</router-link></li>
                    <li><router-link to="/blog-single">Blog Single</router-link></li>
                  </ul>
                </li>
                <li><router-link to="/contact">Contact</router-link></li>
              </ul>
            </div>
          </nav>
        </div>

        <div class="other-links clearfix">
          <div class="link-box">
            <div class="call-us">
              <a class="link" href="tel:6668880000">
                <span class="icon"></span>
                <span class="sub-text">Call Anytime</span>
                <span class="number">666 888 0000</span>
              </a>
            </div>
          </div>
        </div>


      </div>
    </div>
    <!--End Header Upper-->

    <nav class="mobile-nav__container">
      <!-- content is loading via js -->

      <div :class="`collapse navbar-collapse ${mobileToggle ? 'show' : ''} clearfix`">
        <ul class="navigation clearfix">
          <li class="dropdown"><a href="#">Home<div class="dropdown-btn"><span class="fa fa-angle-right"></span></div></a>
            <ul class="sub-menu">
              <li><router-link to="/">Home Style 01</router-link></li>
              <li><router-link to="/index-2">Home Style 02</router-link></li>
              <li><router-link to="/index-3">Home Style 03</router-link></li>
            </ul>
          </li>
          <li><router-link to="/about">About Us</router-link></li>
          <li class="dropdown"><a href="#">Pages<div class="dropdown-btn"><span class="fa fa-angle-right"></span></div></a>
            <ul class="sub-menu">
              <li><router-link to="/team">Our Team</router-link></li>
              <li><router-link to="/testimonials">Testimonials</router-link></li>
              <li><router-link to="/faqs">FAQs</router-link></li>
              <li><router-link to="/not-found">404 Page</router-link></li>
            </ul>
          </li>
          <li class="dropdown"><router-link to="#">Services<div class="dropdown-btn"><span class="fa fa-angle-right"></span></div></router-link>
            <ul class="sub-menu">
              <li><router-link to="/services">All Services</router-link></li>
              <li><router-link to="/web-development">Website Development</router-link></li>
              <li><router-link to="/graphic-designing">Graphic Designing</router-link></li>
              <li><router-link to="/digital-marketing">Digital Marketing</router-link></li>
              <li><router-link to="/seo">SEO & Content Writting</router-link></li>
              <li><router-link to="/app-development">App Development</router-link></li>
              <li><router-link to="/ui-designing">UI/UX Designing</router-link></li>
            </ul>
          </li>
          <li class="dropdown"><router-link to="#">Portfolio<div class="dropdown-btn"><span class="fa fa-angle-right"></span></div></router-link>
            <ul class="sub-menu">
              <li><router-link to="/portfolio">Portfolio</router-link></li>
              <li><router-link to="/portfolio-single">Portfolio Single 01</router-link></li>
              <li><router-link to="/portfolio-single-2">Portfolio Single 02</router-link></li>
            </ul>
          </li>
          <li class="dropdown"><router-link to="#">Blog<div class="dropdown-btn"><span class="fa fa-angle-right"></span></div></router-link>
            <ul class="sub-menu">
              <li><router-link to="/blog">Blog Sidebar</router-link></li>
              <li><router-link to="/blog-grid">Blog Grid View</router-link></li>
              <li><router-link to="/blog-single">Blog Single</router-link></li>
            </ul>
          </li>
          <li><router-link to="/contact">Contact</router-link></li>
        </ul>
      </div>
    </nav>

  </header>
</template>

<script>
  export default {
    name: "Nav",
    data(){
      return {
        sticky: false,
        mobileToggle: false
      }
    },
    mounted() {
      window.addEventListener('scroll', this.handleScroll);

      const mobileNav = document.querySelector('.mobile-nav__container');
      const dropdownMenu = mobileNav.querySelectorAll('.dropdown');
      
      for (let i = 0; i < dropdownMenu.length; i++) {
          dropdownMenu[i].addEventListener("click", function() {
          this.classList.toggle('open');
          this.classList.toggle('current');
          });
      }


    },
    methods: {

      handleScroll() {
        if (window.scrollY > 70) {
          this.sticky = true
        } else if (window.scrollY < 70) {
          this.sticky = false
        }
      },
    }
  }
</script>

<style scoped>

</style>
