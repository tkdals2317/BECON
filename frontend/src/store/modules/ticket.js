import http from '@/common/lib/http';
//import router from "@/router/index";

export default {
    namespaced: true,
    state: {
        
    },

    getters: {
        
    },

    mutations: {
     
    },
    actions: {
        requestBuyTicket(commit, ticketInfo) {
            const CSRF_TOKEN=localStorage.getItem("accessToken");
            http
            .post(`/api/v2/ticket/buy`, ticketInfo, 
                {headers: {"Authorization": 'Bearer '+ CSRF_TOKEN}
            })
              .then(() => {
                alert('티켓 구매가 완료되었습니다.');
              })
              .catch((err) => {
                alert(err.response.data.message);
                  console.error();
              });
        },
    },
  };
