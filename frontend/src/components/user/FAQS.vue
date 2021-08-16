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
              <h2 class="ac-q accordion__title-text" tabIndex="0" @click="active1()">공연을 자주보고싶어요!</h2>
              <div class="ac-a accordion__content" v-show="question1">
                <p class="accordion__content-desc">저희가 신청하는 것이아니라 도움을 드릴수없습니다.
                </p>
              </div>
            </div>

            <div class="ac accordion__content">
              <h2 class="ac-q accordion__title-text" tabIndex="0" @click="active2()">VIP 티켓을 샀는데 STAND로 바꾸고싶어요</h2>
              <div class="ac-a" v-show="question2">
                <p class="accordion__content-desc">VIP 티켓을 환불하신뒤 다시 STAND 티켓을 구매하시면됩니다.
                </p>
              </div>
            </div>

            <div class="ac">
              <h2 class="ac-q accordion__title-text" tabIndex="0" @click="active3()">공연중에 아티스트가 저희를 볼수있나요?</h2>
              <div class="ac-a accordion__content" v-show="question3">
                <p class="accordion__content-desc">네. 물론입니다. 같이 즐기는 Be-Con 입니다.
                </p>
              </div>
            </div>

          </div>

        </div>
        <div class="faq-block col-lg-6 col-md-12 col-sm-12">
          <div class="accordion-container-two">
            <div class="ac">
              <h2 class="ac-q accordion__title-text" tabIndex="0" @click="active4()">아티스트에게 후원하고싶어요!</h2>
              <div class="ac-a accordion__content" v-show="question4">
                <p class="accordion__content-desc">따로 후원기능은 포함하고있지않습니다.
                </p>
              </div>
            </div>

            <div class="ac accordion__content">
              <h2 class="ac-q accordion__title-text" tabIndex="0" @click="active5()">다시 돌려볼수있나요?</h2>
              <div class="ac-a" v-show="question5">
                <p class="accordion__content-desc">다시보기를 사용해 관람했던 공연을 다시 돌려볼수있습니다.
                </p>
              </div>
            </div>

            <div class="ac">
              <h2 class="ac-q accordion__title-text" tabIndex="0" @click="active6()">티켓 가격이 너무 비싸요!</h2>
              <div class="ac-a accordion__content" v-show="question6">
                <p class="accordion__content-desc">가격은 아티스트가 제시하는 것이기때문에 조정이 불가능합니다.
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
