import http from '@/common/lib/http';
import VueSimpleAlert from "vue-simple-alert";
//import router from "@/router/index";

export default {
    namespaced: true,
    state: {
      total: 0,
      ticketInfo: {},
      myTicketInfo: [],
      enterTicket: {},
      usersType: [],
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
      },
      getEnterTicket(state) {
        return state.enterTicket;
      },
      getUsersType(state) {
        return state.usersType;
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
      },
      SET_BUY_TICKET(state, payload) {
        state.enterTicket = payload;
      },
      SET_USERS_TYPE(state, payload) {
        state.usersType = payload;
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
        findBuyTicket({ commit }, request) {
          http
            .get(`/api/v2/ticket/buy/${request.userId}/${request.concertId}/${request.code}`)
            .then(({ data }) => {
              if (data) {
                commit("SET_BUY_TICKET", data);
              } else {
                VueSimpleAlert.fire({
                  title: "입장 실패",
                  text: "티켓을 확인해주세요.",
                  type: "warning",
                  timer: 3000
                });
              }
            })
            .catch(() => {
              console.error();
            });
        },
        findUsersType({ commit }, concertId) {
          http
            .get(`/api/v2/ticket/buy/${concertId}`)
            .then(({ data }) => {
              commit("SET_USERS_TYPE", data.type);
            })
            .catch(() => {
              console.error();
            });
        },
    },
  };
