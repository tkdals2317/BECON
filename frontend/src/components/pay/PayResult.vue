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
    <h3>{{ type === 'payment' ? '결제' : '본인인증' }}에 {{ success ? '성공' : '실패'}}했습니다</h3>
    </div>
    <ul>
      <li>
        <span>아임포트 번호</span>
        <span>{{ impUid }}</span>
      </li>
      <li>
        <span>주문번호</span>
        <span>{{ merchantUid }}</span>
      </li>
      <li v-if="!success">
        <span>에러 메시지</span>
        <span>{{ errorMessage }}</span>
      </li>
    </ul>
    <a-button size="large" @click="handleGoBack">
      뒤로가기
    </a-button>
    </div>
  </div>
</section>
</template>

<script>
export default {
  data() {
    const { query } = this.$router.history.current;
    const { type } = query;
    return {
      type,
      success: this.getSuccess(query),
      impUid: query.imp_uid,
      merchantUid: query.merchant_uid,
      errorMessage: `[${query.error_code}] ${query.error_msg}`,
    };
  },
  methods: {
    getSuccess(query) {
      const { success } = query;
      const impSuccess = query.imp_success;
      if (impSuccess === undefined) {
        if (typeof success === 'string') {
          return success === 'true';
        }
        return success;
      }
      if (typeof impSuccess === 'string') {
        return impSuccess === 'true';
      }
      return impSuccess;
    },
    handleGoBack() {
      this.$router.push(`/${this.type}`);
    },
  },
};
</script>
<style scoped>
ul li span {
  font-size: 20px;
}
</style>