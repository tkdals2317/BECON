import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";

import user from "./modules/user";
import concert from "./modules/concert";
import room from "./modules/room";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    user,
    concert,
    room,
  },
  plugins: [
    createPersistedState({
      paths: ["user", "room", "concert"],
    })
  ],
});
