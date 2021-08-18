<template>
  <section class="contact-section">
    <div class="imp-container imp-result">
      <div class="form-box">
        <div>
          <a-icon
            v-if="success"
            type="check-circle"
            :style="{ fontSize: '100px', color: '#52c41a' }"
          />
          <a-icon
            v-else
            type="exclamation-circle"
            :style="{ fontSize: '100px', color: '#f5222d' }"
          />
          <h3 v-if="success">티켓 구매를 완료했습니다.<br><strong>이용해 주셔서 감사합니다.</strong></h3>
          <h3 v-if="!success">결제에 실패했습니다.</h3>
        </div>
        <ul>
          <li>
            <span>상품명 : </span>
            <span>{{ getTicketInfo.title + " " + getTicketInfo.type }}</span>
          </li>
          <li>
            <span>주문번호 : </span>
            <span>{{ merchantUid }}</span>
          </li>
          <li v-if="success">
            <span>결제 금액 : {{ getTicketInfo.price }} 원</span>
          </li>
          <li v-if="!success" style="margin-top: 20px;">
            <span>{{ errorMessage }}.</span>
          </li>
        </ul>
        <div class="btns" style="margin-top: 30px;">
          <a-button v-if="!success" size="large" @click="handleGoBack"> 뒤로가기 </a-button>
          <a-button size="large" @click="goMain"> 메인으로 </a-button>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
  data() {
    const { query } = this.$router.history.current;
    return {
      success: this.getSuccess(query),
      impUid: query.imp_uid,
      merchantUid: query.merchant_uid,
      errorMessage: `${query.error_msg}`,
    };
  },
  created() {
    window.scrollTo(0, 0);
    if (this.success) {
      this.getNow();
      let ticket = {
        buyDate: this.timestamp,
        price: this.getTicketInfo.price,
        type: this.getTicketInfo.type,
        concertId: this.getTicketInfo.concertId,
      };
      this.requestBuyTicket(ticket);
    }
  },
  computed: {
    ...mapGetters("ticket", ["getTicketInfo"]),
  },
  methods: {
    ...mapActions('ticket', ['requestBuyTicket']),
    getNow() {
      const today = new Date();
      const date =
        today.getFullYear() +
        "-" +
        (today.getMonth() + 1) +
        "-" +
        today.getDate();
      const time =
        today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
      const dateTime = date + " " + time;
      this.timestamp = dateTime;
    },
    getSuccess(query) {
      const { success } = query;
      const impSuccess = query.imp_success;
      if (impSuccess === undefined) {
        if (typeof success === "string") {
          return success === "true";
        }
        return success;
      }
      if (typeof impSuccess === "string") {
        return impSuccess === "true";
      }
      return impSuccess;
    },
    handleGoBack() {
      this.$router.push("/payment");
    },
    goMain() {
      this.$router.push("/");
    },
  },
};
</script>
<style scoped>
ul li span {
  font-size: 20px;
}
.btns button {
  width: 100px;
  height: 50px;
}
</style>
