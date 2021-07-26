<template>
  <section class="contact-section">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>Register<span class="dot">.</span></h2>
      </div>

      <div class="form-box">
        <div class="default-form">
          <form method="post" ref="registerForm">
            <div class="row clearfix">
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="user.username" name="username" value="" placeholder="Your Name">
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="user.userdepartment" name="userdepartment" value="" placeholder="Department">
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="user.userposition" name="userposition" value="" placeholder="Position">
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="text" v-model="user.userid" name="userid" value="" placeholder="id" required="">
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="password" v-model="user.userpassword" name="userpassword" value="" placeholder="password"
                          required="">
                </div>
              </div>
              <div class="form-group col-lg-6 col-md-6 col-sm-12">
                <div class="field-inner">
                  <input type="password" v-model="user.userpasswordconfirmation" name="userpasswordconfirmation" value="" placeholder="password confirmation" required="">
                </div>
              </div>
              <div class="form-group col-lg-12 col-md-12 col-sm-12">
                <button class="theme-btn btn-style-one">
                  <i class="btn-curve"></i>
                  <span class="btn-title" @click="createRegister">Register</span>
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
import { mapActions, mapMutations } from 'vuex'
export default {
  name: "Register",
  data: function () {
      return {
          user: {
              userid: '',
              username: '',
              userpassword: '',
              userpasswordconfirmation: '',
              userdepartment: '',
              userposition: '',
          },
          message:''
      }
  },
  methods: {
    ...mapActions('user', ["requestRegister"]),
    ...mapMutations({
      createRegister: 'createRegister'
    }),
    clickRegister: function () {
      // this.$router.push('Register')
      this.$store.dispatch('requestRegister', 'user')
      console.log(this.user.userid)
      // this.requestRegister(this.user)
      // this.createRegister(this.user)
    },
  }
  // return { registerForm, state, clickRegister, clickCheckId, validatePwd }
//   }
};
</script>

<style scoped></style>
