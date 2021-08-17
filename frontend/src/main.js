import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import { library } from '@fortawesome/fontawesome-svg-core'
import { faUserSecret, faClock, faMicrophone} from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import Antd from 'ant-design-vue';

Vue.use(Antd);

library.add(faUserSecret, faClock, faMicrophone)

Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.config.productionTip = false;

var VueTruncate = require('vue-truncate-filter')
Vue.use(VueTruncate)

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");

