import Vue from "vue";
import Vuex from "vuex";


import user from "./modules/user";
import module1 from "./modules/module1";
import module2 from "./modules/module2";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    user,
    module1,
    module2,
  },
});
