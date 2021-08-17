import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";

import user from "./modules/user";
import concert from "./modules/concert";
import room from "./modules/room";
import ticket from "./modules/ticket";
import email from "./modules/email";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    user,
    concert,
    room,
    ticket,
    email,
  },
  plugins: [
    createPersistedState({
      paths: ["user", "room", "concert", "ticket", "email"],
    })
  ],
});
