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
        //console.log(this.categories + '여기는 mutations')
      },
      REGISTCONCERT(state, payload){
        state.registConcertList = payload;
        console.log(state.registConcertList);
      }
    },

    actions: {
        requsetRegister(commit, concert) {
            var formData = new FormData();
            const CSRF_TOKEN=localStorage.getItem("accessToken");
            for (var variable in concert) {
              formData.append(variable, concert[variable]);
              console.log(variable, concert[variable]);
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
