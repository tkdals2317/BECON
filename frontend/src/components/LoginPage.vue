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
                  <input
                    type="text"
                    v-model="user.userid"
                    name="UserId"
                    value=""
                    placeholder="Id"
                    required=""
                  />
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <div class="field-inner">
                  <input
                    type="password"
                    v-model="user.userpwd"
                    name="Password"
                    value=""
                    placeholder="Password"
                    required=""
                  />
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <button class="theme-btn btn-style-one">
                  <i class="btn-curve"></i>
                  <span @click="clickLogin" class="btn-title">Login</span>
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
      user: {
        userid: "",
        userpwd: ""
      },
      message: ""
    }
  },
  
  computed: {
   
  },

  methods:{
    ...mapActions('user',["requestLogin"]),
    clickLogin:function(){
      this.requestLogin(this.user);
      // this.$router.push('/');
    }
  }
};
</script>

<style scoped></style>
