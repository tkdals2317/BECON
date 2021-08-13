import Vue from "vue";
import VueRouter from "vue-router";

import Home from "../views/index.vue";
import Contact from "../views/contact.vue";
import Waiting from "../views/waiting.vue";
import ConcertPage from "../views/concertPage.vue";
import Service from "../views/service.vue";
import Login from "../views/login.vue";
import MyPage from "../views/mypage.vue";
import ConcertRegist from "../views/concertRegist.vue";
import ConcertCheck from "../views/concertCheck.vue";
import ConcertDetail from "../views/concertDetail.vue";
import ConcertSchedule from "../views/concertSchedule.vue";
import Faqs from "../views/faqs.vue";
import Register from "../views/register.vue";
import Ticketing from "../views/ticketing.vue";
import Myconcert from "../views/myconcert.vue";
import ConcertConfirm from "../views/concertConfirm.vue";
import QA from "../views/qa.vue";
import Singer from "../views/singer.vue";
import Payment from "../views/payment.vue";
import Result from "../views/result.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/waiting",
    name: "Waiting",
    component: Waiting,
  },
  {
    path: "/concertPage",
    name: "ConcertPage",
    component: ConcertPage,
  },
  {
    path: "/concertRegist",
    name: "ConcertRegist",
    component: ConcertRegist,
  },
  {
    path: "/concertSchedule",
    name: "ConcertSchedule",
    component: ConcertSchedule,
  },
  {
    path: "/concertDetail",
    name: "ConcertDetail",
    component: ConcertDetail,
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
    path: "/concertRegist/confirm",
    name: "ConcertConfirm",
    component: ConcertConfirm,
    props: true,
  },
  {
    path: "/service",
    name: "Service",
    component: Service,
  },
  {
    path: "/concertCK",
    name: "ConcertCheck",
    component: ConcertCheck,
    
  },
  {
    path: "/ticketing",
    name: "Ticketing",
    component: Ticketing,
  },
  {
    path: "/myconcert",
    name: "Myconcert",
    component:Myconcert,
  },
  {
    path: "/qa",
    name: "QA",
    component:QA,
  },
  {
    path: "/singer",
    name: "Singer",
    component:Singer,
  },
  {
    path: "/payment",
    name: "Payment",
    component: Payment,
  },
  {
    path: "/result",
    name: "Result",
    component: Result,
  },
];

const router = new VueRouter({
  mode: "history",
  base: "",
  routes,
});


export default router;
