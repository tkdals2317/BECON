import http from "@/common/lib/http";

export default {
  namespaced: true,
  state: {
    total: 0,
    playing: 0,
    categories: [],
    concertInfos: [],
    registConcertList: {},
    concertDetail: [],
    comingConcerts: [],
    concertConfirm:'',
  },

  getters: {
    getConcertCategory(state) {
      return state.concertCategory;
    },
    getCategories(state) {
      return state.categories;
    },
    getConcertInfos(state) {
      return state.concertInfos;
    },
    getRegistConcertList(state) {
      return state.registConcertList;
    },
    getDetail(state) {
      return state.concertDetail;
    },
    getComingConcert(state) {
      return state.comingConcerts;
    },
    getConfrimConcert(state) {
      return state.concertConfirm;
    },
    getTotalConcert(state) {
      return state.total;
    },
    getIngConcert(state) {
      return state.playing;
    }
  },

  mutations: {
    CATEGORY(state, payload) {
      state.categories = payload;
    },
    CONCERT(state, payload) {
      state.concertInfos = payload;
    },
    REGISTCONCERT(state, payload) {
      state.registConcertList = payload;
    },
    DETAIL(state, payload) {
      state.concertDetail = payload;
    },
    SET_COMING_CONCERT(state, payload) {
      payload.forEach(element => {
        var start = new Date(element.startTime);
        var now = new Date();

        var diff = (start.getTime() - now.getTime())/1000;

        element['minute'] = Math.floor(diff / 60);
        element['second'] = Math.floor(diff % 60);
      });
      state.comingConcerts = payload;
    },
    GET_CONFIRM_CONCERT(state, payload){
      state.concertConfirm=payload;
    },
    SET_TOTAL_CONCERT(state, payload) {
      state.total = payload;
    },
    SET_TOTAL_PLAYING(state, payload) {
      state.playing = payload;
    }
  },
  actions: {
    requestRegistConcert({commit}, concert) {
      var formData = new FormData();
      const CSRF_TOKEN = localStorage.getItem("accessToken");
      for (var variable in concert) {
        formData.append(variable, concert[variable]);
      }
      http
        .post(`/api/v2/concert/regist`, formData, {
          headers: {
            Authorization: "Bearer " + CSRF_TOKEN,
            "Content-Type": "multipart/form-data",
          },
        })
        .then(({data}) => {
          commit("GET_CONFIRM_CONCERT", data);
        })
        .catch((error) => {
          if (error.response) {
            // 요청이 이루어졌으며 서버가 2xx의 범위를 벗어나는 상태 코드로 응답했습니다.
            console.log(error.response.data);
            console.log(error.response.status);
            console.log(error.response.headers);
          }
          else if (error.request) {
            // 요청이 이루어 졌으나 응답을 받지 못했습니다.
            // `error.request`는 브라우저의 XMLHttpRequest 인스턴스 또는
            // Node.js의 http.ClientRequest 인스턴스입니다.
            console.log(error.request);
          }
          else {
            // 오류를 발생시킨 요청을 설정하는 중에 문제가 발생했습니다.
            console.log('Error', error.message);
          }
        });
    },
    requestCategory({ commit }) {
      http
        .get(`/api/v2/concert/concert-categories`)
        .then(({ data }) => {
          this.categories = data;
          commit("CATEGORY", data);
        })
        .catch(() => {
        });
    },
    requestConcert({ commit }, category) {
      http
        .get("/api/v2/concert/findByCategory/" + category)
        .then(({ data }) => {
          commit("CONCERT", data);
        })
        .catch(() => {
          console.error();
        });
    },
    requestCheckConcert({ commit }) {
      const CSRF_TOKEN = localStorage.getItem("accessToken");
      http
        .get(`/api/v2/concert/findByOwnerId`, {
          headers: { Authorization: "Bearer " + CSRF_TOKEN },
        })
        .then(({ data }) => {
          commit("REGISTCONCERT", data);
        })
        .catch(() => {
          console.error();
        });
    },
    findConcertDetail({ commit }, concertId) {
      const CSRF_TOKEN = localStorage.getItem("accessToken");
      http
        .get(`/api/v2/concert/${concertId}`, {
          headers: { Authorization: "Bearer " + CSRF_TOKEN },
        })
        .then(({ data }) => {
          commit("DETAIL", data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    findComingConcert({ commit }) {
      http
        .get(`/api/v2/concert/findComing`)
        .then(({ data }) => {
          commit("SET_COMING_CONCERT", data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    findTotalConcert({ commit }) {
      http
        .get(`/api/v2/concert/total`)
        .then(({ data }) => {
          commit("SET_TOTAL_CONCERT", data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    findIngConcert({ commit }) {
      http
        .get(`/api/v2/concert/playing`)
        .then(({ data }) => {
          commit("SET_TOTAL_PLAYING", data);
        })
        .catch((err) => {
          console.log(err);
        });
    }
  },
};
