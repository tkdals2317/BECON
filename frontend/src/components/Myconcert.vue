<template>
    <div>
      <section class="gallery-section similar-gallery">
        <div class="auto-container">
          <div class="sec-title centered">
            <h2>예매한 콘서트<span class="dot">.</span></h2>
          </div>
          <div class="row clearfix">
          </div>
        </div>
      </section>
      <section class="project-single">
        <div class="auto-container">
          <div class="row clearfix">

            <div class="image-col col-lg-6 col-md-12 col-sm-12">
              <div class="inner"> 
                <figure class="image-box">
                  <a href="/concertDetail" class="portfolio" data-fancybox="gallery">
                  <img src="@/common/images/backcon5.jpg" alt="" class="image"></a>
                </figure>
              </div>
            </div>

            <div class="text-col col-lg-4 col-md-12 col-sm-12">
              <div class="inner">
                <div class="text-content">
                  <h5>콘서트 이름</h5>
                  <ul class="info">
                    <li><strong>가수:</strong> <br>잔나비</li>
                    <li><strong>price:</strong> <br>50000원</li>
                    <li><strong>Category:</strong> <br>Graphic, Illustrations</li>
                    <li><strong>Date:</strong> <br>20 May, 2020</li>
                  </ul>
                </div>
              </div>
            </div>

            <div class="image-col col-lg-6 col-md-12 col-sm-12">
              <div class="inner">
                <figure class="image-box">
                  <a href="/concertDetail" class="portfolio" data-fancybox="gallery">
                  <img src="@/common/images/backcon4.jpg" alt="" class="image"></a>
                </figure>
              </div>
            </div>

            <div class="text-col col-lg-4 col-md-12 col-sm-12">
              <div class="inner">
                <div class="text-content">
                  <h5>외로운연인</h5>
                  <ul class="info">
                    <li><strong>가수:</strong> <br>잔나비</li>
                    <li><strong>price:</strong> <br>50000원</li>
                    <li><strong>Category:</strong> <br>Graphic, Illustrations</li>
                    <li><strong>Date:</strong> <br>20 May, 2020</li>
                  </ul>
                </div>
              </div>
            </div>

          </div>
        </div>
      </section>
    </div>
</template>

<script>
    export default {
      name: "Myconcert",
    }
</script>

<style scoped>
.image {
  width: 770px !important;
  height: 466px !important;
}
</style>
