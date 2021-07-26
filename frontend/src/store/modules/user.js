// import $axios from 'axios'
// import axios from '../../common/lib/axios'
// import VueAxios from '../../common/lib/axios'
import http from '@/util/http-common'

export default {
  namespaced: true,
  state: {
    accessToken: null,
  },
  getters: {},
  mutations: {},
  actions: {
    requestRegister (commit, user) {
      var formData = new FormData();
      for (var variable in user) { 
        formData.append(variable, user[variable]);
      }
      http
        .post(`v1/users/regist`, formData , {
          headers: { 'Content-Type': 'multipart/form-data' },
        })
        .then(({ data }) => {
          console.log(data)
        }).catch(() =>{
          console.error()
        })
    }
  },
};
