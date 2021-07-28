<template>
  <section class="contact-section">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>Register<span class="dot">.</span></h2>
      </div>
      <div class="form-box">
        <div class="default-form">
            <div class="row clearfix">

              <div class="form-group col-lg-9 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="user.userId" name="userid" value="" placeholder="아이디" required="" @blur="[checkID(), checkMaxID()]" >
                  <div v-if="!errors.requireID">필수 입력 항목입니다.</div>
                  <div v-if="!errors.maxID"> 최대 16자까지 입력 가능합니다.</div>
                </div>
              </div>
              <div class="form-group col-lg-3 col-md-12 col-sm-12">
                <button class="theme-btn btn-style-one">
                  <i class="btn-curve"></i>
                  <span class="btn-title" @click="clickDuplicate()">Check</span>
                </button>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="password" v-model="user.password" name="userpassword" value="" placeholder="비밀번호" required="" @blur="[checkPass(), checkMinPass(), checkMaxPass(), checkMatch()]">
                  <div v-if="!errors.requirePass">필수 입력 항목입니다.</div>
                  <div v-if="!errors.minPass"> 최소 9 글자까지 입력 해야 합니다.</div>
                  <div v-if="!errors.maxPass"> 최대 16 글자까지 입력 가능합니다.</div>
                  <div v-if="!errors.matchPass"> 비밀번호는 영문, 숫자, 특수문자가 조합되어야합니다.</div>
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="password" v-model="user.passwordConfirm" name="passwordConfirm" value="" placeholder="비밀번호 확인" required="" @blur="matchPass()">
                  <div v-if="!errors.checkPass">비밀번호가 일치하지 않습니다.</div>
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="user.name" name="username" value="" placeholder="이름" required="" @blur="checkName()">
                  <div v-if="!errors.requireName">필수 입력 항목입니다.</div>
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="user.phone" name="phone" value="" placeholder="010-1234-5678" required="" @blur="[checkPhone(), matchPhone()]">
                  <div v-if="!errors.requirePhone">필수 입력 항목입니다.</div>
                  <div v-if="!errors.matchPhone">전화번호 형식이 맞지 않습니다.</div>
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="user.email" name="email" value="" placeholder="becon@becon.com" required="" @blur="[checkEmail(),matchEmail()]">
                  <div v-if="!errors.requireEmail">필수 입력 항목입니다.</div>
                  <div v-if="!errors.matchEmail">이메일 형식이 맞지 않습니다.</div>
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="file" ref="picture" name="files" required="">
                </div>
              </div>

              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <button class="theme-btn btn-style-one">
                  <i class="btn-curve"></i>
                  <span class="btn-title" @click="clickRegister()">Register</span>
                </button>
              </div>
            </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  name: "Register",
  data() {
      return {
          user: {
              userId: '',
              password: '',
              name: '',
              phone: '',
              email: '',
              profile: null,
          },
          errors: {
            requireID:true,
            maxID:true,
            requirePass:true,
            minPass:true,
            maxPass:true,
            checkPass:true,
            matchPass:true,
            requireName:true,
            requirePhone:true,
            matchPhone:true,
            requireEmail:true,
            matchEmail:true,
          },
          message:''
      }
  },
  methods: {
    ...mapActions('user', ["requestRegister", "requestDuplicate"]),
    clickRegister: function () {
      this.user.profile = this.$refs.picture.files[0];
      this.requestRegister(this.user);
    },
    clickDuplicate: function (){
      this.requestDuplicate(this.user.userId);
    },
    checkID(){
      if(!this.user.userId){
        this.errors.requireID=false;
        return;
      }else {
        this.errors.requireID=true;
      }
    },
    checkMaxID(){
      if(this.user.userId.length>16){
        this.errors.maxID=false;
        return;
      }else {
        this.errors.maxID=true;
      }
    },
    checkPass(){
      if(!this.user.password){
        this.errors.requirePass=false;
        return;
      }else{
		    this.errors.requirePass=true;
      }
    },
    matchPass(){
      if(this.user.password!=this.user.passwordConfirm){
        this.errors.checkPass=false;
        return;
      }else{
        this.errors.checkPass=true;
      }
    },
    checkMinPass(){
      if(this.user.password.length<9){
        this.errors.minPass=false;
        return;
      }else{
		    this.errors.minPass=true;
      }
    },checkMaxPass(){
      if(this.user.password.length>16){
        this.errors.maxPass=false;
        return;
      }else{
		    this.errors.maxPass=true;
      }
    },
    checkName(){
      if(!this.user.name){
        this.errors.requireName=false;
        return;
      }else{
		    this.errors.requireName=true;
      }
    },
    checkMatch(){
      if(!/^(?=.*[A-Za-z])(?=.*\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\d~!@#$%^&*()+|=]{8,16}$/.test(this.user.password)){
        this.errors.matchPass=false;
        return;
      }else{
        this.errors.matchPass=true;
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
    }
  }
};
</script>

<style scoped></style>
