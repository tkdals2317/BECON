import Vue from "vue";
import VueRouter from "vue-router";

import Home from "../views/index.vue";
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
import Regist from "../views/regist.vue";
import Ticketing from "../views/ticketing.vue";
import Myconcert from "../views/myconcert.vue";
import ConcertConfirm from "../views/concertConfirm.vue";
import QA from "../views/qa.vue";
import QnA from "../views/qnaresult.vue";
import Payment from "../views/payment.vue";
import Result from "../views/result.vue";
import VueSimpleAlert from "vue-simple-alert";

Vue.use(VueRouter);

const requireAuth = () => (to, from, next) => {
  if (localStorage.getItem('accessToken')) {
    return next();
  }
  VueSimpleAlert.fire({
    title:"서비스 권한 없음",
    text:"로그인이 필요한 서비스입니다.",
    type:"error",
}).then(() => {
    next('/login');
  }); 
};

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
    beforeEnter: requireAuth()
  },
  {
    path: "/concertPage",
    name: "ConcertPage",
    component: ConcertPage,
    beforeEnter: requireAuth()
  },
  {
    path: "/concertRegist",
    name: "ConcertRegist",
    component: ConcertRegist,
    beforeEnter: requireAuth()
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
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/mypage",
    name: "MyPage",
    component: MyPage,
    beforeEnter: requireAuth()
  },
  {
    path: "/faqs",
    name: "Faqs",
    component: Faqs,
  },
  {
    path: "/regist",
    name: "Regist",
    component: Regist,
  },
  {
    path: "/concertConfirm",
    name: "ConcertConfirm",
    component: ConcertConfirm,
    beforeEnter: requireAuth()
  },
  {
    path: "/service",
    name: "Service",
    component: Service,
    beforeEnter: requireAuth()
  },
  {
    path: "/concertCK",
    name: "ConcertCheck",
    component: ConcertCheck,
    beforeEnter: requireAuth()
  },
  {
    path: "/ticketing",
    name: "Ticketing",
    component: Ticketing,
    beforeEnter: requireAuth()
  },
  {
    path: "/myconcert",
    name: "Myconcert",
    component:Myconcert,
    beforeEnter: requireAuth()
  },
  {
    path: "/qa",
    name: "QA",
    component: QA,
    beforeEnter: requireAuth()
  },
  {
    path: "/qnaresult",
    name: "QnA",
    component: QnA,
  },
  {
    path: "/payment",
    name: "Payment",
    component: Payment,
    beforeEnter: requireAuth()
  },
  {
    path: "/result",
    name: "Result",
    component: Result,
    beforeEnter: requireAuth()
  },
];

const router = new VueRouter({
  mode: "history",
  base: "",
  routes,
});


export default router;
