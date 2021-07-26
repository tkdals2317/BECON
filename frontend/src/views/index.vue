<template>
  <div>
    <Nav />
    <Banner />
    <!-- <Services /> -->
    <!-- <LiveSection /> -->
    <!-- <WedoSection /> -->
    <GallerySection />
    <ParallaxSection />
    <BlogSection />
    <!-- <TeamSection /> -->
    <FactSection />
    <TrustedSection />
    <CallToAction />
    <Footer />
  </div>
</template>

<script>
import Nav from "../components/Nav";
import Banner from "../components/Banner";
// import Services from "../components/Services";
// import LiveSection from "../components/LiveSection";
// import WedoSection from "../components/WedoSection";
import GallerySection from "../components/GallerySection";
import FactSection from "../components/FactSection";
import TrustedSection from "../components/TrustedSection";
// import TeamSection from "../components/TeamSection";
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
    // TeamSection,
    BlogSection,
    FactSection,
    GallerySection,
    // WedoSection,
    // LiveSection,
    // Services,
    Banner,
    Nav,
  },
};
</script>
