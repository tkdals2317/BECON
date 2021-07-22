<template>
  <div>
    <Nav />
    <PageHeader title="Blog Sidebar" />
    <BlogSidebar />
    <Footer />
  </div>
</template>
<style>
  @import 'https://fonts.googleapis.com/css2?family=Teko:wght@300;400;500;600;700&display=swap';
  @import 'https://unpkg.com/element-plus/lib/theme-chalk/index.css';
  @import './main.css';
  @import '../../common/css/common.css';
  @import '../../common/css/element-plus.css';
  @import '../../common/css/animate.css';
  @import '../../common/css/bootstrap.css';
  @import '../../common/css/custom-animate.css';
  @import '../../common/css/flaticon.css';
  @import '../../common/css/fontawesome-all.css';
  @import '../../common/css/hover.css';
  @import '../../common/css/responsive.css';
  @import '../../common/css/rtl.css';
  @import '../../common/css/style.css';
  @import '../../common/css/colors/color-default.css';
  @import '../../common/plugins/glightbox/glightbox.min.css';
</style>
<script>
  import Nav from "../conferences/Nav";
  import PageHeader from "../conferences/PageHeader";
  import Footer from "../conferences/Footer";
  import BlogSidebar from "../conferences/BlogSidebar";
  export default {
    components: {
      BlogSidebar,
      Footer,
      PageHeader,
      Nav
    },
    head(){
      return {
        title: "Linoor | Blog Sidebar"
      }
    }
  }
</script>
