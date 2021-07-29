import http from '@/util/http-common';
import router from "@/router/index.js";

export default {
    namespaced: true,
    state: {
        categories: [],
        registConcertList:{},
    },

    getters: {
        getConcertCategory(state) {
            return state.concertCategory;
        },
        getCategories(state) {
          return state.categories;
        },
        getRegistConcertList(state){
          return state.registConcertList;
        }
    },

    mutations: {
      CATEGORY(state, payload) {
        state.categories = payload
      },
      REGISTCONCERT(state, payload){
        state.registConcertList = payload;
      }
    },
    actions: {
        requestRegistConcert(commit, concert) {
            console.log("clickRegist2")
            var formData = new FormData();
            const CSRF_TOKEN=localStorage.getItem("accessToken");
            for (var variable in concert) {
              formData.append(variable, concert[variable]);
            }
            http
              .post(`/api/v2/concert/regist`, formData, {
                headers: {  "Authorization": 'Bearer '+ CSRF_TOKEN,
                            "Content-Type": "multipart/form-data"
                },
              })
              .then(() => {
                alert('공연 신청이 완료되었습니다.');
                router.push('/');
              })
              .catch((err) => {
                alert(err.response.data.message);
                  console.error();
              });
          },
      requestCategory({ commit }) {
        http
          .get(`/api/v2/concert/concert-categories`)
          .then(({ data }) => {
            this.categories = data
            commit('CATEGORY', data)
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
          })
          .catch(() => {
            console.error();
          });
      },
      requestCheckConcert({commit}){
        const CSRF_TOKEN=localStorage.getItem("accessToken");
        http
          .get(`/api/v2/concert/findByOwnerId`,{
            headers: { "Authorization": 'Bearer '+ CSRF_TOKEN }
          })
          .then(({data})=>{
            commit('REGISTCONCERT', data);
          })
          .catch(()=>{
            console.error();
          })
      },
    },
  };
