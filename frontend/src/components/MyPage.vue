<template>
  <section class="contact-section">
    <div class="auto-container">
      <div class="form-box">
        <div class="sec-title">
          <h2>My Page<span class="dot">!</span></h2>
        </div>
        
        <div class="form-box">
            <div class="default-form">
                <div class="row clearfix" v-if="!isClick">
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
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input type="file" ref="picture" name="files" required="">
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
                    <div class="form-group col-lg-12 col-md-12 col-sm-12">
                        <div class="field-inner">
                        <input type="file" ref="picture" name="files" required="">
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
import {mapActions, mapState} from 'vuex';
export default {
  name: "Mypage",
  data:function(){
    return{
      user: {
        userId: '',
        userpwd: '',
        name: '',
        phone: '',
        email: '',
      },
      isClick:false,
      message: ""
    }
  },
  created(){
    this.init();
  },
  computed: {
    ...mapState('user',['userInfo']),

  },

  methods:{
    ...mapActions('user',['requestUserInfo', 'requestDelete', 'requestModify']),
    init(){  
      this.requestUserInfo();
      console.log(this.userInfo);
      this.user.userId=this.userInfo.userId;
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
