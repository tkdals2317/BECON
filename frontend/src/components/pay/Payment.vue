<template>
  <section class="contact-section">
    <div class="imp-container">
      <div class="form-box">
        <div class="default-form">
          <div class="row clearfix">
            <div class="form-group col-lg-2 col-md-12 col-sm-12">
              <div class="field-inner">
                <!-- <a-form
                  :form="form"
                  :label-col="{ span: 6 }"
                  :wrapper-col="{ span: 18 }"
                  :colon="false"
                  labelAlign="left"
                  @submit="handleSubmit"
                /> -->
                <div class="field-inner" style="margin-top:18px; font-size:20px;">
                  PG사
                </div>
              </div>
            </div>
            <div class="form-group col-lg-10 col-md-12 col-sm-12">
              <div class="field-inner">
                <select
                  v-decorator="['pg', { initialValue: 'html5_inicis' }]"
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
                  v-decorator="['payMethod', { initialValue: 'card' }]"
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
                  v-decorator="['quota', { initialValue: '0' }]"
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
                v-decorator="[
                'vbankDue',
                {
                  rules: [
                    {
                      required: true,
                      message: '가상계좌 입금기한은 필수입력입니다',
                    },
                  ],
                },
              ]"
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
                    v-model="initialMerchantUid"
                    v-decorator="[
                      'merchantUid',
                      { initialValue: initialMerchantUid },
                    ]"
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
                  :value="getTicketInfo.title+' '+getTicketInfo.type" 
                  v-decorator="[
                    'name',
                    { initialValue: getTicketInfo.title + ' ' + getTicketInfo.type },
                  ]"
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
                  :value="getTicketInfo.price"
                  v-decorator="['amount', { initialValue: getTicketInfo.price}]"
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
                  v-model="getUserInfo.userName"
                  v-decorator="['buyerName', { initialValue: getUserInfo.userName }]"
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
                  v-model="getUserInfo.userPhone"
                  v-decorator="['buyerTel', { initialValue: getUserInfo.userPhone.replace(/\-/g,'') }]"
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
                  v-model="getUserInfo.userEmail"
                  v-decorator="[
                    'buyerEmail',
                    { initialValue: getUserInfo.userEmail },
                  ]"
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
                <button @click="handleSubmit" class="theme-btn btn-style-one" type="primary" html-type="submit" size="large">
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