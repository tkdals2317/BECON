<template>
  <section class="contact-section">
    <div class="auto-container">
      <div class="sec-title centered">
        <h2>Let's go have fun<span class="dot">!</span></h2>
      </div>
      <div class="form-box">
        <div class="default-form">
          <div class="row clearfix">
            <div class="form-group col-lg-12 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  type="text"
                  v-model="concert.title"
                  name="Title"
                  value=""
                  placeholder="공연 제목"
                  required=""
                />
              </div>
            </div>
            <div class="form-group col-lg-12 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  type="text"
                  v-model="concert.description"
                  name="Description"
                  value=""
                  placeholder="간단한 공연 설명을 적어주세요."
                  required=""
                />
              </div>
            </div>
            <div class="form-group col-lg-6 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  type="date"
                  v-model="time.startDay"
                  name="StartDay"
                  value=""
                  required=""
                />
              </div>
            </div>
            <div class="form-group col-lg-3 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  type="time"
                  v-model="time.startClock"
                  name="StartClock"
                  min="00:00"
                  max="24:00"
                  required=""
                />
              </div>
            </div>
            <div class="form-group col-lg-3 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  type="time"
                  v-model="time.endClock"
                  name="EndClock"
                  min="00:00"
                  max="24:00"
                  placeholder="14:00"
                  required=""
                />
              </div>
            </div>
            <div class="form-group col-lg-4 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  type="text"
                  v-model="concert.priceVip"
                  name="PriceVip"
                  value=""
                  placeholder="Vip 가격"
                  required=""
                />
              </div>
            </div>
            <div class="form-group col-lg-4 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  type="text"
                  v-model="concert.priceStand"
                  name="PriceStand"
                  value=""
                  placeholder="Stand 가격"
                  required=""
                />
              </div>
            </div>
            <div class="form-group col-lg-4 col-md-12 col-sm-12">
              <div class="field-inner">
                <input
                  type="text"
                  v-model="concert.minAge"
                  name="MinAge"
                  value=""
                  placeholder="연령제한"
                  required=""
                />
              </div>
            </div>
            <div class="form-group col-lg-6 col-md-12 col-sm-12">
              <div class="field-inner">
                <select
                  v-model="concert.categoryName"
                  name="CategoryName"
                  value=""
                  placeholder="CategoryName"
                  required=""
                >
                  <!-- 카테고리 부분 -->
                  <option value="">공연 카테고리</option>
                  <option
                    v-for="category in getCategories"
                    :key="category.id"
                    :value="category.name"
                  >
                    {{ category.name }}
                  </option>
                </select>
              </div>
            </div>
            <div class="form-group col-lg-6 col-md-12 col-sm-12">
              <div class="field-inner">
                <input type="file" ref="picture" name="files" required="" />
              </div>
            </div>
            <div class="form-group col-lg-12 col-md-12 col-sm-12">
              <button class="theme-btn btn-style-one">
                <i class="btn-curve"></i>
                <span
                  class="btn-title"
                  type="button"
                  @click="clickRegistConcert()"
                  >콘서트 신청</span
                >
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "ConcertRegistPage",
  data: function () {
    this.$props;
    return {
      concert: {
        title: "",
        description: "",
        startTime: "",
        endTime: "",
        priceVip: "",
        priceStand: "",
        minAge: "",
        categoryName: "",
        files: null,
      },
      time: {
        startDay: "",
        startClock: "",
        endClock: "",
      },
      message: "",
    };
  },
  create() {
    window.scrollTo(0, 0);
  },
  computed: {
    ...mapGetters("concert", ["getCategories"]),
  },

  methods: {
    ...mapActions("concert", ["requestRegistConcert"]),
    clickRegistConcert: function () {
      this.concert.startTime = this.time.startDay + " " + this.time.startClock;
      this.concert.endTime = this.time.startDay + " " + this.time.endClock;
      this.concert.files = this.$refs.picture.files[0];
      this.requestRegistConcert(this.concert);
      this.$router.push({
        name: "ConcertConfirm",
        params: { concert: this.concert },
      });
    },
  },
};
</script>

<style scoped>
.form-group input {
  padding: 14px 20px !important;
}
</style>
