<template>
  <div class="loader" v-if="state.loading"></div>
  <fieldset :disabled="state.loading">
    <el-dialog custom-class="register-dialog" title="회원가입" v-model="state.dialogVisible" @close="handleClose">
      <el-form :model="state.form" :rules="state.rules" ref="registerForm" :label-position="state.form.align" @submit.prevent="onSubmit">
        <el-form-item prop="name" label="이름" :label-width="state.formLabelWidth" >
          <el-input v-model="state.form.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item prop="department" label="소속" :label-width="state.formLabelWidth" >
          <el-input v-model="state.form.department" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item prop="position" label="직책" :label-width="state.formLabelWidth" >
          <el-input v-model="state.form.position" autocomplete="off"></el-input>
        </el-form-item>
        <el-button type="primary" style="float: right;" @click="clickDuplicate">중복확인</el-button>
        <el-form-item prop="id" label="아이디" :label-width="state.formLabelWidth">
            <el-input v-model="state.form.id" autocomplete="off" style="float: left;"></el-input>
        </el-form-item>
        <el-form-item prop="password" id="password" name="password" label="비밀번호" :label-width="state.formLabelWidth">
          <el-input v-model="state.form.password" autocomplete="off" show-password></el-input>
        </el-form-item>
        <el-form-item prop="password_confirmation" label="비밀번호 확인" :label-width="state.formLabelWidth">
          <el-input v-model="state.form.password_confirmation" autocomplete="off" show-password></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button type="primary" :disabled="state.check" @click="clickRegister">가입하기</el-button>
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
    opacity: 0.8;
    filter: alpha(opacity=40);
}
.register-dialog {
  width: 600px !important;
  height: 600px;
}
.register-dialog .el-dialog__headerbtn {
  float: right;
}
.register-dialog .el-form-item__content {
  margin-left: 0 !important;
  width: 200px;
  display: inline-block;
}
.register-dialog .el-form-item {
  margin-bottom: 20px;
}
.register-dialog .el-form-item__error {
  font-size: 12px;
  color: red;
}
.register-dialog .el-input__suffix {
  display: none;
}
.register-dialog .el-dialog__footer {
  margin: 0 calc(50% - 80px);
  padding-top: 0;
  display: inline-block;
}
.register-dialog .dialog-footer .el-button {
  width: 120px;
}
</style>
<script>
import { reactive, computed, ref, onMounted } from 'vue'
import { useStore } from 'vuex'

export default {
  name: 'register-dialog',

  props: {
    open: {
      type: Boolean,
      default: false
    }
  },

  setup(props, { emit }) {
    const store = useStore()
    const registerForm = ref(null)

    const validatePass = (rule, value, callback) => {
        if (value !== state.form.password) {
            callback(new Error('비밀번호가 일치하지 않습니다.'));
        } else {
            callback();
        }
    };

    const state = reactive({
      loading: false,

      form: {
        name:'',
        department:'',
        position:'',
        id: '',
        password: '',
        password_confirmation:'',
        align: 'left'
      },

      check:false,

      rules: {
        name: [
          { required: true, message: '필수 입력 항목입니다.', trigger: 'blur' },
          { max:30, message: '최대 30자까지 입력 가능합니다.', trigger: 'blur' }
        ],
        department: [
          { max:30, message: '최대 30자까지 입력 가능합니다.', trigger: 'blur' }
        ],
        position: [
          { max:30, message: '최대 30자까지 입력 가능합니다.', trigger: 'blur' }
        ],
        id: [
          { required: true, message: '필수 입력 항목입니다.', trigger: 'blur' },
          { max:16, message: '최대 16자까지 입력 가능합니다.', trigger: 'blur' }
        ],
        password: [

          { required: true, message: '필수 입력 항목입니다.', trigger: 'blur' },
          //{ min:9, message: '최소 9 글자를 입력해야 합니다.', trigger: 'blur' },
          { max:16, message: '최대 16 글자까지 입력 가능합니다.', trigger: 'blur' },
          //{ pattern: /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{9,16}$/, message: '비밀번호는 영문, 숫자, 특수문자가 조합되어야합니다.', trigger: 'blur' },
        ],
        password_confirmation: [
          { validator: validatePass, trigger: 'blur'},
          { required: true, message: '필수 입력 항목입니다.', trigger: 'blur' },
        ],

      },
      dialogVisible: computed(() => props.open),
      formLabelWidth: '120px'
    })

    onMounted(() => {
       console.log(registerForm.value)
    })

    const clickDuplicate = function() {
      console.log("클릭")
      store.dispatch('root/requestDuplicate', state.form.id)
      .then(function(result){
        console.log(result.data)
        alert(result.data.message);
      })
      .catch(function(err){
        alert(err.response.data.message);
        console.log(err)
      })
    }

    const clickRegister = function () {
      registerForm.value.validate((valid) => {
        if (valid) {
          state.loading=true
          store.dispatch('root/requestRegister', { name:state.form.name, id: state.form.id, password: state.form.password, department: state.form.department, position:state.form.position })
          .then(function (result) {
            alert("회원가입 성공")
            console.log(result.data)
            emit('closeRegisterDialog')
          })
          .catch(function (err) {
            if(err.response.status == 403){
              alert("접근 권한이 없습니다.")
            }
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
      state.form.name = ''
      state.form.department='',
      state.form.position='',
      state.form.id = ''
      state.form.password = ''
      state.form.password_confirmation = ''
      emit('closeRegisterDialog')
    }

    return { registerForm, state, clickRegister, clickDuplicate, handleClose }
  }
}
</script>
