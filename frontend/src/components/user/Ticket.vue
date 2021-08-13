<template>
  <section class="contact-section">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>티켓 예매</h2>
      </div>
      <div class="form-box">
        <div class="sec-title">
          <div class="ticket ticket-1">
            <div class="date">
              <span class="day">24</span>
              <span class="month-and-time"
                >{{ concert.startTime }}<br /><span class="small">{{ concert.endTime }}</span></span
              >
            </div>
            <div class="artist">
              <span class="name">STAND</span>
              <br />
              <span class="small">{{ concert.priceStand }}</span>
            </div>
            <div class="location">
              <span>{{ concert.title }}</span>
              <br />
              <span class="small"><span>{{ concert.owner }}</span></span>
            </div>
            <div class="rip"></div>
            <div class="cta">
              <button class="buy" @click="clickBuyStand()">BUY TICKET</button>
            </div>
          </div>

          <div class="ticket ticket-2">
            <div class="date">
              <span class="day">24</span>
              <span class="month-and-time"
                >{{ concert.startTime }}<br /><span class="small">{{ concert.endTime }}</span></span
              >
            </div>
            <div class="artist">
              <span class="name">VIP</span>
              <br />
              <span class="small">{{ concert.priceVip }}</span>
            </div>
            <div class="location">
              <span>{{ concert.title }}</span>
              <br />
              <span class="small"><span>{{ concert.owner }}</span></span>
            </div>
            <div class="rip"></div>
            <div class="cta">
              <button class="buy" @click="clickBuyVip()">BUY TICKET</button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <a-form
      :form="form"
      :label-col="{ span: 6 }"
      :wrapper-col="{ span: 18 }"
      :colon="false"
      labelAlign="left"
      @submit="handleSubmit"
      v-show="false"
    >
      <a-form-item label="주문번호">
        <a-input
          v-decorator="[
            'merchantUid',
            { initialValue: initialMerchantUid },
          ]"
          size="large"
        />
      </a-form-item>
      <a-form-item label="회사명">
        <a-input
          v-decorator="['company', { initialValue: 'SIOT' }]"
          size="large"
        />
      </a-form-item>
      <a-form-item label="통신사">
        <a-select
          v-decorator="['carrier', { initialValue: getUserInfo.userCarrier }]"
          size="large"
        >
          <a-select-option value="SKT">
            SKT
          </a-select-option>
          <a-select-option value="KTF">
            KT
          </a-select-option>
          <a-select-option value="LGT">
            LGU+
          </a-select-option>
          <a-select-option value="MVNO">
            알뜰폰
          </a-select-option>
        </a-select>
      </a-form-item>
      <a-form-item label="이름">
        <a-input
          v-decorator="['name', { initialValue: getUserInfo.userName }]"
          size="large"
        />
      </a-form-item>
      <a-form-item label="전화번호">
        <a-input
          v-decorator="['phone', { initialValue: getUserInfo.userPhone }]"
          type="number"
          size="large"
        />
      </a-form-item>
      <a-form-item label="허용최소연령">
        <a-input
          v-decorator="['minAge', { initialValue: concert.minAge }]"
          type="number"
          size="large"
        />
      </a-form-item>
      <a-button size="large" @click="handleGoBack">
        뒤로가기
      </a-button>
      <a-button type="primary" html-type="submit" size="large">
        본인인증
      </a-button>
    </a-form>
  </section>
</template>

<script>
import { mapActions, mapGetters } from 'vuex';

