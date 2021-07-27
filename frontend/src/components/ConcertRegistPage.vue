<template>
  <section class="contact-section">
    <div class="auto-container">
      <div class="form-box">
        <div class="sec-title">
          <h2>Let's go have fun<span class="dot">!</span></h2>
        </div>
        <div class="default-form">
            <div class="row clearfix">
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="concert.title" name="Title" value="" placeholder="Title"  required=""/>
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="concert.description" name="Description" value="" placeholder="Description" required=""/>
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="concert.startTime" name="StartTime" value="" placeholder="StartTime" required=""/>
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="concert.endTime" name="EndTime" value="" placeholder="EndTime" required=""/>
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="concert.priceVip" name="PriceVip" value="" placeholder="PriceVip" required=""/>
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="concert.priceStand" name="PriceStand" value="" placeholder="PriceStand" required=""/>
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-12 col-sm-12">
                <div class="field-inner">
                  <select v-model="concert.categoryName" name="CategoryId" value="" placeholder="CategoryId" required="">
                    <!-- 이부분 수정 필요 -->
                    <option value="">공연 카테고리</option>
                    <option value="HIPHOP">HipHop</option>
							      <option value="발라드">Balad</option>
                    <option value="재즈">Zazz</option>
                    <option value="인디">Indi</option>
                  </select>
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="file" ref="picture" name="files" required="">
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <button class="theme-btn btn-style-one">
                  <i class="btn-curve"></i>
                  <span @click="clickRegist" class="btn-title">콘서트 신청</span>
                </button>
              </div>
            </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import {mapActions} from 'vuex';
export default {
  name: "LoginPage",
  data:function(){
    return{
      concert: {
        title: "",
        description:"",
        startTime:"",
        endTime:"",
        priceVip:"",
        priceStand:"",
        categoryName:"",
        files: null,
      },
      message: ""
    }
  },
  
  computed: {
   
  },

  methods:{
    ...mapActions('concert',["requestRegister"]),
    clickRegist:function(){
      this.concert.files = this.$refs.picture.files[0];
      this.requestRegister(this.concert);
    }
  }
};
</script>

<style scoped></style>
