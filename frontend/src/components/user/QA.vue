<template>
  <section class="get-quote-three">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>문의사항<span class="dot">.</span></h2>
      </div>
      <div class="form-box">
        <div class="default-form">
          <form method="post" action="#" id="contact-form">
            <div class="row clearfix">
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="user.name" name="username" value="" placeholder="이름" required="" @blur="checkName()">
                  <div v-if="!errors.requireName" style="color:red;" >필수 입력 항목입니다.</div>
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="user.email" name="email" value="" placeholder="becon@becon.com" required="" @blur="[checkEmail(),matchEmail()]">
                  <div v-if="!errors.requireEmail" style="color:red;">필수 입력 항목입니다.</div>
                  <div v-if="!errors.matchEmail" style="color:red;">이메일 형식이 맞지 않습니다.</div>
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="user.phone" name="phone" value="" placeholder="010-1234-5678" required="" @blur="[checkPhone(), matchPhone()]">
                  <div v-if="!errors.requirePhone" style="color:red;">필수 입력 항목입니다.</div>
                  <div v-if="!errors.matchPhone" style="color:red;">전화번호 형식이 맞지 않습니다.</div>
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="text" name="subject" value="" placeholder="Subject" required="">
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <div class="field-inner">
                  <textarea name="message" placeholder="Write Message" required=""></textarea>
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <button class="theme-btn btn-style-one">
                  <i class="btn-curve"></i>
                  <span class="btn-title" @click="clickMessage()">Send message</span>
                </button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "QA",
  data() {
    return {
      user: {
          name: '',
          phone: '',
          email: '',
      },
      errors: {
        requireName:true,
        requirePhone:true,
        matchPhone:true,
        requireEmail:true,
        matchEmail:true,
      }
    }
  },
  methods: {
    clickMessage() {
      alert('문의 접수가 완료되었습니다.')
      this.$router.push('/')
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
