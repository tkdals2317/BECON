<template>
  <div class="loader" v-if="state.loading"></div>
  <fieldset :disabled="state.loading">
    <el-dialog custom-class="login-dialog" title="로그인" v-model="state.dialogVisible" @close="handleClose">
      <el-form :model="state.form" :rules="state.rules" ref="loginForm" :label-position="state.form.align">
        <el-form-item prop="id" label="아이디" :label-width="state.formLabelWidth" >
          <el-input v-model="state.form.id" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item prop="password" label="비밀번호" :label-width="state.formLabelWidth">
          <el-input v-model="state.form.password" autocomplete="off" show-password></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button type="primary" @click="clickLogin">로그인</el-button>
        </span>
      </template>
    </el-dialog>
  </fieldset>
</template>
<style>
.loader{  /* Loader Div Class */
    position: absolute;
    top:0px;
    right:0px;
    width:100%;
    height:100%;
    background-color:#E2E2E2;
    background-image: url('../../../assets/images/loading (1).gif');
    background-size: 50px;
    background-repeat:no-repeat;
    background-position:center;
    z-index:10000000;
    opacity: 0.1;
    filter: alpha(opacity=40);
}
.login-dialog {
  width: 400px !important;
  height: 300px;
}
.login-dialog .el-dialog__headerbtn {
  float: right;
}
.login-dialog .el-form-item__content {
  margin-left: 0 !important;
  width: 200px;
  display: inline-block;
}
.login-dialog .el-form-item {
  margin-bottom: 20px;
}
.login-dialog .el-form-item__error {
  font-size: 12px;
  color: red;
}
.login-dialog .el-input__suffix {
  display: none;
}
.login-dialog .el-dialog__footer {
  margin: 0 calc(50% - 80px);
  padding-top: 0;
  display: inline-block;
}
.login-dialog .dialog-footer .el-button {
  width: 120px;
}
</style>

<script>
import { reactive, computed, ref, onMounted } from 'vue'
import { useStore } from 'vuex'

export default {

  name: 'login-dialog',

  data:()=>({
     spin:true,
  }),

  props: {
    open: {
      type: Boolean,
      default: false
    }
  },

  setup(props, { emit }) {
    const store = useStore()
    const loginForm = ref(null)
    const state = reactive({
      loading: false,
      form: {
        id: '',
        password: '',
        align: 'left'
      },
      rules: {
        id: [
          { required: true, message: '필수 입력 항목입니다.', trigger: 'blur' },
          { max:16, message: '최대 16자까지 입력 가능합니다.', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '필수 입력 항목입니다.', trigger: 'blur' },
          { min:9, message: '최소 9 글자를 입력해야 합니다.', trigger: 'blur' },
          { max:16, message: '최대 16 글자까지 입력 가능합니다.', trigger: 'blur' },
          { pattern: /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]|.*[0-9]).{8,24}$/, message: '비밀번호는 영문, 숫자, 특수문자가 조합되어야합니다.', trigger: 'blur' },
        ]
      },
      dialogVisible: computed(() => props.open),
      formLabelWidth: '120px'
    })

    onMounted(() => {
       console.log(loginForm.value)
    })

    const clickLogin =  function () {
      loginForm.value.validate((valid) => {
        if (valid) {
          state.loading=true
          store.dispatch('root/requestLogin', { id: state.form.id, password: state.form.password })
          .then( function (result) {
            console.log()
            localStorage.setItem('token', result.data.accessToken)
            window.dispatchEvent(new CustomEvent('set-token',{
              detail:{
                token: localStorage.getItem('token')
              }
            }));
            alert("로그인 완료")
            handleClose();
          })
          .catch(function (err) {
            alert(err.response.data.message);
            if(err.response.status == 401){
              alert("세션이 유효하지 않습니다.")
            }
            console.log(err.response.exception)
          })
          .finally(function(){
              state.loading=false
          })
        } else {
          alert('Validate error!')
        }
      });
    }

    const handleClose = function () {
      state.form.id = ''
      state.form.password = ''
      emit('closeLoginDialog')
    }

    return { loginForm, state, clickLogin, handleClose }
  }
}
</script>
