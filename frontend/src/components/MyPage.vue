<template>
  <section class="contact-section">
    <div class="auto-container">
      <div class="form-box">
        <div class="sec-title">
          <h2>My Page<span class="dot">!</span></h2>
        </div>
        <div style="margin-bottom: 25px;">
          <div class="profile_tag" v-if="getUserInfo.userProfile.originName==null" >
            <img :src="require(`@/common/images/resource/profile/BeConImg.jpg`)" class="profile_image">
          </div>
          <div class="profile_tag" v-else>
            <img :src="require(`@/common/images/resource/profile/${getUserInfo.userProfile.originName}`)" class="profile_image" alt="프로필">
          </div>
          <div class="filebox" v-if="isClick">
            <label for="ex_file">프로필 수정</label>
            <input type="file" id="ex_file" ref="picture" name="files">
          </div>
        </div>
        <div class="form-box">
            <div class="default-form">
                <div class="row clearfix" >
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input v-bind:disabled="!isClick" type="text" v-model="getUserInfo.userId" name="userId" value="">
                        </div>
                    </div>
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input v-bind:disabled="!isClick" type="text" v-model="getUserInfo.userName" name="name" value="">
                        </div>
                    </div>
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input v-bind:disabled="!isClick" type="text" v-model="getUserInfo.userPhone" name="phone" value="">
                        </div>
                    </div>
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input v-bind:disabled="!isClick" type="text" v-model="getUserInfo.userEmail" name="email" value="">
                        </div>
                    </div>
                </div>
                <div class="form-group col-lg-12 col-md-12 col-sm-12">
                  <button v-if="!isClick" class="theme-btn btn-style-one" @click="click">
                    <i class="btn-curve"></i>
                    <span class="btn-title" >수정</span>
                  </button>
                  <button v-if="isClick" class="theme-btn btn-style-one" @click="modifyUser">
                    <i class="btn-curve"></i>
                    <span class="btn-title" >확인</span>
                  </button>
                  <button class="theme-btn btn-style-one" @click="deleteUser">
                    <i class="btn-curve"></i>
                    <span class="btn-title" >탈퇴</span>
                  </button>
                </div>
            </div>
        </div>

        </div>
    </div>
  </section>
</template>

<script>
import {mapActions, mapState, mapGetters} from 'vuex';
export default {
  name: "Mypage",
  data:function(){
    return{
      userId: '',
      password: '',
      name: '',
      phone: '',
      email: '',
      profile:null,
      isClick:false,
      message: ""
    }
  },
  created(){
    this.init();
  },
  mounted(){
    this.init();
  },
  computed :{
    ...mapGetters('user',['getUserInfo']),
  },
  methods:{
    ...mapActions('user',['requestUserInfo', 'requestDelete', 'requestModify']),
    ...mapState('user',['userInfo']),
    init(){
      this.requestUserInfo();
    },
    click(){
      this.isClick=!this.isClick;
    },
    modifyUser(){
      this.profile = this.$refs.picture.files[0];
      let modifyed={
        name:this.getUserInfo.userName,
        userId:this.getUserInfo.userId,
        email:this.getUserInfo.userEmail,
        phone:this.getUserInfo.userPhone,
        files:this.profile,
      }
      this.click();
      this.requestModify(modifyed);
    },

    deleteUser(){
      this.requestDelete(this.getUserInfo.userId);
      localStorage.removeItem('accessToken');
      location.href = "/";
    },
  }
};
</script>

<style scoped>
.profile_tag{
    margin: 0 auto;
    overflow: hidden;
    width:100px;
    height:100px;
    border-radius: 70%;
}
.profile_image{
    display: block;
    margin: 0 auto;
    width:100px;
    height:100px;
    object-fit: cover;

}
.filebox label {
  display: inline-block;
  padding: .5em .75em;
  color: #fff;
  font-size: inherit;
  line-height: normal;
  vertical-align: middle;
  background-color: #d43114;
  cursor: pointer;
  border: 0.3px solid #d43114;
  border-radius: .25em;
  -webkit-transition: background-color 0.2s;
  transition: background-color 0.2s;
  margin-bottom: 10px;
}

.filebox label:hover {
  background-color: #ee2d1496;
}

.filebox label:active {
  background-color: #ee2d1496;
}

.filebox input[type="file"] {
  position: absolute;
  width: 1px;
  height: 1px;
  padding: 0;
  margin: -1px;
  overflow: hidden;
  clip: rect(0, 0, 0, 0);
  border: 0;
}
</style>
