import http from "@/common/lib/http";
import router from "@/router/index";

export default {
  namespaced: true,
  state: {
    userId: "",
    userName: "",
    accessToken: null,
    userInfo: {},
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
  },
  mutations: {
    LOGIN(state, { payload, user }) {
      state.userId = user.userId;
      console.log(state.userId);
      state.accessToken = payload.accessToken;
      localStorage.setItem("accessToken", state.accessToken);
    },
    USERINFO(state, payload) {
      state.userInfo = payload;
    },
  },
  actions: {
    requestLogin({ commit }, user) {
      http
        .post(`/api/v1/auth/login`, user)
        .then(({ data }) => {
          commit("LOGIN", { payload: data, user: user });
          // alert('로그인되었습니다.');
          router.push("/");
        })
        .catch((err) => {
          alert(err.response.data.message);
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
          alert("회원가입되었습니다.");
          router.push("/");
        })
        .catch(() => {
          console.error();
        });
    },
    requestDuplicate(commit, userId) {
      http
        .get(`/api/v1/users/` + userId)
        .then((res) => {
          console.log(res);
          alert(res.data.message);
        })
        .catch((error) => {
          if (error.response.data.statusCode == 409) {
            alert(error.response.data.message);
          }
        });
    },
    requestUserInfo({ commit }) {
      const CSRF_TOKEN = localStorage.getItem("accessToken");
      http
        .get(`/api/v1/users/me`, {
          headers: { Authorization: "Bearer " + CSRF_TOKEN },
        })
        .then(({ data }) => {
          console.log(data);
          commit("USERINFO", data);
        })
        .catch(() => {
          //alert(err.response.message);
          console.error();
        });
    },
    requestModify({ commit }, user) {
      const CSRF_TOKEN = localStorage.getItem("accessToken");
      var formData = new FormData();
      for (var variable in user) {
        formData.append(variable, user[variable]);
      }
      http
        .patch(`/api/v1/users/` + user.userId, formData, {
          headers: {
            Authorization: "Bearer " + CSRF_TOKEN,
            "Content-Type": "multipart/form-data",
          },
        })
        .then(({ data }) => {
          commit("USERINFO", data);
          alert("회원정보가 수정 되었습니다.");
          window.location.reload();
          this.requestUserInfo();
        })
        .catch(() => {
          console.error();
        });
    },
    requestDelete(commit, data) {
      const CSRF_TOKEN = localStorage.getItem("accessToken");
      http
        .delete(`/api/v1/users/` + data, {
          headers: { Authorization: "Bearer " + CSRF_TOKEN },
        })
        .then(() => {
          alert("회원탈퇴가 완료 되었습니다.");
        })
        .catch(() => {
          alert();
          console.error();
        });
    },
  },
};
