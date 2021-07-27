import Vue from "vue";
import VueRouter from "vue-router";

import Home from "../views/index.vue";
import Contact from "../views/contact.vue";
import Login from "../views/login.vue";
import MyPage from "../views/mypage.vue";
import ConcertRegist from "../views/concertRegist.vue";
import Faqs from "../views/faqs.vue";
import Register from "../views/register.vue";
import NotFound from "../views/not-found.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/concertRegist",
    name: "ConcertRegist",
    component: ConcertRegist,
  },
  {
    path: "/contact",
    name: "Contact",
    component: Contact,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/mypage",
    name: "MyPage",
    component: MyPage,
  },
  {
    path: "/faqs",
    name: "Faqs",
    component: Faqs,
  },
  {
    path: "/regist",
    name: "Register",
    component: Register,
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
