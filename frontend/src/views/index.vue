<template>
  <div>
    <Nav />
    <Banner />
    <Services />
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
import Nav from "../components/Nav";
import Banner from "../components/Banner";
import Services from "../components/Services";
import GallerySection from "../components/GallerySection";
import FactSection from "../components/FactSection";
import TrustedSection from "../components/TrustedSection";
import ParallaxSection from "../components/ParallaxSection";
import BlogSection from "../components/BlogSection";
import CallToAction from "../components/CallToAction";
import Footer from "../components/Footer";

export default {
  components: {
    Footer,
    CallToAction,
    TrustedSection,
    ParallaxSection,
    BlogSection,
    FactSection,
    GallerySection,
    Services,
    Banner,
    Nav,
  },
};
</script>