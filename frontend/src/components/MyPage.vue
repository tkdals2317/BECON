<template>
  <section class="contact-section">
    <div class="auto-container">
      <div class="form-box">
        <div class="sec-title">
          <h2>My Page<span class="dot">!</span></h2>
        </div>
        <div v-if="profile==null" >
					<img src="files\profile\5887b47695b084b04d2e575438d5a794" class="profile_image">
				</div>
				<div v-else>
					<img src="files\profile\5887b47695b084b04d2e575438d5a794" class="profile_image" alt="프로필">
				</div>
        <div class="form-box">
            <div class="default-form">
                <div class="row clearfix" v-if="!isClick">
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input readonly type="text" v-model="getUserInfo.userId" name="userId" value="">
                        </div>
                    </div>
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input readonly type="text" v-model="getUserInfo.userName" name="name" value="">
                        </div>
                    </div>
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input readonly type="text" v-model="getUserInfo.userPhone" name="phone" value="">
                        </div>
                    </div>
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input readonly type="text" v-model="getUserInfo.userEmail" name="email" value="">
                        </div>
                    </div>
                </div>

                <div class="row clearfix" v-if="isClick">
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input type="text" v-model="getUserInfo.userId" name="userId" value="">
                        </div>
                    </div>
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input type="text" v-model="getUserInfo.userName" name="name" value="">
                        </div>
                    </div>
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input type="text" v-model="getUserInfo.userPhone" name="phone" value="">
                        </div>
                    </div>
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input type="text" v-model="getUserInfo.userEmail" name="email" value="">
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
  updated:{

  },
  methods:{
    ...mapActions('user',['requestUserInfo', 'requestDelete', 'requestModify']),
    ...mapState('user',['userInfo']),
    //...mapGetters('user',['getUserInfo']),
    init(){
      this.requestUserInfo();
    },
    click(){
      this.isClick=!this.isClick;
    },
    modifyUser(){
      let modifyed={
        name:this.getUserInfo.userName,
        userId:this.getUserInfo.userId,
        email:this.getUserInfo.userEmail,
        phone:this.getUserInfo.userPhone
      }
      this.requestModify(modifyed);
      this.click();
    },
    deleteUser(){
      this.requestDelete(this.getUserInfo.userId);
      localStorage.removeItem('accessToken');
      location.href = "/";
    },
  }
};
</script>

<style scoped></style>
