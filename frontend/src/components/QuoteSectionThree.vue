<template>
  <section class="get-quote-three">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>마이페이지<span class="dot">.</span></h2>
        <br>
        <img src="@/common/images/수지.jpg" alt=""/>
        <br>
      </div>
      <div class="form-box">
        <div class="default-form">
          <form method="post" action="#" id="contact-form">
            <div class="row clearfix">
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <h3>이름:</h3>
              </div>
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
                <h3>아이디:</h3>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input
                    type="text"
                    name="Id"
                    value=""
                    placeholder="Id"
                    required=""
                  />
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <h3>이메일:</h3>
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
                <h3>전화번호:</h3>
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
                <h3>생년월일:</h3>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input
                    type="text"
                    name="subject"
                    value=""
                    placeholder="yy-mm-dd"
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
                  <span class="btn-title">정보 수정하기</span>
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
  name: "QuoteSectionThree",
};
</script>

<style scoped></style>
