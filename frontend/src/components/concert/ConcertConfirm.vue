<template>
  <section class="get-quote-section">
    <div class="auto-container">
      <div class="row clearfix">
        <div class="col-lg-12 col-md-12 col-sm-12">
          <div class="inner">
            <div class="form-box wow fadeInRight" data-wow-delay="0ms" data-wow-duration="1500ms">
              <div class="default-form">
                <h4>신청 내역<span>.</span></h4>
                <div class="thumbnail_tag" v-if="getConfrimConcert">
                    <img :src="`https://i5d102.p.ssafy.io/thumbnailImg/${getConfrimConcert.concertThumbnail.originName}`" class="프로필">
                  </div>
                <div class="row clearfix">
                  <div class="form-group col-lg-2 col-md-12 col-sm-12">
                    <div class="field-inner">
                      <span class="field-label">공연 제목</span>
                    </div>
                  </div>
                  <div class="form-group col-lg-10 col-md-12 col-sm-12">
                    <div class="field-inner">
                      <input readonly type="text" v-model="getConfrimConcert.title" required/>
                    </div>
                  </div>
                  <div class="form-group col-lg-2 col-md-12 col-sm-12">
                    <div class="field-inner">
                      <span class="field-label">공연 내용</span>
                    </div>
                  </div>
                  <div class="form-group col-lg-10 col-md-12 col-sm-12">
                    <div class="field-inner">
                      <input readonly type="text" v-model="getConfrimConcert.description" required/>
                    </div>
                  </div>
                  <div class="form-group col-lg-2 col-md-12 col-sm-12">
                    <div class="field-inner">
                      <span class="field-label">공연 시간</span>
                    </div>
                  </div>
                  <div class="form-group col-lg-4 col-md-12 col-sm-12">
                    <div class="field-inner">
                      <input readonly type="text" v-model="getConfrimConcert.startTime" required/>
                    </div>
                  </div>
                  <div class="form-group col-lg-2 col-md-12 col-sm-12">
                    <div class="field-inner">
                      <span class="field-label">~</span>
                    </div>
                  </div>
                  <div class="form-group col-lg-4 col-md-12 col-sm-12">
                    <div class="field-inner">
                      <input readonly type="text" v-model="getConfrimConcert.endTime" required/>
                    </div>
                  </div>
                  <div class="form-group col-lg-2 col-md-12 col-sm-12">
                    <div class="field-inner">
                      <span class="field-label">Vip 가격</span>
                    </div>
                  </div>
                  <div class="form-group col-lg-4 col-md-12 col-sm-12">
                    <div class="field-inner">
                      <input readonly type="text" v-model="getConfrimConcert.priceVip" required/>
                    </div>
                  </div>
                  <div class="form-group col-lg-2 col-md-12 col-sm-12">
                    <div class="field-inner">
                      <span class="field-label">Stand 가격</span>
                    </div>
                  </div>
                  <div class="form-group col-lg-4 col-md-12 col-sm-12">
                    <div class="field-inner">
                      <input readonly type="text" v-model="getConfrimConcert.priceStand" required/>
                    </div>
                  </div>
                  <div class="form-group col-lg-2 col-md-12 col-sm-12">
                    <div class="field-inner">
                      <span class="field-label">공연 분류</span>
                    </div>
                  </div>
                  <div class="form-group col-lg-4 col-md-12 col-sm-12">
                    <div class="field-inner">
                      <input readonly type="text" v-model="getConfrimConcert.category.name" required/>
                    </div>
                  </div>
                  <div class="form-group col-lg-2 col-md-12 col-sm-12">
                    <div class="field-inner">
                      <span class="field-label">공연 관람가</span>
                    </div>
                  </div>
                  <div class="form-group col-lg-4 col-md-12 col-sm-12">
                    <div class="field-inner">
                      <input readonly type="text" v-model="getConfrimConcert.minAge" required/>
                    </div>
                  </div>           
                  <div class="form-group" style="margin-top:25px">
                    <button class="theme-btn btn-style-one">
                      <i class="btn-curve"></i>
                      <span class="btn-title" @click="clickHome()">홈으로</span>
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>
  </section>
</template>

<script>
import { mapGetters } from "vuex";
export default {
    name: "ConcertConfirm",
    data:function(){
      return{
        title:'',
        discription:'',
        startTime:'',
        endTime:'',
        priceVip:'',
        priceStand:'',
        name:'',
        originName:''
      }
    },
    created(){
      window.scrollTo(0, 0);
      console.log(this.getConfrimConcert);
    },
    methods:{
      clickHome(){
        this.$router.push('/');
      }
    },
    create:{
      
    },
    computed: {
    ...mapGetters("concert", ["getConfrimConcert"]),
    },
   }
</script>

<style scoped>
.default-form .form-group .field-label {
    position: relative;
    display: block;
    height: 70px;
    width: 100%;
    color: #0f172b;
    font-size: 18px;
    color: var(--thm-black);
    line-height: 40px;
    font-weight: 400;
    line-height: 24px;
     padding: 14px 30px;
    text-transform: uppercase;
    letter-spacing: 2px;
    margin-top: 10px;
}
.default-form .form-group input[type="text"], .default-form .form-group input[type="email"], .default-form .form-group input[type="password"], .default-form .form-group input[type="tel"], .default-form .form-group input[type="url"], .default-form .form-group input[type="file"], .default-form .form-group input[type="date"], .default-form .form-group input[type="time"], .default-form .form-group input[type="number"], .default-form .form-group textarea, .default-form .form-group select {
    position: relative;
    display: block;
    height: 70px;
    width: 100%;
    font-size: 18px;
    color: var(--thm-black);
    line-height: 40px;
    font-weight: 400;
    padding: 14px 30px;
    letter-spacing: 0.02em;
    background-color: #f4f5f8;
    border: 1px solid #f4f5f8;
    border-radius: 7px;
    transition: all 300ms ease;
}
.thumbnail_tag{
    display: block;
    margin: 0 auto;
    width:300px;
    height:400px;
    background-size: cover;
}
.profile_image{
    display: block;
    margin: 0 auto;
    width:100px;
    height:100px;
    object-fit: cover;
}
</style>
