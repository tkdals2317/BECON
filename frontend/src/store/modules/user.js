import http from '@/common/lib/http';
import router from "@/router/index";
import VueSimpleAlert from "vue-simple-alert";
export default {
  namespaced: true,
  state: {
    total: 0,
    userId: "",
    userName: "",
    accessToken: "",
    userInfo: null,
    availableId:true,
  },
  getters: {
    getAccessToken(state) {
      return state.accessToken;
    },
    getUserId(state) {
      return state.userId;
    },
    getUserName(state) {
      return state.userName;
    },
    getUserInfo(state) {
      return state.userInfo;
    },
    getAvaliableId(state){
      return state.availableId;
    },
    getTotalUser(state) {
      return state.total;
    }
  },
  mutations: {
    LOGIN(state, {payload, user}) {
      state.userId = user.userId;
      state.accessToken = payload.accessToken;
      localStorage.setItem("accessToken", state.accessToken);
    },
    USERINFO(state, payload){
      state.userInfo = payload;
    },
    USERID(state, payload){
      state.availableId = payload;
    },
    SET_TOTAL_USER(state, payload) {
      state.total = payload;
    }
  },
  actions: {
    requestLogin({ commit }, user) {
      http
        .post(`/api/v1/auth/login`, user)
        .then(({ data }) => {
          console.log(data);
          commit("LOGIN", {payload: data, user: user});
          // alert('로그인되었습니다.');
          router.push('/');
        })
        .catch((err) => {
          VueSimpleAlert.alert(err.response.data.message);
          console.error();
        });
    },
    requestRegister(commit, user) {
      var formData = new FormData();
      
      formData.append("userId", user.userId);
      formData.append("password", user.password);
      formData.append("name", user.name);
      formData.append("phone", user.phone);
      formData.append("email", user.email);
      formData.append("files", user.profile);
      formData.append("carrier", user.carrier);

      http
        .post(`/api/v1/users/regist`, formData, {
          headers: { "Content-Type": "multipart/form-data" },
        })
        .then(() => {
          VueSimpleAlert.alert('회원가입되었습니다.')
          router.push('/');
        })
        .catch(() => {
          console.error();
        });
    },
    requestDuplicate({commit}, userId){
      http
        .get(`/api/v1/users/`+userId)
        .then((res) => {
          VueSimpleAlert.alert(res.data.message);
          commit("USERID", true);
        })
        .catch((error) => {
          if(error.response.data.statusCode==409){
            commit("USERID", false);
            alert(error.response.data.message);
          }
        });
    },
    requestUserInfo({commit}){
      const CSRF_TOKEN=localStorage.getItem("accessToken");
      http
        .get(`/api/v1/users/me`, {
          headers: {"Authorization": 'Bearer '+ CSRF_TOKEN }
        })
        .then(({ data })=>{
          commit("USERINFO", data);
        })
        .catch(() => {
          //alert(err.response.message);
          console.error();
        });
    },
    requestModify({commit}, user){
      const CSRF_TOKEN=localStorage.getItem("accessToken");
      var formData = new FormData();
      for (var variable in user) {
        formData.append(variable, user[variable]);
      }
      http
        .patch(`/api/v1/users/`+user.userId, formData,{
          headers: { "Authorization": 'Bearer '+ CSRF_TOKEN,
          "Content-Type": "multipart/form-data"
        },
        })
        .then(({ data })=>{
          commit("USERINFO", data);
          VueSimpleAlert.alert('회원정보가 수정 되었습니다.')
          window.location.reload();
          this.requestUserInfo();
        })
        .catch(() => {
         console.error();
        });
    },
    requestDelete(commit, data){
      const CSRF_TOKEN=localStorage.getItem("accessToken");
      http
        .delete(`/api/v1/users/`+ data ,{
          headers: { "Authorization": 'Bearer '+ CSRF_TOKEN},
        })
        .then(()=>{
          VueSimpleAlert.alert('회원탈퇴가 완료 되었습니다.')
        })
        .catch(() => {
          alert();
            console.error();
        });
    },
    findTotalUser({ commit }) {
      http
        .get(`/api/v1/users/count/total`)
        .then(({ data }) => {
          commit("SET_TOTAL_USER", data);
        })
        .catch((err) => {
          console.log(err);
        });
    }
  },
};
