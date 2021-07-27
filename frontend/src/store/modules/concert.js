import http from '@/util/http-common';
export default {
    namespaced: true,
    state: {
        categories: [],
    },

    getters: {
        getConcertCategory(state) {
            return state.concertCategory;
        },
        getCategories(state) {
          console.log('getters확인' + state.categories)
          return state.categories;
        },
    },

    mutations: {
      CATEGORY(state, payload) {
        state.categories = payload
        console.log(this.categories + '여기는 mutations')
      },
    },

    actions: {
      requestCategory({ commit }) {
        http
          .get(`/api/v2/concert/concert-categories`)
          .then(({ data }) => {
            this.categories = data
            // console.log("state categories : "+this.data)
            console.log(data)
            commit('CATEGORY', data)
            // router.push('/');
          })
          .catch(() => {
            console.error();
          });
      },
      requestConcert() {
        http
          .get(`/api/v2/concert/findByCategory/전체`)
          .then(({ data }) => {
            console.log(data)
            // router.push('/');
          })
          .catch(() => {
            console.error();
          });
      },
    },
  };