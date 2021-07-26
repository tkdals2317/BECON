<template>
  <div>
    <Nav />
    <Banner />
    <Services />
    <LiveSection />
    <!-- <WedoSection /> -->
    <GallerySection />
    <FactSection />
    <!-- <TrustedSection /> -->
    <!-- <TeamSection /> -->
    <!-- <ParallaxSection /> -->
    <BlogSection />
    <CallToAction />
    <Footer />
  </div>
</template>

<script>
import Nav from "../components/Nav";
import Banner from "../components/Banner";
import Services from "../components/Services";
import LiveSection from "../components/LiveSection";
// import WedoSection from "../components/WedoSection";
import GallerySection from "../components/GallerySection";
import FactSection from "../components/FactSection";
// import TrustedSection from "../components/TrustedSection";
// import TeamSection from "../components/TeamSection";
// import ParallaxSection from "../components/ParallaxSection";
import BlogSection from "../components/BlogSection";
import CallToAction from "../components/CallToAction";
import Footer from "../components/Footer";

export default {
  components: {
    Footer,
    CallToAction,
    BlogSection,
    // ParallaxSection,
    // TeamSection,
    // TrustedSection,
    FactSection,
    GallerySection,
    // WedoSection,
    LiveSection,
    Services,
    Banner,
    Nav,
  },
};
</script>
