<template>
  <div>
    <Nav />
    <BannerThree />
    <GallerySection />
    <ParallaxSection />
    <BlogSection />
    <FactSection />
    <TrustedSection />
    <CallToAction />
    <Footer />
    
  </div>
</template>

<script>
import Nav from "../components/layout/Nav";
import BannerThree from "../components/main/BannerThree";
import GallerySection from "../components/main/GallerySection";
import FactSection from "../components/main/FactSection";
import TrustedSection from "../components/main/TrustedSection";
import ParallaxSection from "../components/main/ParallaxSection";
import BlogSection from "../components/main/BlogSection";
import CallToAction from "../components/main/CallToAction";
import Footer from "../components/layout/Footer";

export default {
  components: {
    Footer,
    CallToAction,
    TrustedSection,
    ParallaxSection,
    BlogSection,
    FactSection,
    GallerySection,
    BannerThree,
    Nav,
    
  },
};
</script>
