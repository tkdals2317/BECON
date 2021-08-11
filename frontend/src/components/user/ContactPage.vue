<template>
  <section class="contact-section">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>SINGER<span class="dot">.</span></h2>
      </div>

      <div class="upper-info">
        <div class="row clearfix">
          <div
            class="info-block col-xl-3 col-lg-6 col-md-6 col-sm-12 wow fadeInUp"
            data-wow-delay="0ms"
            data-wow-duration="1500ms"
          >
            <div class="inner-box">
              <h5>블랙핑크</h5>
              <div class="text">
                <ul class="info">
                  <li>YG</li>
                  <li>
                    <a href="mailto:needhelp@linoor.com">needhelp@linoor.com</a>
                  </li>
                  <li><a href="tel:666888000">1</a></li>
                </ul>
              </div>
            </div>
          </div>

          <div
            class="info-block col-xl-3 col-lg-6 col-md-6 col-sm-12 wow fadeInUp"
            data-wow-delay="300ms"
            data-wow-duration="1500ms"
          >
            <div class="inner-box">
              <h5>원더걸스</h5>
              <div class="text">
                <ul class="info">
                  <li>JYP</li>
                  <li>
                    <a href="mailto:needhelp@linoor.com">needhelp@linoor.com</a>
                  </li>
                  <li><a href="tel:666888000">2</a></li>
                </ul>
              </div>
            </div>
          </div>

          <div
            class="info-block col-xl-3 col-lg-6 col-md-6 col-sm-12 wow fadeInUp"
            data-wow-delay="600ms"
            data-wow-duration="1500ms"
          >
            <div class="inner-box">
              <h5>소녀시대</h5>
              <div class="text">
                <ul class="info">
                  <li>SM</li>
                  <li>
                    <a href="mailto:needhelp@linoor.com">needhelp@linoor.com</a>
                  </li>
                  <li><a href="tel:666888000">3</a></li>
                </ul>
              </div>
            </div>
          </div>

          <div
            class="info-block col-xl-3 col-lg-6 col-md-6 col-sm-12 wow fadeInUp"
            data-wow-delay="900ms"
            data-wow-duration="1500ms"
          >
            <div class="inner-box">
              <h5>빅뱅</h5>
              <div class="text">
                <ul class="info">
                  <li>YG</li>
                  <li>
                    <a href="mailto:needhelp@linoor.com">needhelp@linoor.com</a>
                  </li>
                  <li><a href="tel:666888000">4</a></li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>

      
      <div class="form-box">
        <div class="sec-title">
          <h2>register artist<span class="dot">.</span></h2>
        </div>
        <div class="default-form">
          <form method="post" action="#" id="contact-form">
            <div class="row clearfix">
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input
                    type="text"
                    name="username"
                    value=""
                    placeholder="Your Name"
                    required=""
                  />
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input
                    type="email"
                    name="email"
                    value=""
                    placeholder="Email Address"
                    required=""
                  />
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input
                    type="text"
                    name="phone"
                    value=""
                    placeholder="Phone Number"
                    required=""
                  />
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input
                    type="text"
                    name="subject"
                    value=""
                    placeholder="Subject"
                    required=""
                  />
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <div class="field-inner">
                  <textarea
                    name="message"
                    placeholder="Write Message"
                    required=""
                  ></textarea>
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <button class="theme-btn btn-style-one">
                  <i class="btn-curve"></i>
                  <span class="btn-title">Send message</span>
                </button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "ContactPage",
};
</script>

<style scoped></style>
