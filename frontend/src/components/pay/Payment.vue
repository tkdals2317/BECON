<template>
  <section class="contact-section">
    <div class="imp-container">
      <div class="form-box">
        <div class="default-form">
          <div class="row clearfix" >
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner">
                <div class="field-inner" style="margin-top:18px; font-size:20px;">
                  PG사
                </div>
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                <select
                  v-model="form.pg"
                  size="large"
                  @change="handlePg"
                >
                  <option
                    v-bind:key="pg.value"
                    v-for="pg in pgs"
                    :value="pg.value"
                  >
                  {{ pg.label }}
                  </option>
                </select> 
              </div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner" style="margin-top:18px; font-size:20px;">
                  결제수단
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                <select
                  v-model="form.payMethod"
                  size="large"
                  @change="handleMethod"
                >
                  <option
                    v-bind:key="method.value"
                    v-for="method in methods"
                    :value="method.value"
                  >
                    {{ method.label }}
                  </option>
                </select>
              </div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12"  v-if="quotaVisible">
              <div class="field-inner" style="margin-top:18px; font-size:20px;">
                  할부개월수
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12"  v-if="quotaVisible">
              <div class="field-inner">
                <select
                  v-model="form.quota"
                  size="large"
                >
                  <option
                    v-bind:key="quota"
                    v-for="quota in quotas"
                    :value="quota"
                  >
                    {{
                      quota === "0"
                        ? "PG사 기본제공"
                        : quota === "1"
                        ? "일시불"
                        : `${quota}개월`
                    }}
                  </option>
                </select>
              </div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12"  v-if="vbankDueVisible">
              <div class="field-inner" style="margin-top:18px; font-size:20px;">
                  입금기한
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12"  v-if="vbankDueVisible">
              <div class="field-inner">
                <input
                v-model="form.vbankDue"
              placeholder="YYYYMMDDhhmm"
              size="large"
              type="number"
            />

              </div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner" style="margin-top:18px; font-size:20px;">
                  주문번호
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                 <input
                    v-model="form.merchantUid"
                    type="text"
                    readOnly
                  />
              </div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner" style="margin-top:18px; font-size:20px;">
                 상품명
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  v-model="form.name"
                  type="text"
                  readOnly
                />
              </div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner" style="margin-top:18px; font-size:20px;">
                  결제금액
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  v-model="form.amount"
                  size="large"
                  type="number"
                  readOnly
                />
              </div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner" style="margin-top:18px; font-size:20px;">
                  이름
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  v-model="form.buyerName"
                  type="text"
                  readOnly
                />
              </div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner" style="margin-top:18px; font-size:20px;">
                  연락처
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  v-model="form.buyerTel"
                  type="text"
                  readOnly
                />
              </div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner" style="margin-top:18px; font-size:20px;">
                  이메일
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  v-model="form.buyerEmail"
                  type="text"
                  readOnly
                />
              </div>
            </div>
            <div class="form-group col-lg-6 col-md-12 col-sm-12">
              <div class="field-inner">
                <button class="theme-btn btn-style-two" @click="handleGoBack">
                  <i class="btn-curve"></i>
                  <span
                  class="btn-title"
                  type="button"
                  >취소</span></button>
              </div>
            </div>
            <div class="form-group col-lg-6 col-md-12 col-sm-12">
              <div class="field-inner">
                <button class="theme-btn btn-style-one" type="primary" size="large" @click="handleSubmit">
                  <i class="btn-curve"></i>
                  <span
                  class="btn-title"
                  type="button"
                  >결제</span></button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { PGS } from "@/common/lib/constants";
import Utils from "@/common/lib/utils";
import { mapGetters } from 'vuex';

