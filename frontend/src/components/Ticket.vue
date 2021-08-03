<template>
  <section class="contact-section">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>티켓 예매</h2>
      </div>

      <div class="form-box">
        <div class="sec-title">
          <!-- <h2>
              <select class="form-select form-select-xl mb-6" aria-label=".form-select-xl example">
              <option selected>공연날짜</option>
              <option value="1">21-08-07</option>
              <option value="2">21-08-14</option>
              <option value="3">21-08-21</option>
              </select>
              
          </h2> -->
        <!-- </div>
        <div class="default-form">
          <form method="post" action="#" id="contact-form">
            <div class="row clearfix">
              <div class="form-group col-lg-12 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="text" name="username" value="" placeholder="이름(단체)명 불러와짐" required="">
                  <input class="form-control" type="text" value="잔나비" aria-label="readonly input example" readonly>
                </div>
              </div>
              
              <div class="form-group col-lg-12 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="email" name="email" value="" placeholder="공연 제목 불러와짐" required="">
                  <input class="form-control" type="text" value="주저하는 연인들을 위해" aria-label="readonly input example" readonly>
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="text" name="phone" value="" placeholder="시작시간" required="">
                  <input class="form-control" type="text" value="18:00" aria-label="readonly input example" readonly>
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="text" name="phone" value="" placeholder="종료시간" required="">
                  <input class="form-control" type="text" value="22:00" aria-label="readonly input example" readonly>
                </div>
              </div> -->
        
                <!-- <div class="form-group col-lg-6 col-md-6 col-sm-6">
                 <div class="card " style="width: 20rem;">
                  <img src="@/common/images/backcon4.jpg" class="card-img-top" alt="...">
                  <div class="card-body">
                    <div class="card-text">
                      <h4>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1" v-model="toggle" true-value="yes" false-value="no">
                            <label class="form-check-label" for="inlineCheckbox1">STAND 티켓</label>
                        </div>
                          <h5 class="card-title">가격 30000원</h5>
                      </h4>
                    </div>
                    <h4>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">   
                        <a href="#" class="btn btn-danger">구매하기</a> 
                      </div>
                    </h4>
                  </div>
                </div>
              </div>
                <div class="form-group col-lg-6 col-md-6 col-sm-6">
                  <div class="card" style="width: 20rem;">
                  <img src="@/common/images/backcon4.jpg" class="card-img-top" alt="...">
                  <div class="card-body">
                    <div class="card-text">
                      <h4>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
                            <label class="form-check-label" for="inlineCheckbox1">VIP 티켓</label>
                        </div>
                        <h5 class="card-title">가격: 50000원</h5>
                      </h4>
                    </div>
                    <h4>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">   
                        <a href="#" class="btn btn-danger">구매하기</a> 
                      </div>
                    </h4> -->
  
                  <!-- </div> -->
                <!-- </div>
              </div> -->
               <div class="ticket ticket-1">
                <div class="date">
                  <span class="day">24</span>
                  <span class="month-and-time">JAN<br><span class="small">8PM</span></span>
                </div>
                <div class="artist">
                  <span class="name">STAND</span>
                  <br>
                  <span class="live small">30000원</span>
                </div>
                <div class="location">
                  <span>공연제목</span>
                  <br>
                  <span class="live small"><span>가수이름</span></span>
                </div>
                <div class="rip">
                </div>
                <div class="cta">
                  <button class="buy" href="#">BUY TICKET</button>
                </div>
              </div>
              
              <div class="ticket ticket-2">
                <div class="date">
                  <span class="day">24</span>
                  <span class="month-and-time">JAN<br><span class="small">8PM</span></span>
                </div>
                <div class="artist">
                  <span class="name"> VVVIP </span>
                  <br>
                  <span class="live small">50000원</span>
                </div>
                <div class="location">
                  <span>공연제목</span>
                  <br>
                  <span class="small"><span>가수이름</span></span>
                </div>
                <div class="rip">
                </div>
                <div class="cta">
                  <button class="buy" href="#">BUY TICKET</button>
                </div>
              </div>
                <!-- <h2>
                    <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
                    <label class="form-check-label" for="inlineCheckbox1">STAND 티켓</label>
                    </div>
                    <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
                    <label class="form-check-label" for="inlineCheckbox2">VIP 티켓</label>
                    </div>
                </h2> -->

                <!-- <h4>
                    <div class="form-check" style="color:red;">
                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                    <label class="form-check-label" for="flexCheckDefault">
                        개인정보 수집 동의
                    </label>
                    </div>
                    <div class="form-check" style="color:red;">
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
                </button> -->
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

body {
  background-color: #436ea5;
}

.ticket {
  font-family: sans-serif;
  background-repeat: no-repeat;
  background-position: top;
  background-size: 100%;
  background-color: #04030C;
  width: 700px;
  height: 300px;
  border-radius: 15px;
  -webkit-filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
            filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3)); 
  display: block;
  margin: 10% auto auto auto;
  color: #fff;;
}

.date {
  margin: 15px;
  -webkit-filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
            filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3)); 
}

.date .day{
  font-size: 80px;
  float: left;
}

.date .month-and-time {
  float: left;
  margin: 15px 0 0 0;
  font-weight: bold;
}

.artist {
  font-size: 40px;
  margin: 10px 100px 0 40px;
  float: left;
  font-weight: bold;
  -webkit-filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
            filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3)); 
}

.location {
  float: left;
  margin: 135px 0 0 ;
  font-size: 30px;
  font-weight: bold;
  -webkit-filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
            filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3)); 
}

/* .location::before {
  background-image: url('https://upload.wikimedia.org/wikipedia/commons/c/cb/QRCodeWikipedia.png');
  background-size: 50px 50px;
  margin: 0 0 0 0 ;
  width: 50px; 
  height: 50px;
  content:"";
  display: inline-block;
  float: left;
  position: absolute;
  left: -160px;
  bottom: 5px;
  -webkit-filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
            filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3)); 
} */

.rip {
  border-right: 8px dotted #436ea5;
  height: 300px;
  position: absolute;
  top: 0;
  left: 530px;
}

.cta .buy {
  position: absolute;
  top: 135px;
  right: 15px;
  display: block;
  font-size: 12px;
  font-weight: bold;
  background-color: #436ea5;
  padding: 10px 20px;
  border-radius: 25px;
  color: #fff;
  text-decoration: none;
  -webkit-transform: rotate(-90deg);
        -ms-transform: rotate(-90deg);
            transform: rotate(-90deg);
  -webkit-filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
            filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3)); 
}

.small {
  font-weight: 150;
}
.middle {
  font-weight: 300;
}

.ticket-1 {
    background-image: url(https://images.unsplash.com/photo-1483101974978-cf266fdf1139?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=3289&q=80);
}

.ticket-2{
    background-image: url(https://images.unsplash.com/photo-1550184658-ff6132a71714?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2180&q=80);
}

</style>
