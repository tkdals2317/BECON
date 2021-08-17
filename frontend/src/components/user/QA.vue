<template>
  <section class="get-quote-three">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>Q&A<span class="dot">.</span></h2>
      </div>
      <div class="form-box">
        <div class="default-form">
            <div class="row clearfix">
              <div class="form-group col-lg-6 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="getUserInfo.userName" name="name" value="" readonly>
                  <div v-if="!errors.requireName" style="color:red;" >필수 입력 항목입니다.</div>
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="getUserInfo.userEmail" name="email" value="" readonly>
                  <div v-if="!errors.requireEmail" style="color:red;">필수 입력 항목입니다.</div>
                  <div v-if="!errors.matchEmail" style="color:red;">이메일 형식이 맞지 않습니다.</div>
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="title" name="subject" value="" placeholder="Subject" required="">
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <div class="field-inner">
                  <textarea name="contents" v-model="contents" placeholder="Write Contents" required=""></textarea>
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <button class="theme-btn btn-style-one">
                  <i class="btn-curve"></i>
                  <span class="btn-title" @click="clickMessage()">Send message</span>
                </button>
              </div>
            </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import {mapGetters, mapActions} from 'vuex';
export default {
  name: "QA",
  data() {
    return {
      name: '',
      email: '',
      title:'',
      contents:'',
      errors: {
        requireName:true,
        requirePhone:true,
        matchPhone:true,
        requireEmail:true,
        matchEmail:true,
      }
    }
  },
  computed :{
    ...mapGetters('user',['getUserInfo']),
  },
  created(){
    window.scrollTo(0, 0);
    this.init();
  },
  methods: {
    ...mapActions('user',['requestUserInfo']),
    ...mapActions('email',['requestQnA']),
    init(){
      this.requestUserInfo();
    },
    clickMessage() {
      var qna={
        email:this.getUserInfo.userEmail,
        name:this.getUserInfo.userName,
        title:this.title,
        content:this.contents,
      }
      this.requestQnA(qna);
      this.$fire({
          title:"문의 완료",
          text: "문의사항이 담당자에게 전달되었습니다!",
          type: "success",
      });
      this.$router.push("/qnaresult");
    },
    checkName(){
      if(!this.user.name){
        this.errors.requireName=false;
        return;
      }else{
		    this.errors.requireName=true;
      }
    },
    checkPhone(){
      if(!this.user.phone){
        this.errors.requirePhone=false;
        return;
      }else{
		    this.errors.requirePhone=true;
      }
    },
    matchPhone(){
      if(!/01[016789]-[^0][0-9]{2,3}-[0-9]{3,4}/.test(this.user.phone)){
        this.errors.matchPhone=false;
        return;
      }else{
        this.errors.matchPhone=true;
      }
    },
    checkEmail(){
      if(!this.user.email){
        this.errors.requireEmail=false;
        return;
      }else{
		    this.errors.requireEmail=true;
      }
    },
    matchEmail(){
      if(!/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/.test(this.user.email)){
       this.errors.matchEmail=false;
        return;
      }else{
        this.errors.matchEmail=true;
      }
    },
  },
}
</script>

<style scoped>

</style>
