import http from '@/common/lib/http';
//import router from "@/router/index";

export default {
    namespaced: true,
    state: {
      total: 0,
      ticketInfo: {},
      myTicketInfo: [],
    },
    getters: {
      getTicketInfo(state) {
        return state.ticketInfo;
      },
      getTotalTicket(state) {
        return state.total;
      },
      getMyConcertTicket(state) {
        return state.myTicketInfo;
      }
    },
    mutations: {
      SET_TICKET(state, payload) {
        state.ticketInfo = payload;
      },
      SET_TOTAL_TICKET(state, payload) {
        state.total = payload;
      },
      SET_MY_CONCERT_TICKET(state, payload) {
        state.myTicketInfo = payload;
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
        },
        findTotalTicket({ commit }) {
          http
            .get(`/api/v2/ticket/count/total`)
            .then(({ data }) => {
              commit("SET_TOTAL_TICKET", data);
            })
            .catch((err) => {
              console.log(err);
            });
        },
        findMyTicket({ commit }, userId) {
          http
            .get(`/api/v2/ticket/${userId}`)
            .then(({ data }) => {
              commit("SET_MY_CONCERT_TICKET", data);
            })
            .catch(() => {
              console.error();
            });
        },
    },
  };
