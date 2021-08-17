<template>
  <div>
    <section class="we-work-section">
      <div class="auto-container">
        <div class="sec-title centered">
          <h2>공연 신청 내역<span class="dot">.</span></h2>
        </div>
        <!--Work Tabs-->
        <div class="work-tabs tabs-box">

          <!--Tabs Container-->
          <div class="tabs-content">
            <div class="tabs" v-for="concert in getRegistConcertList" :key="concert.id">
              <!--Tab-->
              <input type="radio" name="tabs" :id="concert.id">
              <label :for="concert.id" name="title" class="tab-btn" @click="toggleShow">{{concert.title}}</label>
              <div class="tab" v-if="show">
                <div class="tab active-tab">
                  <div class="row clearfix">
                    <div class="image-col col-lg-5 col-md-6 col-sm-12">
                      <div class="inner">
                        <div class="image">
                          <img :src="`https://i5d102.p.ssafy.io/posterImg/${concert.poster.originName}`" alt="" />
                          <!-- <img src="/images/resource/thumbnail/BeConImg.jpg" alt=""> -->
                        </div>
                      </div>
                    </div>
                    <div class="text-col col-lg-7 col-md-6 col-sm-12">
                      <div class="inner">
                        <div class="content">
                          <div class="text">
                            <p>공연 내용 : {{concert.description}}</p>
                            <p class="theme_color">공연 시간 : {{concert.startTime}} ~ {{concert.endTime}}</p>
                            <ul>
                              <li>VIP 석 : {{concert.priceVip}}</li>
                              <li>Standard 석 : {{concert.priceVip}}</li>
                              <li>공연 분류 : {{concert.category.name}}</li>
                              <li>관람등급 : {{ concert.minAge }}세 관람가</li>
                            </ul>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

          </div>
        </div>
      </div>
    </section>

  </div>
</template>

<script>
import {mapActions, mapGetters} from 'vuex';
    export default {
      name: "ConcertCheck",
      data:function(){
        return{
          title:'',
          description:'',
          startTime:'',
          startEnd:'',
          is_activce:'',
          priceStand:'',
          priceVip:'',
          category:'',
          show: false,
        }
      },
      created(){
        window.scrollTo(0, 0);
        this.requestCheckConcert();
      },
      // mounted(){
      //   this.init();
      // },
      computed:{
        ...mapGetters('concert', ['getRegistConcertList'])
      },
      methods:{
        ...mapActions('concert', ['requestCheckConcert']),
        toggleShow() {
          this.show = !this.show;
        },
        // init(){
        //   this.requestCheckConcert();
        // }
      }
    }
</script>

<style>

  .tabs {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
  }
  .tabs label {
    order: 1;
    display: block;
    padding: 20px 105px;
    margin-right: 0.2rem;
    cursor: pointer;
    background: #FFAA17;
    font-weight: bold;
    transition: background ease 0.2s;
    font-size: 22px;
    text-transform: uppercase;
    color: #222;
    width: 480px;
  }
  .tabs .tab {
    order: 99;
    flex-grow: 1;
    width: 100%;
    display: none;
    padding: 1rem;
    background: #F4F5F8;
  }
  .tabs input[type="radio"] {
    display: none;
  }
  /* .tabs input[type="radio"]:checked + label {
    background: #F4F5F8;
  } */
  .tabs input[type="radio"]:checked + label + .tab {
    display: block;
  }

  @media (max-width: 45em) {
    .tabs .tab,
    .tabs label {
      order: initial;
    }
    .tabs label {
      width: 100%;
      margin-right: 0;
      margin-top: 0.2rem;
    }
  }
</style>
