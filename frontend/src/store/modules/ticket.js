import http from '@/common/lib/http';
//import router from "@/router/index";

export default {
    namespaced: true,
    state: {
      ticketInfo: {},
    },
    getters: {
      getTicketInfo(state) {
        return state.ticketInfo;
      }
    },
    mutations: {
      SET_TICKET(state, payload) {
        state.ticketInfo = payload;
      }
    },
    actions: {
        requestBuyTicket(commit, ticketInfo) {
            const CSRF_TOKEN=localStorage.getItem("accessToken");
            http
            .post(`/api/v2/ticket/buy`, ticketInfo, 
                {headers: {"Authorization": 'Bearer '+ CSRF_TOKEN}
            })
              .then()
              .catch((err) => {
                alert(err.response.data.message);
                  console.error();
              });
        },
        selectTicket({ commit }, ticketInfo) {
          commit('SET_TICKET', ticketInfo);
        }
    },
  };
