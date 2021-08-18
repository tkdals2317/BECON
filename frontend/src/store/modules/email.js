import http from '@/common/lib/http';

export default {
  namespaced: true,
  state: {
    isTrue: false,
  },
  getters: {
    getIsTrue(state) {
      return state.isTrue;
    }
  },
  mutations: {
    SET_IS_TRUE(state, payload) {
      state.isTrue = payload;
    }
  },
  actions: {
    requestEmail(commit, emailAuth) {
      http
        .post(`/api/v3/email/code`, emailAuth)
        .then(({ data }) => {
            console.log(data);
        })
        .catch(() => {
            console.error();
        });
    },
    requestQnA(commit, emailQnA) {
      http
        .post(`/api/v3/email/QnA`, emailQnA)
        .then(({ data }) => {
            console.log(data);
        })
        .catch(() => {
            console.error();
        });
    },
    requestEmailCheck({commit}, emailCheck){
      http
        .post(`/api/v3/email/check`, emailCheck)
        .then(({ data }) => {
          console.log(data);
          commit('SET_IS_TRUE', true);
        })
        .catch(() => {
            console.error();
            commit('SET_IS_TRUE', false);
        });
    }
  },
};