export default {
  data() {
    return {
      formLayout: "horizontal",
      // form: this.$form.createForm(this, { name: "payment" }),
      form: {
        pg: 'html5_inicis',
        payMethod: 'card',
        quota: '0',
        vbankDue: {
          rules: [
            {
              required: true,
              message: '가상계좌 입금기한은 필수입력입니다',
            },
          ],
        },
        bizNum: {
          rules: [
            { required: true, message: '사업자번호는 필수입력입니다' }
          ]
        },
        merchantUid: `${new Date().getTime()}`,
        name: '',
        amount: '',
        buyerName: '',
        buyerTel: '',
        buyerEmail: '',
      },
      pgs: PGS,
      methods: Utils.getMethodsByPg(),
      quotas: Utils.getQuotaByPg(),
      initialMethod: "card",
      vbankDueVisible: false,
      bizNumVisible: false,
      quotaVisible: true,
    };
  },
  created() {
    this.form.name = this.getTicketInfo.title + ' ' + this.getTicketInfo.type;
    this.form.amount = this.getTicketInfo.price;
    this.form.buyerName = this.getUserInfo.userName;
    this.form.buyerTel = this.getUserInfo.userPhone.replace('-','');
    this.form.buyerEmail = this.getUserInfo.userEmail;
  },
  computed :{
    ...mapGetters('user',['getUserInfo']),
    ...mapGetters('ticket',['getTicketInfo']),
    checkVal() {
      return true;
    }
  },
  methods: {
    handleSubmit() {
      if (this.checkVal) {
        const { IMP } = window;
        IMP.init(Utils.getUserCodeByPg(this.form.pg));
        const data = {
          pg: this.form.pg,
          pay_method: this.form.payMethod,
          escrow: 'checked',
          merchant_uid: this.form.merchantUid,
          name: this.form.name,
          amount: this.form.amount,
          buyer_name: this.form.buyerName,
          buyer_tel: this.form.buyerTel,
          buyer_email: this.form.buyerEmail,
          buyer_addr: '서울시 강남구 신사동 661-16',
          buyer_postcode: '06010',
          niceMobileV2: true,
        };

        if (this.form.payMethod === "vbank") {
          data.vbank_due = this.form.vbankDue;
          if (this.form.pg === "danal_tpay") {
            data.biz_num = this.form.bizNum;
          }
        }
        if (this.form.payMethod === "card") {
          data.display = {
            card_quota: this.form.quota,
          };
        }
        IMP.request_pay(data, this.callback);
      }
    },
    handlePg() {
      const newMethods = Utils.getMethodsByPg(this.form.pg);
      const [{ value }] = newMethods;

      this.methods = Utils.getMethodsByPg(this.form.pg);
      this.form.payMethod = value;

      this.setVisible(this.form.pg, value);
    },
    handleMethod() {
      const pg = this.form.pg;
      this.setVisible(pg, this.form.payMethod);
    },
    setVisible(pg, method) {
      // 가상계좌 입금기한 렌더링 여부
      const vbankDueVisible = method === "vbank";
      this.vbankDueVisible = vbankDueVisible;

      // 사업자 번호 렌더링 여부
      this.bizNumVisible = pg === "danal_tpay" && vbankDueVisible;

      // 할부개월수 렌더링 여부
      this.quotaVisible = method === "card";
    },
    handleGoBack() {
      this.$router.push("/");
    },
    callback(response) {
      const query = {
        ...response,
      };
      this.$router.push({ path: "/result", query });
    },
  },
};
</script>

<style>
.ant-select-selection-selected-value {
  font-size: 16px !important;
  line-height: 2.5 !important;
}
.design{
  position: relative;
  display: block;
  height: 70px;
  width: 100%;
  font-size: 18px;
  color: var(--thm-black);
  line-height: 40px;
  font-weight: 400;
  padding: 14px 30px;
  letter-spacing: 0.02em;
  background-color: #f4f5f8;
  border: 1px solid #f4f5f8;
  border-radius: 7px;
  -webkit-transition: all 300ms ease;
  -ms-transition: all 300ms ease;
  -o-transition: all 300ms ease;
  -moz-transition: all 300ms ease;
  transition: all 300ms ease;
}
.design_option{

}
</style>