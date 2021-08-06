import http from "@/common/lib/http";

export default {
  namespaced: true,
  state: {
    categories: [],
    concertInfos: [],
    registConcertList: {},
    concertDetail: [],
    comingConcerts: [],
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
  },
  actions: {
    requestRegistConcert(commit, concert) {
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
        .then(() => {
          alert("공연 신청이 완료되었습니다.");
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
          this.categories = data;
          commit("CATEGORY", data);
        })
        .catch(() => {
          console.error();
        });
    },
    requestConcert({ commit }, category) {
      console.log(category);
      http
        .get("/api/v2/concert/findByCategory/" + category)
        .then(({ data }) => {
          console.log(data);
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
    getConcertDetail({ commit }, concertId) {
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
  },
};
