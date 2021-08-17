<template>
  <section class="faqs-section">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>Weekly Concert<span class="dot">.</span></h2>
      </div>
    </div>
    <div class="auto-container">
      <div class="row clearfix">
        <no-ssr>
          <carousel :perPage="2">
            <slide v-for="(list, index) in concertDays.date"
                :key="list.id" v-model="list.id">
              <div class="faq-block col-lg-12 col-md-12 col-sm-12">
                <div class="accordion-container-one">
                  
                  <div class="ac">
                    <div class="row clearfix" >
                      <div class="ac-q col-lg-12 col-md-12 col-sm-12">
                        <h2 :id="list.id" :for="list.id" class="ac-q accordion__title-text centered" tabIndex="0">{{list}}</h2>
                      </div>
                    </div> 
                  </div>
                  <div class="ac" v-for="concert in concertDays.concert[index]" :key="concert.id">
                    <label class="row clearfix" :for="concert.id" @click="isActive(index, concert.id)">
                      <div class="ac-q col-lg-5 col-md-12 col-sm-12">
                        <h2 class="ac-q accordion__title-text_left" tabIndex="0">
                          <font-awesome-icon icon="clock" /> {{concert.startTime.split(" ")[1]}}~{{concert.endTime.split(" ")[1]}}<br>
                          <font-awesome-icon icon="microphone" />  {{concert.user.name}}</h2>
                      </div>
                      <div class="ac-q col-lg-7 col-md-12 col-sm-12">
                        <h2 class="ac-q accordion__title-text_right" tabIndex="0">{{concert.title}} {{concertDays.isShow[`${index}`][concert.id]}}<br>
                        <img style="width: 30px; height: 30px; border-radius: 15px;" :src="`https://i5d102.p.ssafy.io/profileImg/${concert.user.userProfile.originName}`"/></h2>
                        <div></div>
                      </div>
                    </label> 
                    
                    <div v-show="concertDays.isShow[`${index}`].get(concert.id)">
                      <div class="ac-a accordion__content row clearfix">
                        <div class="ac-q col-lg-5 col-md-12 col-sm-12">
                        <img style="width: 300px; height: 300px;" :src="`https://i5d102.p.ssafy.io/posterImg/${concert.poster.originName}`"/>
                      </div>
                      <div class="ac-q col-lg-7 col-md-12 col-sm-12">
                        <h2 class="ac-q accordion__title-text_right">{{concert.description}}</h2>
                      </div> 
                    </div>
                  </div>
                   
                  </div>
           
                  

                


                </div>
              </div>


        
            </slide>
          </carousel>
        </no-ssr>
        
      </div>
    </div>
  </section>
</template>

