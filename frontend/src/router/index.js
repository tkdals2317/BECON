import Vue from "vue";
import VueRouter from "vue-router";

import Home from "../views/index.vue";
import Contact from "../views/contact.vue";
import Faqs from "../views/faqs.vue";
import NotFound from "../views/not-found.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/contact",
    name: "Contact",
    component: Contact,
  },
  {
    path: "/faqs",
    name: "Faqs",
    component: Faqs,
  },
  {
    path: "/notfound",
    name: "NotFound",
    component: NotFound,
  },
];

const router = new VueRouter({
  mode: "history",
  base: "",
  routes,
});

export default router;
