<template>
  <section class="contact-section">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>Let's go have fun<span class="dot">!</span></h2>
      </div>
      <div class="form-box">
        <div class="default-form">
          <div class="row clearfix">
            <div class="form-group col-lg-12 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  type="text"
                  v-model="concert.title"
                  name="Title"
                  placeholder="  공연 제목"
                  required=""
                  autocomplete="off"
                  @blur="checkTitle()"
                />
                <div v-if="!errors.requireTitle" style="color:red;">필수 입력 항목입니다.</div>
              </div>
            </div>
            <div class="form-group col-lg-12 col-md-12 col-sm-12">
              <div class="field-inner">
                <textarea
                  v-model="concert.description"
                  name="Description"
                  placeholder="간단한 공연 설명을 적어주세요."
                  required=""
                  autocomplete="off"
                  @blur="checkDescription()"
                  >
                </textarea>
                <div v-if="!errors.requireDiscripion" style="color:red;">필수 입력 항목입니다.</div>
              </div>
            </div>
            <div class="form-group col-lg-6 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  type="date"
                  v-model="time.startDay"
                  name="StartDay"
                  required=""
                  autocomplete="off"
                  :min="minDay"
                />
                <!--   -->
              </div>
            </div>
            <div class="form-group col-lg-3 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  type="time"
                  v-model="time.startClock"
                  name="StartClock"
                  min="00:00"
                  max="24:00"
                  required=""
                  autocomplete="off"
                />
              </div>
            </div>
            <div class="form-group col-lg-3 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  type="time"
                  v-model="time.endClock"
                  name="EndClock"
                  min="00:00"
                  max="24:00"
                  placeholder="14:00"
                  required=""
                  autocomplete="off"
                  @blur="checkEndTime()"
                />
                <div v-if="!errors.checkEndTime" style="color:red;">공연 시간을 확인해주세요.</div>
              </div>
            </div>
            <!-- <div class="form-group col-lg-6">
              
            </div>
            <div class="form-group col-lg-6">
              
            </div> -->
            <div class="form-group col-lg-4 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  type="text"
                  v-model="concert.priceVip"
                  name="PriceVip"
                  placeholder="Vip 가격"
                  required=""
                  autocomplete="off"
                  @blur="checkVPrice()"
                />
                <div v-if="!errors.requireVPrice" style="color:red;">필수 입력 항목입니다.</div>
                <div v-if="!errors.checkVPrice" style="color:red;">숫자로 입력해주세요.</div>
              </div>
            </div>
            <div class="form-group col-lg-4 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  type="text"
                  v-model="concert.priceStand"
                  name="PriceStand"
                  placeholder="Stand 가격"
                  required=""
                  autocomplete="off"
                  @blur="checkSPrice()"
                />
                <div v-if="!errors.requireSPrice" style="color:red;">필수 입력 항목입니다.</div>
                <div v-if="!errors.checkSPrice" style="color:red;">숫자로 입력해주세요.</div>
              </div>
            </div>
            <div class="form-group col-lg-4 col-md-12 col-sm-12">
              <div class="field-inner">
                <select name="age" @blur="checkAge()" v-model="concert.minAge">
                    <option value="" disabled>공연관람 등급</option>
                    <option value="0">전체 관람가</option>
                    <option value="12">12세이상관람가</option>
                    <option value="15">15세이상관람가</option>
                    <option value="18">청소년관람불가</option>
                </select>
              </div>
              <div v-if="!errors.requireAge" style="color:red;">공연관람 등급을 선택해주세요.</div>
            </div>
           
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner" style="margin:20px -5px 0px 0px; font-size:17px;">
                * 포스터
              </div>
            </div>
            <div class="form-group col-lg-4 col-md-12 col-sm-12">
              <div class="field-inner">
                <input accept=".jpg, .png" type="file" ref="picture1" name="files1" required="" @blur="checkPoster()"/>
              </div>
              <div v-if="!errors.requirePoster" style="color:red;">필수 입력 항목입니다.</div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner" style="margin:20px -5px 0px 0px; font-size:17px;">
                * 썸네일
              </div>
            </div>
            <div class="form-group col-lg-4 col-md-12 col-sm-12">
              <div class="field-inner">
                <input accept=".jpg, .png" type="file" ref="picture2" name="files2" required="" @blur="checkThumbnail()"/>
              </div>
              <div v-if="!errors.requireThumbnail" style="color:red;">필수 입력 항목입니다.</div>
            </div>
            <div class="form-group col-lg-12 col-md-12 col-sm-12">
              <div class="field-inner">
                <select
                  v-model="concert.categoryName"
                  name="CategoryName"
                  placeholder="CategoryName"
                  required=""
                  @blur="checkCategory()"
                >
                  <!-- 카테고리 부분 -->
                  <option value="" disabled>공연 카테고리</option>
                  <option
                    v-for="category in getCategories"
                    :key="category.id"
                    :value="category.name"
                  >
                    {{ category.name }}
                  </option>
                </select>
              </div>
              <div v-if="!errors.requireCtegory" style="color:red;">카테고리를 선택해주세요.</div>
            </div>
            <div class="form-group col-lg-12 col-md-12 col-sm-12">
              <button class="theme-btn btn-style-one" @click="clickRegistConcert()">
                <i class="btn-curve"></i>
                <span
                  class="btn-title"
                  type="button"
                  >콘서트 신청</span>
              </button>
            </div>
            
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "ConcertRegistPage",
  data: function () {
    // const tommorow = new Date();
    // tommorow.setDate(tommorow.getDate()+1);
    return {
      concert: {
        title: "",
        description: "",
        startTime: "",
        endTime: "",
        priceVip: "",
        priceStand: "",
        minAge: "",
        categoryName: "",
        files1: null,
        files2: null,
      },
      time: {
        startDay: "",
        startClock: "",
        endClock: "",
      },
      errors: {
          requireTitle:true,
          requireDiscripion:true,
          checkEndTime:true,
          requireVPrice:true,
          requireSPrice:true,
          requireAge:true,
          checkVPrice:true,
          checkSPrice:true,
          requirePoster:true,
          requireThumbnail:true,
          requireCtegory:true,
      },
      Stimearr:[],
      Etimearr:[],
      minDay : new Date().toISOString().substring(0, 10),
      message: "",
      isActive:true,
    };
  },
  created() {
    window.scrollTo(0, 0);
  },
  computed: {
    ...mapGetters("concert", ["getCategories"]),
  },

  methods: {
    ...mapActions("concert", ["requestRegistConcert"]),
    clickRegistConcert: function () {
      this.concert.startTime = this.time.startDay + " " + this.time.startClock;
      this.concert.endTime = this.time.startDay + " " + this.time.endClock;
      this.concert.files1 = this.$refs.picture1.files[0];
      this.concert.files2 = this.$refs.picture2.files[0];
      for (var item in this.concert) {
        if(this.concert[item]==""){
          alert("신청서를 다시 확인해주세요.");
          return;
        }
      }
      this.requestRegistConcert(this.concert);
      this.$alert("콘서트 등록이 완료되었습니다!");
      this.$router.push("/concertConfirm");
    },
    checkTitle(){
      if(!this.concert.title){
        this.errors.requireTitle=false;
      }else{
        this.errors.requireTitle=true;
      }return;
    },
    checkDescription(){
      if(!this.concert.description){
        this.errors.requireDiscripion=false;
      }else{
        this.errors.requireDiscripion=true;
      }return;
    },
    checkEndTime(){
      this.Stimearr=this.time.startClock.split(":");
      this.Etimearr=this.time.endClock.split(":");
      if(Number(this.Stimearr[0])>Number(this.Etimearr[0])){
        this.errors.checkEndTime=false;
      }else if(Number(this.Stimearr[0])==Number(this.Etimearr[0])&&Number(this.Stimearr[1])>Number(this.Etimearr[1])){
        this.errors.checkEndTime=false;
      }else{
        this.errors.checkEndTime=true;
      }return;
    },
    checkVPrice(){
      if(!this.concert.priceVip){
        this.errors.requireVPrice=false;
        this.errors.checkVPrice=true;
      }else if(!/^[0-9]*$/.test(this.concert.priceVip)){
        this.errors.requireVPrice=true;
        this.errors.checkVPrice=false;
      }else{
        this.errors.requireVPrice=true;
        this.errors.checkVPrice=true;
      }return;
    },
    checkSPrice(){
      if(!this.concert.priceStand){
        this.errors.requireSPrice=false;
        this.errors.checkSPrice=true;
      }else if(!/^[0-9]*$/.test(this.concert.priceStand)){
        this.errors.requireSPrice=true;
        this.errors.checkSPrice=false;
      }else{
        this.errors.requireSPrice=true;
        this.errors.checkSPrice=true;
      }return;
    },
    checkAge(){
      if(this.concert.minAge==""){
        this.errors.requireAge=false;
      }else{
        this.errors.requireAge=true;
      }
    },
    checkPoster(){
      if(!this.$refs.picture1.files[0]){
        this.errors.requirePoster=false;
      }else{
        this.errors.requirePoster=true;
      }return;
    },
    checkThumbnail(){
      if(!this.$refs.picture2.files[0]){
        this.errors.requireThumbnail=false;
      }else{
        this.errors.requireThumbnail=true;
      }return;
    },
    checkCategory(){
      if(this.concert.categoryName==""){
        this.errors.requireCtegory=false;
      }else{
        this.errors.requireCtegory=true;
      }
      this.isActive=false;
    },
  },
};
</script>

<style scoped>
.form-group input {
  padding: 14px 17px !important;
}
</style>