export default {
  name: "Ticket",
  data() {
    return {
      formLayout: 'horizontal',
      form: this.$form.createForm(this, { name: 'certification' }),
      initialMerchantUid: `mid_${new Date().getTime()}`,
    };
  },
  props: {
    concert: Object,
  },
  created() {
    window.scrollTo(0, 0);
    this.requestUserInfo();
  },
  computed :{
    ...mapGetters('user',['getUserInfo']),
  },
  methods:{
    ...mapActions('user', ['requestUserInfo']),
    ...mapActions('ticket', ['selectTicket']),
    getNow(){
      const today = new Date();
      const date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
      const time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
      const dateTime = date +' '+ time;
      this.timestamp = dateTime;
    },
    clickBuyStand(){
      this.handleSubmit(1);
      // this.$router.push('/payment');
      // this.getNow();
      // let ticket={
      //   buyDate:this.timestamp,
      //   price:this.concert.priceStand,
      //   type:"Standard",
      //   concert:this.concert.id
      // }
      // this.requestBuyTicket(ticket);
    },
    clickBuyVip(){
      this.handleSubmit(2);
      // this.$router.push('/payment');
    //  this.getNow();
    //   let ticket={
    //     buyDate:this.timestamp,
    //     price:this.concert.priceVip,
    //     type:"Vip",
    //     concert:this.concert.id
    //   }
    //   this.requestBuyTicket(ticket);
    },
    handleSubmit(type) {
      if (type === 1) {
        this.callback = this.callbackStand;
      } else {
        this.callback = this.callbackVip;
      }
      this.form.validateFields((err, values) => {
        if (!err) {
          const {
            merchantUid, company, carrier, name, phone, minAge,
          } = values;
          const { IMP } = window;
          IMP.init('imp10391932');
          const data = {
            merchant_uid: merchantUid,
            company,
            carrier,
            name,
            phone,
            min_age: minAge,
          };
          IMP.certification(data, this.callback);
        }
      });
    },
    handleGoBack() {
      this.$router.push('/');
    },
    callbackStand(response) {
      this.success = this.getSuccess(response);
      if (!this.success) {
        alert('인증에 실패했습니다.')
        return;
      }

      this.selectTicket({
        concertId: this.concert.id,
        title: this.concert.title,
        type: 'STAND',
        price: this.concert.priceStand,
      });

      this.$router.push('/payment');
    },
    callbackVip(response) {
      this.success = this.getSuccess(response);
      if (!this.success) {
        alert('인증에 실패했습니다.')
        return;
      }

      this.selectTicket({
        concertId: this.concert.id,
        title: this.concert.title,
        type: 'VIP',
        price: this.concert.priceVip,
      });

      this.$router.push('/payment');
    },
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
  },
};
</script>

<style scoped>
body {
  background-color: #436ea5;
}

.ticket {
  font-family: '양진체';
  background-repeat: no-repeat;
  background-position: top;
  background-size: 100%;
  background-color: #04030c;
  width: 700px;
  height: 300px;
  border-radius: 15px;
  -webkit-filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
  filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
  display: block;
  margin: 10% auto auto auto;
  color: #fff;
}

.date {
  margin: 15px;
  -webkit-filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
  filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
}

.date .day {
  font-size: 80px;
  float: left;
}

.date .month-and-time {
  float: left;
  margin: 15px 0 0 0;
  font-weight: bold;
}

.artist {
  font-size: 40px;
  margin: 10px 0px 0 30px;
  float: left;
  font-weight: bold;
  -webkit-filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
  filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
}

.location {
  float: left;
  margin: 180px 0 0 auto;
  font-size: 30px;
  font-weight: bold;
  -webkit-filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
  filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
}

/* .location::before {
  background-image: url('https://upload.wikimedia.org/wikipedia/commons/c/cb/QRCodeWikipedia.png');
  background-size: 50px 50px;
  margin: 0 0 0 0 ;
  width: 50px; 
  height: 50px;
  content:"";
  display: inline-block;
  float: left;
  position: absolute;
  left: -160px;
  bottom: 5px;
  -webkit-filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
            filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3)); 
} */

.rip {
  border-right: 8px dotted #436ea5;
  height: 300px;
  position: absolute;
  top: 0;
  left: 560px;
}

.cta .buy {
  position: absolute;
  top: 135px;
  right: 15px;
  display: block;
  font-size: 12px;
  font-weight: bold;
  background-color: #436ea5;
  padding: 10px 20px;
  border-radius: 25px;
  color: #fff;
  text-decoration: none;
  -webkit-transform: rotate(-90deg);
  -ms-transform: rotate(-90deg);
  transform: rotate(-90deg);
  -webkit-filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
  filter: drop-shadow(1px 1px 3px rgba(0, 0, 0, 0.3));
}

.small {
  font-weight: 150;
}
.middle {
  font-weight: 300;
}

.ticket-1 {
  background-image: url(https://images.unsplash.com/photo-1483101974978-cf266fdf1139?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=3289&q=80);
}

.ticket-2 {
  background-image: url(https://images.unsplash.com/photo-1550184658-ff6132a71714?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2180&q=80);
}
</style>
