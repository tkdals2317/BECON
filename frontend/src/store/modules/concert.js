import http from "@/util/http-common";
//import router from "@/router/index.js";
export default {
    namespaced: true,
    state: {
        concertCategory:[
            {category:"HipHop"},
            {category:"Ballad"},
            {category:"Zazz"},
            {category:"Indi"}
        ],
        concertList:[],
    },
    getters: {
        getConcertCategory(state) {
            return state.concertCategory;
        },
        getConcertList(state) {
            return state.concertList;
        }
    },
    mutations: {
        
  },
    actions: {
        requestRegister(commit, concert) {
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
                alert('공연 신청이 완료되었습니다.')
              })
              .catch((err) => {
                alert(err.response.data.message);
                  console.error();
              });
          },
    },
  };
  