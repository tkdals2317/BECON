import http from '@/util/http-common';
export default {
    namespaced: true,
    state: {
        user: {},
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
            localStorage.setItem("accessToken",state.accessToken)
        },
  },
    actions: {
        requestLogin({commit}, user) {
            const params = JSON.stringify({
                id: user.userid,
                password: user.userpwd,
            });
            http
            .post(`/api/v1/auth/login`, params)
            .then(({data})=> {
                commit('LOGIN', data);
            }).catch(()=>{
                console.error();
            });
        },
    },
  };
  