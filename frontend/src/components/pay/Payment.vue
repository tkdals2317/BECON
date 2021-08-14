<template>
  <section class="contact-section">
    <div class="imp-container">
      <div class="form-box">
        <div class="default-form">
          <div class="row clearfix">
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-form
                  :form="form"
                  :label-col="{ span: 6 }"
                  :wrapper-col="{ span: 18 }"
                  :colon="false"
                  labelAlign="left"
                  @submit="handleSubmit"
                />
                <a-form-item label="PG사"></a-form-item>
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-select
                  v-decorator="['pg', { initialValue: 'html5_inicis' }]"
                  size="large"
                  @change="handlePg"
                >
                  <a-select-option
                    v-bind:key="pg.value"
                    v-for="pg in pgs"
                    :value="pg.value"
                  >
                  {{ pg.label }}
                  </a-select-option>
                </a-select> 
              </div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-form-item label="결제수단"></a-form-item>
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-select
                  v-decorator="['payMethod', { initialValue: 'card' }]"
                  size="large"
                  @change="handleMethod"
                >
                  <a-select-option
                    v-bind:key="method.value"
                    v-for="method in methods"
                    :value="method.value"
                  >
                    {{ method.label }}
                  </a-select-option>
                </a-select>
              </div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-form-item label="결제수단"></a-form-item>
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-select
                  v-decorator="['payMethod', { initialValue: 'card' }]"
                  size="large"
                  @change="handleMethod"
                >
                  <a-select-option
                    v-bind:key="method.value"
                    v-for="method in methods"
                    :value="method.value"
                  >
                    {{ method.label }}
                  </a-select-option>
                </a-select>
              </div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-form-item label="할부개월수" v-if="quotaVisible"></a-form-item>
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-select
                  v-decorator="['quota', { initialValue: '0' }]"
                  size="large"
                >
                  <a-select-option
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
                  </a-select-option>
                </a-select>
              </div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-form-item label="주문번호"></a-form-item>
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                 <a-input
                    v-decorator="[
                      'merchantUid',
                      { initialValue: initialMerchantUid },
                    ]"
                    size="large"
                    readOnly
                  />
              </div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner">
                 <a-form-item label="상품명"></a-form-item>
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-input
                  v-decorator="[
                    'name',
                    { initialValue: getTicketInfo.title + ' ' + getTicketInfo.type },
                  ]"
                  size="large"
                  readOnly
                />
              </div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-form-item label="결제금액"></a-form-item>
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-input
              v-decorator="['amount', { initialValue: getTicketInfo.price/100 }]"
              size="large"
              type="number"
              readOnly
            />
              </div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-form-item label="이름"></a-form-item>
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-input
                  v-decorator="['buyerName', { initialValue: getUserInfo.userName }]"
                  size="large"
                  readOnly
                />
              </div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-form-item label="연락처"></a-form-item>
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-input
              v-decorator="['buyerTel', { initialValue: getUserInfo.userPhone.replace(/\-/g,'') }]"
              size="large"
              type="text"
              readOnly
            />
              </div>
            </div>
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-form-item label="이메일"></a-form-item>
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-input
                  v-decorator="[
                    'buyerEmail',
                    { initialValue: getUserInfo.userEmail },
                  ]"
                  size="large"
                  readOnly
                />
              </div>
            </div>
            <div class="form-group col-lg-6 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-button size="large" @click="handleGoBack"> 취소 </a-button>
              </div>
            </div>
            <div class="form-group col-lg-6 col-md-12 col-sm-12">
              <div class="field-inner">
                <a-button type="primary" html-type="submit" size="large">결제</a-button>
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
      form: this.$form.createForm(this, { name: "payment" }),
      initialMerchantUid: `${new Date().getTime()}`,
      pgs: PGS,
      methods: Utils.getMethodsByPg(),
      quotas: Utils.getQuotaByPg(),
      initialMethod: "card",
      vbankDueVisible: false,
      bizNumVisible: false,
      quotaVisible: true,
    };
  },
  computed :{
    ...mapGetters('user',['getUserInfo']),
    ...mapGetters('ticket',['getTicketInfo']),
  },
  methods: {
    handleSubmit(e) {
      e.preventDefault();
      this.form.validateFields((err, values) => {
        if (!err) {
          const {
            pg,
            payMethod,
            escrow,
            vbankDue,
            bizNum,
            quota,
            merchantUid,
            name,
            amount,
            buyerName,
            buyerTel,
            buyerEmail,
            buyerAddr,
            buyerPostcode,
          } = values;
          const { IMP } = window;
          IMP.init(Utils.getUserCodeByPg(pg));
          const data = {
            pg,
            pay_method: payMethod,
            escrow,
            merchant_uid: merchantUid,
            name,
            amount,
            buyer_name: buyerName,
            buyer_tel: buyerTel,
            buyer_email: buyerEmail,
            buyer_addr: buyerAddr,
            buyer_postcode: buyerPostcode,
            niceMobileV2: true,
          };

          if (payMethod === "vbank") {
            data.vbank_due = vbankDue;
            if (pg === "danal_tpay") {
              data.biz_num = bizNum;
            }
          }
          if (payMethod === "card") {
            data.display = {
              card_quota: quota,
            };
          }
          IMP.request_pay(data, this.callback);
        }
      });
    },
    handlePg(pg) {
      const newMethods = Utils.getMethodsByPg(pg);
      const [{ value }] = newMethods;

      this.methods = Utils.getMethodsByPg(pg);
      this.form.setFieldsValue({
        payMethod: value,
      });

      this.setVisible(pg, value);
    },
    handleMethod(method) {
      const pg = this.form.getFieldValue("pg");
      this.setVisible(pg, method);
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
</style>