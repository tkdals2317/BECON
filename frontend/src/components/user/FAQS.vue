<template>
  <section class="faqs-section">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>FAQS<span class="dot">.</span></h2>
      </div>
      <div class="row clearfix">
        <div class="faq-block col-lg-6 col-md-12 col-sm-12">
          <div class="accordion-container-one">
            <div class="ac">
              <h2 class="ac-q accordion__title-text" tabIndex="0" @click="active1()">공연을 시청하는데 앱을 다운받아야 하나요?</h2>
              <div class="ac-a accordion__content" v-show="question1">
                <p class="accordion__content-desc">
                  BE-CON은 데스크탑 웹(web)을 지원합니다. 별도의 앱을 다운로드 받으실 필요 없이, <br>
                  이벤트 시작 시각에 웹브라우저를 통해서 서비스에 접속하시면 이벤트를 관람하실 수 있습니다. <br>
                  Chrome 웹브라우저를 사용하시기를 권장합니다.
                </p>
              </div>
            </div>

            <div class="ac accordion__content">
              <h2 class="ac-q accordion__title-text" tabIndex="0" @click="active2()">티켓을 구입했습니다. 어떻게 시청하나요?</h2>
              <div class="ac-a" v-show="question2">
                <p class="accordion__content-desc"> 
                  BE-CON 서비스는 온라인 생방송 콘서트 플랫폼입니다. <br>
                  콘서트가 시작되기 약 30분 - 1시간 전부터  티켓을 구입하신 분들에 한해서 시작안내 문자가 발송됩니다. <br>
                  구매하신 티켓으로 감상할 수 있는 이벤트 페이지는 [MY SERVICE] - [예매 내역] 메뉴에서 확인하실 수 있습니다. <br>
                </p>
              </div>
            </div>

            <div class="ac">
              <h2 class="ac-q accordion__title-text" tabIndex="0" @click="active3()">공연중에 아티스트가 저희를 볼수있나요?</h2>
              <div class="ac-a accordion__content" v-show="question3">
                <p class="accordion__content-desc">
                  VIP 티켓을 구매하시면, 아티스트에게 팬 여러분의 화면이 송출됩니다. <br>
                  VIP 티켓을 통해 아티스트와 소통하는 경험을 만끽해보시기 바랍니다.
                </p>
              </div>
            </div>

          </div>

        </div>
        <div class="faq-block col-lg-6 col-md-12 col-sm-12">
          <div class="accordion-container-two">
            <div class="ac">
              <h2 class="ac-q accordion__title-text" tabIndex="0" @click="active4()">웹사이트가 정상적으로 동작하지 않습니다.</h2>
              <div class="ac-a accordion__content" v-show="question4">
                <p class="accordion__content-desc">
                  BE-CON 서비스의 원활한 이용을 위하여 구글 크롬(Google Chrome) 브라우저를 사용하시기를 권장드립니다.
                </p>
              </div>
            </div>

            <div class="ac accordion__content">
              <h2 class="ac-q accordion__title-text" tabIndex="0" @click="active5()">브라우저 캐시와 쿠키 삭제하기</h2>
              <div class="ac-a" v-show="question5">
                <p class="accordion__content-desc">
                  BE-CON 서비스는 보다 좋은 서비스의 제공을 위해 지속적으로 업데이트를 진행합니다. <br>
                  종종 고객님의 브라우저에 이전 버전의 서비스와 관련된 캐시나 쿠키가 남아있어서 서비스의 오동작을 야기하는 경우가 있습니다. <br>
                  이전에 잘 동작하던 서비스가 오동작 할 경우, 브라우저 캐시와 쿠키를 삭제하는 것이 도움을 줄 수 있습니다. <br>
                  브라우저 캐시와 쿠키를 삭제하는 방법은 다음의 링크를 참고하시기 바랍니다.
                  크롬 브라우저 <br>
                  https://support.google.com/accounts/answer/32050
                </p>
              </div>
            </div>

            <div class="ac">
              <h2 class="ac-q accordion__title-text" tabIndex="0" @click="active6()">회원 탈퇴 방법</h2>
              <div class="ac-a accordion__content" v-show="question6">
                <p class="accordion__content-desc">
                  아이디와 비밀번호를 입력하여 회원가입을 한 경우 <br>
                  고객센터를 통해서 회원탈퇴 의향을 밝혀주시고, 가입하신 아이디를 알려주시기 바랍니다.
                </p>
              </div>
            </div>


          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
// import { Accordion } from "accordion";

export default {
  name: "FAQS",
  data() {
    return {
      question1 : false,
      question2 : false,
      question3 : false,
      question4 : false,
      question5 : false,
      question6 : false,

    }
  },
  //  mounted() {
  //     new Accordion('.accordion-container-one');
  //     new Accordion('.accordion-container-two');
  //   },
    methods: {
      active1() {
        this.question1 = !this.question1;
      },
      active2() {
        this.question2 = !this.question2;
      },
      active3() {
        this.question3 = !this.question3;
      },
      active4() {
        this.question4 = !this.question4;
      },
      active5() {
        this.question5 = !this.question5;
      },
      active6() {
        this.question6 = !this.question6;
      },
          
    }
};
</script>

<style scoped>
  .ac {
    margin-top: 10px;
    padding: 10px;
    background: #FFFFFF;
    box-sizing: border-box;
  }

  .ac>.ac-q {
    font: bold 15px Arial, sans-serif;
    font-size: 23px;
    color: #444;
    padding: 10px 30px 10px 10px;
    margin: 0;
    text-decoration: none;
    display: block;
    cursor: pointer;
    position: relative;
    font-weight: 400;
    font-family: Teko;
  }

  .ac.is-active .ac-q {
    color: #FFAA17 !important;
  }
  .ac>.ac-q::after {
    content: '+';
    text-align: center;
    width: 15px;
    right: 10px;
    top: 50%;
    -webkit-transform: translate(0, -50%);
    transform: translate(0, -50%);
    position: absolute
  }

  .ac>.ac-a {
    overflow: hidden;
    -webkit-transition-property: all;
    transition-property: all;
    -webkit-transition-timing-function: ease;
    transition-timing-function: ease
  }

  .ac>.ac-a p {
    font: 16px/1.5 Arial, sans-serif;
    color: #878e9c;
    margin: 0;
    padding: 10px;
    font-size: 18px;
    font-weight: 600;
  }

  .ac.js-enabled>.ac-a {
    visibility: hidden
  }

  .ac.is-active>.ac-a {
    visibility: visible
  }

  .ac.is-active>.ac-q::after {
    content: '\2013';
    color: #FFAA17;
  }
</style>
