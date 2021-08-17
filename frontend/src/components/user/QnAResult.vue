<template>
  <section class="contact-section">
    <div class="imp-container imp-result">
      <div class="form-box">
        <div>
          <a-icon
            type="check-circle"
            :style="{ fontSize: '100px', color: '#52c41a' }"
          />
          <h3>문의사항 등록 완료.<br><strong>이용해 주셔서 감사합니다.</strong></h3>
        </div>
        <button style="margin-top: 30px;" class="theme-btn btn-style-one" @click="goMain">
          <i class="btn-curve"></i>
          <span class="btn-title">메인으로</span>
        </button>
      </div>
    </div>
  </section>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
  data() {
    return {
    
    };
  },
  created() {
    
  },
  computed: {
    ...mapGetters("ticket", ["getTicketInfo"]),
  },
  methods: {
    ...mapActions('ticket', ['requestBuyTicket']),
    handleGoBack() {
      this.$router.push("/qa");
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
</style>
