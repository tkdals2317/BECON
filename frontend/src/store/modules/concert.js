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
        .catch(() => {
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
