
export default {
  namespaced: true,
  state: {
    roomId: '',
  },
  getters: {
    getRoomId(state) {
        return state.roomId;
    }
  },
  mutations: {
      SET_ROOM_ID(state, payload) {
        state.roomId = payload;
      }
  },
  actions: {
      setRoomId({ commit }, roomId) {
        commit('SET_ROOM_ID', roomId);
      }
  }
};
