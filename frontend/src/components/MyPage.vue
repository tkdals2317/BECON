<template>
  <section class="contact-section">
    <div class="auto-container">
      <div class="form-box">
        <div class="sec-title">
          <h2>My Page<span class="dot">!</span></h2>
        </div>
        <div v-if="profile==null" >
					<img src="../files/5887b47695b084b04d2e575438d5a794" class="profile_image">
				</div>
				<div v-else>
					<img src="../../files/5887b47695b084b04d2e575438d5a794" class="profile_image" alt="프로필">
				</div>
        <div class="form-box">
            <div class="default-form">
                <div class="row clearfix" v-if="!isClick">
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input readonly type="text" v-model="userId" name="userid" value="" placeholder="아이디" required="">
                        </div>
                    </div>
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input type="text" v-model="name" name="username" value="" placeholder="이름">
                        </div>
                    </div>
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input type="text" v-model="phone" name="phone" value="" placeholder="핸드폰 번호">
                        </div>
                    </div>
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input type="text" v-model="email" name="email" value="" placeholder="이메일">
                        </div>
                    </div>
                </div>

                <div class="row clearfix" v-if="isClick">
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input type="text" v-model="user.userId" name="userid" value="" placeholder="아이디" required="">
                        </div>
                    </div>
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input type="password" v-model="user.password" name="userpassword" value="" placeholder="비밀번호"
                                required="">
                        </div>
                    </div>
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input type="text" v-model="user.name" name="username" value="" placeholder="이름">
                        </div>
                    </div>
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input type="text" v-model="user.phone" name="phone" value="" placeholder="핸드폰 번호">
                        </div>
                    </div>
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input type="text" v-model="user.email" name="email" value="" placeholder="이메일">
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
    
  },
  computed :{
    ...mapGetters('user',['getUserInfo']),
  },
  methods:{
    ...mapActions('user',['requestUserInfo', 'requestDelete', 'requestModify']),
    ...mapState('user',['userInfo']),
    //...mapGetters('user',['getUserInfo']),
    init(){  
      this.requestUserInfo();
      this.userId = this.getUserInfo.userId;
      this.name=this.getUserInfo.userName;
      this.email=this.getUserInfo.userEmail;
      this.phone=this.getUserInfo.userPhone;
    },    
    click(){
      this.isClick=!this.isClick;
    },
    modifyUser(){
      this.requestModify(this.user);
    },
    deleteUser(){
      this.requestDelete(this.user.userId);
    }

  }
};
</script>

<style scoped></style>
