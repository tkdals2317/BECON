import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import VueAxios from './common/lib/axios'
import axios from './common/lib/axios'

import VueCarousel from 'vue-carousel';
 

Vue.config.productionTip = false;
Vue.use(VueAxios, axios)
Vue.use(VueCarousel);

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");