<script>
import GLightbox from "glightbox";
import { mapGetters } from "vuex";
import { Carousel, Slide } from "vue-carousel";
import NoSsr from "vue-no-ssr";


  export default {
    name: "ConcertSchedule",

    data:function(){



      return{
        show:true,
        start:[],
        end:[],
        concertDays:{
          date:[],
          concert:[],
          isShow:{},
        },//주 단위 날짜(월요일부터 시작)
        concertList:[],
        startClock:[],
        endClock:[],
        day:[],// 비교하기 위해 날짜만 저장해줄 배열,
        moment:null,
        Days:'',
        plusDays:'',
        today:'',

      }
    },
    components: {
      NoSsr,
      Carousel,
      Slide,
    },
    computed: {
      ...mapGetters("concert", ["getConcertSchedule"]),
    },
    methods: {
      isActive(index, concertId){
        console.log("클릭");
        console.log(index+" "+concertId);
        this.$nextTick(() => {
          if(this.concertDays.isShow[`${index}`].get(concertId)==false){
          this.concertDays.isShow[`${index}`].set(concertId, true);
          }else{
            this.concertDays.isShow[`${index}`].set(concertId, false);
          }
          console.log(this.concertDays.isShow[`${index}`]);
          console.log(this.concertDays.isShow[`${index}`].get(concertId));
        });
        
        
      },
      init(){
        console.log(this.getConcertSchedule);
        
        
        this.getDate();
        this.concertDays.concert=new Array(7);
        this.concertDays.isShow=new Object();
        for(let i=0;i<7;i++){
          this.concertDays.concert[i]=new Array();
          this.concertDays.isShow[`${i}`]=new Map();
        }

        for(var items in this.getConcertSchedule){
          this.start=this.getConcertSchedule[items].startTime.split(" ");
          this.end=this.getConcertSchedule[items].startTime.split(" ");
          
          
          if(this.start[0]>=this.Days&&this.start[0]<=this.plus7Days){
            if(this.start[0]==this.concertDays.date[0]){
              this.concertDays.concert[0].push(this.getConcertSchedule[items]);
              this.concertDays.isShow['0'].set(this.getConcertSchedule[items].id, false);
            }else if(this.start[0]==this.concertDays.date[1]){
              this.concertDays.concert[1].push(this.getConcertSchedule[items]);
              this.concertDays.isShow['1'].set(this.getConcertSchedule[items].id, false);
            }else if(this.start[0]==this.concertDays.date[2]){
              this.concertDays.concert[2].push(this.getConcertSchedule[items]);
              this.concertDays.isShow['2'].set(this.getConcertSchedule[items].id, false);
            }else if(this.start[0]==this.concertDays.date[3]){
              this.concertDays.concert[3].push(this.getConcertSchedule[items]);
              this.concertDays.isShow['3'].set(this.getConcertSchedule[items].id, false);
            }else if(this.start[0]==this.concertDays.date[4]){
              this.concertDays.concert[4].push(this.getConcertSchedule[items]);
              this.concertDays.isShow['4'].set(this.getConcertSchedule[items].id, false);
            }else if(this.start[0]==this.concertDays.date[5]){
              this.concertDays.concert[5].push(this.getConcertSchedule[items]);    
              this.concertDays.isShow['5'].set(this.getConcertSchedule[items].id, false);          
            }else if(this.start[0]==this.concertDays.date[6]){
              this.concertDays.concert[6].push(this.getConcertSchedule[items]);
              this.concertDays.isShow['6'].set(this.getConcertSchedule[items].id, false);
            }
            
          }
        }
        console.log(this.concertDays);
        
        //for(var time in this.concertList){
          //this.concertList[time].startTime=this.concertList[time].startTime.split(" ");
          //this.concertList[time].endTime=this.concertList[time].endTime.split(" ");
        //}
       
      },
      getDate(){
        var moment = require('moment')

        this.today=moment().day();
      
        if(this.today==1){
          this.Days=moment().format('YYYY-MM-DD');
          this.plus7Days=moment().add(6, 'days').format('YYYY-MM-DD');
          for(let i=0;i<7;i++){
            this.concertDays.date[i]=moment().add(i, 'days').format('YYYY-MM-DD');
          }
        }else if(this.today==2){
          this.Days=moment().subtract(1, 'days').format('YYYY-MM-DD');
          this.plus7Days=moment().add(5, 'days').format('YYYY-MM-DD');
          for(let i=-1;i<6;i++){
            this.concertDays.date[i+1]=moment().add(i, 'days').format('YYYY-MM-DD');
          }
        }else if(this.today==3){
          this.Days=moment().subtract(2, 'days').format('YYYY-MM-DD');
          this.plus7Days=moment().add(4, 'days').format('YYYY-MM-DD');
          for(let i=-2;i<5;i++){
            this.concertDays.date[i+2]=moment().add(i, 'days').format('YYYY-MM-DD');
          }
        }else if(this.today==4){
          this.Days=moment().subtract(3, 'days').format('YYYY-MM-DD');
          this.plus7Days=moment().add(3, 'days').format('YYYY-MM-DD');
          for(let i=-3;i<4;i++){
            this.concertDays.date[i+3]=moment().add(i, 'days').format('YYYY-MM-DD');
          }
        }else if(this.today==5){
          this.Days=moment().subtract(4, 'days').format('YYYY-MM-DD');
          this.plus7Days=moment().add(2, 'days').format('YYYY-MM-DD');
          for(let i=-4;i<3;i++){
            this.concertDays.date[i+4]=moment().add(i, 'days').format('YYYY-MM-DD');
          }
        }else if(this.today==6){
          this.Days=moment().subtract(5, 'days').format('YYYY-MM-DD');
          this.plus7Days=moment().add(1, 'days').format('YYYY-MM-DD');
          for(let i=-5;i<2;i++){
            this.concertDays.date[i+5]=moment().add(i, 'days').format('YYYY-MM-DD');
          }
        }else{
          this.Days=moment().add(1, 'days').format('YYYY-MM-DD');
          this.plus7Days=moment().add(7, 'days').format('YYYY-MM-DD');
          for(let i=-6;i<1;i++){
            this.concertDays.date[i+6]=moment().add(i, 'days').format('YYYY-MM-DD');
          }
        }
      }
    },
    created(){
      this.init();
    },
    mounted () {
    
      window.scrollTo(0, 0);
      new GLightbox({
        selector: '.lightbox-image',
        touchNavigation: true,
        loop: true,
        autoplayVideos: true
      });
      
    },
    // created: function () {
    //   this.requestConcert("All");
    // },
  }
</script>

<style scoped>
.project-tab * {
  padding: 1px 0px 0px 0px;
}
  .tabs {
    display: flex;
    flex-wrap: wrap;
  }
.ac {
    margin-top: 10px;
    padding: 10px;
    background: #FFFFFF;
    box-sizing: border-box;
  }
  .accordion__title-text_left,.accordion__title-text_right{
    font-size: 15px;
    margin: -5px 0px -15px 0px;
  }
.accordion__title-text{
  font-size: 15px;
  margin: 0px 0px 0px 0px;
}
  .ac>.ac-q {
    font: bold 15px Arial, sans-serif;
    font-size: 23px;
    color: #444;
    padding: 10px 10px 10px 10px;
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
