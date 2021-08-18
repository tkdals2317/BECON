<template>
  <section class="contact-section">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>Sign Up<span class="dot">.</span></h2>
      </div>
      <div class="form-box">
        <div class="default-form">
            <div class="row clearfix">

              <div class="form-group col-lg-9 col-md-12 col-sm-12" >
                <div class="field-inner">
                  <input type="text" v-model="user.userId" name="userid" value="" placeholder="아이디" required="" @blur="checkID()" autocomplete="off">
                  <div style="color:red;">
                  <div v-if="!errors.requireID" color: red>필수 입력 항목입니다.</div>
                  <div v-if="!errors.maxID"> 최대 16자까지 입력 가능합니다.</div>
                  </div>
                </div>
              </div>
              <div class="form-group col-lg-3 col-md-12 col-sm-12">
                <button class="theme-btn btn-style-one" tag="button" @click="clickDuplicate()">
                  <i class="btn-curve"></i>
                  <span class="btn-title">확인</span>
                </button>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="password" v-model="user.password" name="userpassword" value="" placeholder="비밀번호" required="" @blur="checkPass()" autocomplete="off">
                  <div v-if="!errors.requirePass" style="color:red;">필수 입력 항목입니다.</div>
                  <div v-if="!errors.minPass" style="color:red;"  > 최소 9 글자까지 입력 해야 합니다.</div>
                  <div v-if="!errors.maxPass" style="color:red;"> 최대 16 글자까지 입력 가능합니다.</div>
                  <div v-if="!errors.matchPass" style="color:red;"> 비밀번호는 영문, 숫자, 특수문자가 조합되어야합니다.</div>
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="password" v-model="user.passwordConfirm" name="passwordConfirm" value="" placeholder="비밀번호 확인" required="" @blur="matchPass()" autocomplete="off">
                  <div v-if="!errors.checkPass" style="color:red;">비밀번호가 일치하지 않습니다.</div>
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="user.name" name="username" value="" placeholder="이름" required="" @blur="checkName()" autocomplete="off">
                  <div v-if="!errors.requireName" style="color:red;" >필수 입력 항목입니다.</div>
                </div>
              </div>
              <div class="form-group col-lg-3 col-md-3 col-sm-3">
                <div class="field-inner">
                  <select v-model="user.carrier" name="carrier" required="" @blur="[checkCarrier()]" >
                    <option value="none">통신사</option>
                    <option value="SKT">SKT</option>
                    <option value="KTF">KT</option>
                    <option value="LGT">LG U+</option>
                    <option value="MVNO">알뜰폰</option>
                  </select>
                  <div v-if="!errors.requireCarrier" style="color:red;">통신사를 선택해주세요.</div>
                </div>
              </div>
              <div class="form-group col-lg-9 col-md-9 col-sm-9">
                <div class="field-inner">
                  <input type="text" v-model="user.phone" name="phone" value="" placeholder="010-1234-5678" required="" @blur="checkPhone()" autocomplete="off">
                  <div v-if="!errors.requirePhone" style="color:red;">필수 입력 항목입니다.</div>
                  <div v-if="!errors.matchPhone" style="color:red;">전화번호 형식이 맞지 않습니다.</div>
                </div>
              </div>
              <div class="form-group col-lg-9 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="user.email" name="email" value="" placeholder="becon@becon.com" required="" @blur="checkEmail()" autocomplete="off">
                  <div v-if="!errors.requireEmail" style="color:red;">필수 입력 항목입니다.</div>
                  <div v-if="!errors.matchEmail" style="color:red;">이메일 형식이 맞지 않습니다.</div>
                </div>
              </div>
              <div class="form-group col-lg-3 col-md-12 col-sm-12">
                <button class="theme-btn btn-style-one" tag="button" :disabled="isCheck" @click="clickEmailAuth()">
                  <i class="btn-curve"></i>
                  <span class="btn-title">인증</span>
                </button>
              </div>
              <div class="form-group col-lg-2 col-md-12 col-sm-12" v-if="isShow">
                <div class="field-inner" style="margin-top:23px; font-size:15px;">
                  *인증 코드
                </div>
              </div>
              <div class="form-group col-lg-7 col-md-12 col-sm-12" v-if="isShow">
                <div class="field-inner">
                  <input type="text" v-model="code" name="email" value="" placeholder="XSQEID" required="" @blur="checkCode()" autocomplete="off">
                  <div v-if="!errors.requireCode" style="color:red;">필수 입력 항목입니다.</div>
                </div>
              </div>
              <div class="form-group col-lg-3 col-md-12 col-sm-12" v-if="isShow">
                <button class="theme-btn btn-style-one" tag="button" :disabled="isActive" @click="clickAuthCheck()">
                  <i class="btn-curve"></i>
                  <span class="btn-title">확인</span>
                </button>
              </div>
              <div class="form-group col-lg-2 col-md-12 col-sm-12">
                <div class="field-inner" style="margin-top:23px; font-size:15px;">
                  *프로필 등록
                </div>
              </div>
              <div class="form-group col-lg-10 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="file" ref="picture" name="files" required="">
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <button class="theme-btn btn-style-one" @click="clickRegister()">
                  <i class="btn-curve"></i>
                  <span class="btn-title">회원가입</span>
                </button>
              </div>
            </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import http from '@/common/lib/http';
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
              carrier: 'none',
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
            requireCarrier:true,
            matchPhone:true,
            requireEmail:true,
            matchEmail:true,
            checkEmail:false,
            requireCode:false,
          },
          code:'',
          isCheck:false,
          isShow:false,
          isActive:false,
          isDisabled:true
      }
  },
  create(){
    window.scrollTo(0, 0);
  },
  mounted(){
    window.scrollTo(0, 0);
  },
  computed:{
    ...mapGetters('user', ["getAvaliableId"]),
  },
  methods: {
    ...mapActions('user', ["requestRegister", "requestDuplicate"]),
    ...mapActions('email', ["requestEmail", "requestEmailCheck"]),
    clickRegister: function () {
      this.user.profile = this.$refs.picture.files[0];
      if(this.getAvaliableId==false){
        this.$alert("아이디를 다시 확인해주세요.");
        return;
      }
      for (var item in this.user) {
        if(this.user[item]==""){
          this.$alert("정보를 다시 확인해주세요.");
          return;
        }
      }
      if(this.isCheck==false){
        this.$alert("이메일 인증을 해주세요.");
        return;
      }
      if(this.isCheck==true&&this.isActive==false){
        this.$alert("인증코드를 확인해주세요.");
        return;
      }
      this.requestRegister(this.user);
    },
    clickAuthCheck: function(){
      var check={
        userId:this.user.userId,
        code:this.code
      }
      http.post('https://i5d102.p.ssafy.io/api/v3/email/check', check) 
      .then(() => {
        this.$fire({
                title:"인증 결과",
                text: "인증이 확인되었습니다.",
                type: "success",
        });
        this.isActive=true;
      }) 
      .catch(() => {
        this.$fire({
                title:"인증 결과",
                text: "인증이 실패되었습니다. 코드를 다시 확인해주세요!",
                type: "error",
        });
      })
    },
    clickEmailAuth: function(){
      if(this.getAvaliableId==false){
          this.$alert("아이디를 다시 확인해주세요.");
          return;
      }
      if(this.user.name==""){
        this.$alert("이름을 입력해주세요.");
        return;
      }
      if(this.user.email==""){
        this.$alert("이메일을 입력해주세요.");
        return;
      }
      let emailAuth={
        name:this.user.name,
        userId:this.user.userId,
        email:this.user.email,
      }
      this.isCheck=true;
      this.isShow=true;
      this.checkEmail=true;
      this.requestEmail(emailAuth);
      this.$fire({
                title:"이메일을 확인해주세요",
                text: "메일이 전송되었습니다.(약 1분 정도 소요됩니다.)",
                type: "success",
        }
      );
    },
    clickDuplicate: function (){
      this.requestDuplicate(this.user.userId);
    },
    checkID(){
      if(!this.user.userId){
        this.errors.requireID=false;
        this.errors.maxID=true;
      }else if(this.user.userId.length>16){
        this.errors.requireID=true;
        this.errors.maxID=false;
      }else{
        this.errors.requireID=true;
        this.errors.maxID=true;
      }
      return;
    },
    checkCode(){
      if(this.code==''){
        this.errors.requireCode=false;
        return;
      }else{
        this.errors.requireCode=true;
        return; 
      }
    },
    checkPass(){
      if(this.user.password==''){
        this.errors.requirePass=false;
        this.errors.minPass=true;
        this.errors.maxPass=true;
        this.errors.matchPass=true;
        return;
      }else if(this.user.password.length<9){
		    this.errors.requirePass=true;
        this.errors.minPass=false;
        this.errors.maxPass=true;
        this.errors.matchPass=true;
      }else if(this.user.password.length>15){
        this.errors.requirePass=true;
        this.errors.minPass=true;
        this.errors.maxPass=false;
        this.errors.matchPass=true;
      }else if(!/^(?=.*[A-Za-z])(?=.*\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\d~!@#$%^&*()+|=]{8,16}$/.test(this.user.password)){
        this.errors.requirePass=true;
        this.errors.minPass=true;
        this.errors.maxPass=true;
        this.errors.matchPass=false;
      }else{
        this.errors.requirePass=true;
        this.errors.minPass=true;
        this.errors.maxPass=true;
        this.errors.matchPass=true;
      }
      return;
    },
    matchPass(){
      if(this.user.password!=this.user.passwordConfirm){
        this.errors.checkPass=false;
        return;
      }else{
        this.errors.checkPass=true;
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
    checkPhone(){
      if(!this.user.phone){
        this.errors.requirePhone=false;
        this.errors.matchPhone=true;
        return;
      }else if(!/01[016789]-[^0][0-9]{2,3}-[0-9]{3,4}/.test(this.user.phone)){
		    this.errors.requirePhone=true;
          this.errors.matchPhone=false;
        return;
      }else{
        this.errors.requirePhone=true;
        this.errors.matchPhone=true;
        return;
      }
    },
    checkCarrier(){
      if(this.user.carrier === 'none'){
        this.errors.requireCarrier=false;
        return;
      }else{
		    this.errors.requireCarrier=true;
      }
    },
    checkEmail(){
      if(!this.user.email){
        this.errors.requireEmail=false;
        this.errors.matchEmail=true;
        return;
      }else if(!/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/.test(this.user.email)){
		    this.errors.requireEmail=true;
        this.errors.matchEmail=false;
        return;
      }else{
        this.errors.requireEmail=true;
        this.errors.matchEmail=true;
        return;
      }
    },
  }
};
</script>
<style scoped>
.btn-style-one:disabled {
  -webkit-filter: grayscale(100%);
}
</style>
