import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import VueSimpleAlert from "vue-simple-alert";
import Antd from 'ant-design-vue';

Vue.use(Antd);
Vue.use(VueSimpleAlert, { reverseButtons: true });

Vue.config.productionTip = false;

var VueTruncate = require('vue-truncate-filter')
Vue.use(VueTruncate)

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");

