<template>
  <section class="contact-section">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>Register<span class="dot">.</span></h2>
      </div>
      <form @submit.prevent="clickRegister">
      <div class="form-box">
        <div class="default-form">
            <div class="row clearfix">
              
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="user.userId" name="userid" value="" placeholder="아이디" required="" @blur="[checkID(), checkMaxID()]" >
                  <span v-if="errors.requireID">Require Feild!</span>
                  <span v-if="errors.maxID"> max16</span>
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="password" v-model="user.password" name="userpassword" value="" placeholder="비밀번호" required="" @blur="checkPASS">
                  <span v-if="errors.requirePASS">Require Feild! & min9 & max16</span>
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="password" v-model="user.passwordConfirm" name="passwordConfirm" value="" placeholder="비밀번호 확인" required="">
                  <span v-if="errors.requirePASS">Require Feild! & min9 & max16</span>
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="user.name" name="username" value="" placeholder="이름" required="" @blur="checkNAME">
                  <span v-if="errors.requireNAME">Require Feild! </span>
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="user.phone" name="phone" value="" placeholder="핸드폰 번호" required="" @blur="checkPHONE">
                  <span v-if="errors.requirePHONE">Require Feild! </span>

                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="user.email" name="email" value="" placeholder="이메일" required="" @blur="checkEMAIL">
                  <span v-if="errors.requireEMAIL">Require Feild! </span>
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
                  <span class="btn-title" type="submit">Register</span>
                </button>
              </div>
            </div>
        </div>
      </div>
      </form>
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
            requireID:false,
            maxID:false,
            requirePASS:false,
            requireNAME:false,
            requirePHONE:false,
            requireEMAIL:false,
          },
          rules: {
            userId: [
              { required: true, message: '필수 입력 항목입니다.', trigger: 'blur' },
              { max:16, message: '최대 16자까지 입력 가능합니다.', trigger: 'blur' }
            ],
            password: [
              { required: true, message: '필수 입력 항목입니다.', trigger: 'blur' },
              { min:9, message: '최소 9 글자를 입력해야 합니다.', trigger: 'blur' },
              { max:16, message: '최대 16 글자까지 입력 가능합니다.', trigger: 'blur' },
              { pattern: /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]|.*[0-9]).{8,24}$/, message: '비밀번호는 영문, 숫자, 특수문자가 조합되어야합니다.', trigger: 'blur' },
            ],
            name: [
              { required: true, message: '필수 입력 항목입니다.', trigger: 'blur' },
            ],
            phone: [
              { required: true, message: '필수 입력 항목입니다.', trigger: 'blur' },
              { pattern: /01[016789]-[^0][0-9]{2,3}-[0-9]{3,4}/, message: '전화번호 형식이 맞지 않습니다.', trigger: 'blur'},
            ],
            email: [
              { required: true, message: '필수 입력 항목입니다.', trigger: 'blur' },
              { pattern: /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/, message: '이메일 형식이 맞지 않습니다.', trigger: 'blur' },
            ],
          },
          message:''
      }
  },
  methods: {
    ...mapActions('user', ["requestRegister"]),
    clickRegister: function () {
      this.user.profile = this.$refs.picture.files[0];
      this.requestRegister(this.user);
    },
    checkID(){
      console.log("실행");
      if(!this.user.userId){
        this.errors.requireID=true;
        return;
      }else {
        this.errors.requireID=false;
      }
    },
    checkMaxID(){
      console.log("실행");
      if(!this.user.maxID.length>16){
        this.errors.maxID=true;
        return;
      }else {
        this.errors.maxID=false;
      }
    },
    checkPASS(){
      console.log("실행");
      if(!this.user.password==/^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]|.*[0-9]).{8,24}$/){
        this.errors.requirePASS=true;
        return;
      }else{
		    this.errors.requirePASS=false;
      }
    },
    checkNAME(){
      console.log("실행");
      if(!this.user.name){
        this.errors.requireNAME=true;
        return;
      }else{
		    this.errors.requireNAME=false;
      }
    },
    checkPHONE(){
      console.log("실행");
      if(!this.user.phone){
        this.errors.requirePHONE=true;
        return;
      }else{
		    this.errors.requirePHONE=false;
      }
    },
    checkEMAIL(){
      console.log("실행");
      if(!this.user.email){
        this.errors.requireEMAIL=true;
        return;
      }else{
		    this.errors.requireEMAIL=false;
      }
    },
  }
};
</script>

<style scoped></style>
