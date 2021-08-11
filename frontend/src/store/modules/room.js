export default {
  namespaced: true,
  state: {
    concert: {},
  },
  getters: {
    getRoomId(state) {
      return state.concert.id;
    },
    getStartTime(state) {
      return state.concert.startTime;
    },
    getConcert(state) {
      return state.concert;
    },
  },
  mutations: {
    SET_ENTER_CONCERT(state, payload) {
      state.concert = payload;
    },
  },
  actions: {
    setEnterConcert({ commit }, concert) {
      commit("SET_ENTER_CONCERT", concert);
    },
  },
};
