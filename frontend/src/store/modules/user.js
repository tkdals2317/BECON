// import $axios from 'axios'
// import axios from '../../common/lib/axios'
// import VueAxios from '../../common/lib/axios'
import http from '@/util/http-common'



export default {
  namespaced: true,
  state: {
    userId: '',
    userName: '',
    userPosition: '',
    userDepartment: '',
    userPassword: '',
    userPassword_confirmation:'',
    accessToken: null,
  },
  getters: {},
  mutations: {
    createRegister: function (state, payload) {
      state.accessToken = payload.accessToken
      localStorage.setItem("accessToken", state.accessToken);
      state.userId = payload.userid
      state.userName = payload.username
      state.userPosition = payload.userposition
      state.userDepartment = payload.userdepartment
      state.userPassword = payload.userpassword
      state.userPassword_confirmation = payload.userpasswordconfirmation
    }
  },
  actions: {
    requestRegister ({commit}, user) {
      const params = JSON.stringify({
        id: user.userid,
        password: user.password,
        passwordconfirmation: user.passwordconfirmation,
        name: user.name,
        position: user.position,
        department: user.department
      });


      http
        .post(`/users/regist`, params)
        .then(({ data }) => {
          console.log(data)
          commit('createRegister', data);
        }).catch(() =>{
          console.error()
        })
    }
  },
};
