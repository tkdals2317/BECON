import Vue from "vue";
import Vuex from "vuex";

import module1 from "./modules/module1";
import module2 from "./modules/module2";
import user from "./modules/user";
import concert from "./modules/concert";
Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    user,
    concert,
    module1,
    module2,
  },
});
