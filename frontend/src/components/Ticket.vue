<template>
  <section class="contact-section">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>티켓 예매</h2>
      </div>



      <div class="form-box">
        <div class="sec-title">
          <h2></h2>
        </div>
        <div class="default-form">
          <form method="post" action="#" id="contact-form">
            <div class="row clearfix">
              <div class="form-group col-lg-12 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="text" name="username" value="" placeholder="이름(단체)명 불러와짐" required="">
                </div>
              </div>
              
              <div class="form-group col-lg-12 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="email" name="email" value="" placeholder="공연 제목 불러와짐" required="">
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="text" name="phone" value="" placeholder="시작일 선택하기" required="">
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="text" name="phone" value="" placeholder="종료일 선택하기" required="">
                </div>
              </div>
              <h2>
                <select class="form-select form-select-lg mb-6" aria-label=".form-select-lg example">
                <option selected>공연날짜</option>
                <option value="1">21-08-07</option>
                <option value="2">21-08-14</option>
                <option value="3">21-08-21</option>
                </select>
              </h2>
                <h2>
                    <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
                    <label class="form-check-label" for="inlineCheckbox1">STAND 티켓</label>
                    </div>
                    <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
                    <label class="form-check-label" for="inlineCheckbox2">VIP 티켓</label>
                    </div>
                </h2>

                <h4>
                    <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                    <label class="form-check-label" for="flexCheckDefault">
                        개인정보 수집 동의
                    </label>
                    </div>
                    <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" >
                    <label class="form-check-label" for="flexCheckChecked">
                        환불내역을 읽어보았습니다.
                    </label>
                    </div>
                </h4>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <button class="theme-btn btn-style-one">
                  <i class="btn-curve"></i>
                  <span class="btn-title">예매하기</span>
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
        name: "Ticket"
    }
</script>

<style scoped>

</style>
