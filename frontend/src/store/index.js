import Vue from "vue";
import Vuex from "vuex";

import user from "./modules/user";
import concert from "./modules/concert";
Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    user,
    concert,
  },
});
