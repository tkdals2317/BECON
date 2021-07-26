import http from "@/util/http-common";

export default {
  namespaced: true,
  state: {
    userId: "",
    userName: "",
    accessToken: null,
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
  },
  mutations: {
    LOGIN(state, payload) {
      state.accessToken = payload.accessToken;
      localStorage.setItem("accessToken", state.accessToken);
    },
  },
  actions: {
    requestLogin({ commit }, user) {
      const params = JSON.stringify({
        userId: user.userid,
        password: user.userpwd,
      });
      http
        .post(`/api/v1/auth/login`, params)
        .then(({ data }) => {
          commit("LOGIN", data);
          console.log('로그인되었습니다.')
          this.$router.push('/');
        })
        .catch(() => {
          console.error();
        });
    },
    requestRegister(commit, user) {
      var formData = new FormData();
      for (var variable in user) {
        formData.append(variable, user[variable]);
      }
      http
        .post(`/api/v1/users/regist`, formData, {
          headers: { "Content-Type": "multipart/form-data" },
        })
        .then(() => {
          alert('회원가입되었습니다.')
          this.$router.push('/');
        })
        .catch(() => {
          console.error();
        });
    },
  },
};
