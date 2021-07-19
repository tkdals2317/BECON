<template>
  <el-dialog custom-class="profile-dialog" title="내 프로필" v-model="state.dialogVisible" @close="handleClose">
    <el-form :model="state.form" :rules="state.rules" ref="profileForm" :label-position="state.form.align">
      <el-form-item prop="id" label="아이디" :label-width="state.formLabelWidth">
        <el-input v-model="state.form.id" autocomplete="off" readonly></el-input>
      </el-form-item>
      <el-form-item prop="name" label="이름" :label-width="state.formLabelWidth" >
        <el-input v-model="state.form.name" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item prop="department" label="부서" :label-width="state.formLabelWidth" >
        <el-input v-model="state.form.department" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item prop="position" label="직책" :label-width="state.formLabelWidth" >
        <el-input v-model="state.form.position" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <span><el-button type="primary" @click="clickUpdate">정보수정</el-button></span>
        <span><el-button type="primary" @click="clickDelete">회원탈퇴</el-button></span>
      </span>
    </template>
  </el-dialog>
</template>
<style>
.profile-dialog {
  width: 400px !important;
  height: 500px;
}
.profile-dialog .el-dialog__headerbtn {
  float: right;
}
.profile-dialog .el-form-item__content {
  margin-left: 0 !important;
  width: 200px;
  display: inline-block;
}
.profile-dialog .el-form-item {
  margin-bottom: 20px;
}
.profile-dialog .el-form-item__error {
  font-size: 12px;
  color: red;
}
.profile-dialog .el-input__suffix {
  display: none;
}
.profile-dialog .el-dialog__footer {
  margin: 0 calc(50% - 150px);
  padding-top: 0;
  display: inline-block;
}
.profile-dialog .dialog-footer .el-button {
  width: 120px;
}
.dialog-footer {
  display: flex;
}
.dialog-footer > span {
  margin: 5px;
}
</style>
<script>
import { reactive, computed, ref, onMounted } from 'vue'
import { useStore } from 'vuex'

export default {
  name: 'profile-dialog',

  props: {
    open: {
      type: Boolean,
      default: false
    }
  },

  watch: {
    open: function(val) {
      if (val) {
        this.initInfo();
      }
    }
  },

  setup(props, { emit }) {
    const store = useStore()
    const profileForm = ref(null)

    const state = reactive({
      form: {
        id: '',
        name: '',
        department: '',
        position: '',
        align: 'left'
      },
      rules: {
        name: [
          { required: true, message: '이름를 입력해주세요.', trigger: 'blur' }
        ],
        department: [
          { required: true, message: '부서를 입력해주세요.', trigger: 'blur' }
        ],
        position: [
          { required: true, message: '직책을 입력해주세요.', trigger: 'blur' }
        ],
      },
      dialogVisible: computed(() => props.open),
      formLabelWidth: '120px'
    })

    onMounted(() => {

    })

    const initInfo = function() {
      store.dispatch('root/requestSearch')
      .then(function (response) {
        state.form.id = response.data.userId;
        state.form.name = response.data.userName;
        state.form.department = response.data.userDepartment;
        state.form.position = response.data.userPosition;
      })
      .catch(function (err) {
        alert(err)
      })
    }

    const clickUpdate = function () {
      profileForm.value.validate((valid) => {
        if (valid) {
          store.dispatch('root/requestModify', {
              id: state.form.id,
              body: {
                name: state.form.name,
                department: state.form.department,
                position: state.form.position,
              },
            })
          .then(function () {
            alert('회원 정보가 수정되었습니다.')
          })
          .catch(function (err) {
            alert(err.response.data.message)
          })
        } else {
          alert('Validate error!')
        }
      });
    }

    const clickDelete = function() {
      store.dispatch('root/requestDelete', {
        id: state.form.id,
      })
      .then(function () {
        alert('회원 탈퇴 되었습니다.')
        localStorage.removeItem('access-token')
        window.dispatchEvent(new CustomEvent('remove-access-token'));
        handleClose();
      })
      .catch(function (err) {
        alert(err)
      })
    }

    const handleClose = function () {
      state.form.id = ''
      state.form.name = ''
      state.form.department = ''
      state.form.position = ''
      emit('closeProfileDialog')
    }

    return { initInfo, profileForm, state, clickUpdate, clickDelete, handleClose }
  }
}
</script>
