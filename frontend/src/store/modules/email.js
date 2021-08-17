import http from '@/common/lib/http';

export default {
  namespaced: true,
  state: {
    
  },
  getters: {
    
  },
  mutations: {
    
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
  },
};
