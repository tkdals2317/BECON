<template>
  <div>
    <section class="gallery-section similar-gallery">
      <div class="auto-container">
        <div class="sec-title centered">
          <h2>예매한 콘서트<span class="dot">.</span></h2>
        </div>
        <a-list
          item-layout="vertical"
          size="large"
          :pagination="pagination"
          :data-source="getMyConcertTicket"
        >
          <a-list-item slot="renderItem" key="item.title" slot-scope="item">
            <img
              slot="extra"
              width="272"
              height="380"
              alt="logo"
              class="poster"
              :src="`https://i5d102.p.ssafy.io/posterImg/${item.concert.poster.originName}`"
            />
            <a-list-item-meta>
              <div slot="title">{{ item.concert.title }}</div>
              <a-avatar
                slot="avatar"
                :src="`https://i5d102.p.ssafy.io/profileImg/${item.user.userId}.png`"
              />
            </a-list-item-meta>
            <div class="row">
              <div class="col-8">
                {{ item.concert.description }}
                <div class="mt-5">
                  <button
                    @click="concertEnter(item.concert)"
                    style="padding: 2px 20px"
                  >
                    콘서트 입장
                  </button>
                </div>
              </div>
              <div class="col-4">
                <div>
                  <a-icon type="star-o" style="margin-right: 8px" />
                  좌석 : {{ item.type }}
                </div>
                <div>
                  <a-icon type="star-o" style="margin-right: 8px" />
                  티켓 : {{ item.code }}
                </div>
                <div>
                  <a-icon type="star-o" style="margin-right: 8px" />
                  가격 : {{ item.price }} 원
                </div>
                <div>
                  <a-icon type="star-o" style="margin-right: 8px" />
                  날짜 : {{ item.concert.startTime.split(" ")[0] }}
                </div>
                <div>
                  <a-icon type="star-o" style="margin-right: 8px" />
                  시간 : {{ item.concert.startTime.split(" ")[1] }} ~
                  {{ item.concert.endTime.split(" ")[1] }}
                </div>
                <div>
                  <a-icon type="star-o" style="margin-right: 8px" />
                  카테고리 : {{ item.concert.category.name }}
                </div>
                <div>
                  <a-icon type="star-o" style="margin-right: 8px" />
                  상태 : {{ getConcertState(item.concert) }}
                </div>
              </div>
            </div>
          </a-list-item>
        </a-list>
      </div>
    </section>
  </div>
</template>

<script>
import VueSimpleAlert from "vue-simple-alert";
import { mapGetters, mapActions } from "vuex";

export default {
  name: "Myconcert",

  data() {
    return {
      pagination: {
        pageSize: 3,
      },
    };
  },

  created() {
    window.scrollTo(0, 0);
    this.requestUserInfo();
  },

  computed: {
    ...mapGetters("user", ["getUserInfo"]),
    ...mapGetters("ticket", ["getMyConcertTicket"]),
  },

  methods: {
    ...mapActions("user", ["requestUserInfo"]),
    ...mapActions("ticket", ["findMyTicket"]),
    ...mapActions("room", ["setEnterConcert"]),
    concertEnter(concert) {
      if (concert.isActive == 1 || concert.isActive == 2) {
        VueSimpleAlert.confirm("콘서트에 입장하시겠습니까?")
          .then(() => {
            this.setEnterConcert(concert);
            this.$router.push("/waiting");
          })
          .catch((err) => {
            if (err) console.log(err);
          });
      } else if (concert.isActive == 3) {
        this.$alert("종료된 콘서트입니다.", "", "warning");
      } else {
        this.$alert("콘서트 시작 1시간 전부터 입장 가능합니다.", "", "warning");
      }
    },
    getConcertState(concert) {
      if (concert.isActive == 0) {
        return "대기";
      } else if (concert.isActive == 1) {
        return "준비";
      } else if (concert.isActive == 2) {
        return "공연 중";
      } else {
        return "종료";
      }
    },
  },
};
</script>

<style scoped>
.poster {
  width: 272px !important;
  height: 381px !important;
}
.col-8 {
  padding-right: 30px;
}
</style>

<style>
.ant-list-item-meta-title {
  font-size: 30px !important;
}
.ant-avatar-image {
  width: 50px !important;
  height: 50px !important;
}
.ant-list {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  color: rgba(0, 0, 0, 0.65);
  font-size: 14px;
  font-variant: tabular-nums;
  line-height: 1.5;
  list-style: none;
  font-feature-settings: "tnum";
  position: relative;
}
.ant-list * {
  outline: none;
}
.ant-list-pagination {
  margin-top: 24px;
  text-align: right;
}
.ant-list-pagination .ant-pagination-options {
  text-align: left;
}
.ant-list-more {
  margin-top: 12px;
  text-align: center;
}
.ant-list-more button {
  padding-right: 32px;
  padding-left: 32px;
}
.ant-list-spin {
  min-height: 40px;
  text-align: center;
}
.ant-list-empty-text {
  padding: 16px;
  color: rgba(0, 0, 0, 0.25);
  font-size: 14px;
  text-align: center;
}
.ant-list-items {
  margin: 0;
  padding: 0;
  list-style: none;
}
.ant-list-item {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 12px 0;
}
.ant-list-item-content {
  color: rgba(0, 0, 0, 0.65);
}
.ant-list-item-meta {
  display: flex;
  flex: 1;
  align-items: flex-start;
  font-size: 0;
}
.ant-list-item-meta-avatar {
  margin-right: 16px;
}
.ant-list-item-meta-content {
  flex: 1 0;
}
.ant-list-item-meta-title {
  margin-bottom: 4px;
  color: rgba(0, 0, 0, 0.65);
  font-size: 14px;
  line-height: 22px;
}
.ant-list-item-meta-title > a {
  color: rgba(0, 0, 0, 0.65);
  transition: all 0.3s;
}
.ant-list-item-meta-title > a:hover {
  color: #1890ff;
}
.ant-list-item-meta-description {
  color: rgba(0, 0, 0, 0.45);
  font-size: 14px;
  line-height: 22px;
}
.ant-list-item-action {
  flex: 0 0 auto;
  margin-left: 48px;
  padding: 0;
  font-size: 0;
  list-style: none;
}
.ant-list-item-action > li {
  position: relative;
  display: inline-block;
  padding: 0 8px;
  color: rgba(0, 0, 0, 0.45);
  font-size: 14px;
  line-height: 22px;
  text-align: center;
  cursor: pointer;
}
.ant-list-item-action > li:first-child {
  padding-left: 0;
}
.ant-list-item-action-split {
  position: absolute;
  top: 50%;
  right: 0;
  width: 1px;
  height: 14px;
  margin-top: -7px;
  background-color: #e8e8e8;
}
.ant-list-header {
  background: transparent;
}
.ant-list-footer {
  background: transparent;
}
.ant-list-header,
.ant-list-footer {
  padding-top: 12px;
  padding-bottom: 12px;
}
.ant-list-empty {
  padding: 16px 0;
  color: rgba(0, 0, 0, 0.45);
  font-size: 12px;
  text-align: center;
}
.ant-list-split .ant-list-item {
  border-bottom: 1px solid #e8e8e8;
}
.ant-list-split .ant-list-item:last-child {
  border-bottom: none;
}
.ant-list-split .ant-list-header {
  border-bottom: 1px solid #e8e8e8;
}
.ant-list-loading .ant-list-spin-nested-loading {
  min-height: 32px;
}
.ant-list-something-after-last-item
  .ant-spin-container
  > .ant-list-items
  > .ant-list-item:last-child {
  border-bottom: 1px solid #e8e8e8;
}
.ant-list-lg .ant-list-item {
  padding-top: 16px;
  padding-bottom: 16px;
}
.ant-list-sm .ant-list-item {
  padding-top: 8px;
  padding-bottom: 8px;
}
.ant-list-vertical .ant-list-item {
  align-items: initial;
}
.ant-list-vertical .ant-list-item-main {
  display: block;
  width: 900px !important;
  flex: 1;
}
.ant-list-vertical .ant-list-item-extra {
  margin-left: 40px;
}
.ant-list-vertical .ant-list-item-meta {
  margin-bottom: 16px;
}
.ant-list-vertical .ant-list-item-meta-title {
  margin-bottom: 12px;
  color: rgba(0, 0, 0, 0.85);
  font-size: 16px;
  line-height: 24px;
}
.ant-list-vertical .ant-list-item-action {
  margin-top: 16px;
  margin-left: auto;
}
.ant-list-vertical .ant-list-item-action > li {
  padding: 0 16px;
}
.ant-list-vertical .ant-list-item-action > li:first-child {
  padding-left: 0;
}
.ant-list-grid .ant-col > .ant-list-item {
  display: block;
  max-width: 100%;
  margin-bottom: 16px;
  padding-top: 0;
  padding-bottom: 0;
  border-bottom: none;
}
.ant-list-item-no-flex {
  display: block;
}
.ant-list:not(.ant-list-vertical) .ant-list-item-no-flex .ant-list-item-action {
  float: right;
}
.ant-list-bordered {
  border: 1px solid #d9d9d9;
  border-radius: 4px;
}
.ant-list-bordered .ant-list-header {
  padding-right: 24px;
  padding-left: 24px;
}
.ant-list-bordered .ant-list-footer {
  padding-right: 24px;
  padding-left: 24px;
}
.ant-list-bordered .ant-list-item {
  padding-right: 24px;
  padding-left: 24px;
  border-bottom: 1px solid #e8e8e8;
}
.ant-list-bordered .ant-list-pagination {
  margin: 16px 24px;
}
.ant-list-bordered.ant-list-sm .ant-list-item {
  padding-right: 16px;
  padding-left: 16px;
}
.ant-list-bordered.ant-list-sm .ant-list-header,
.ant-list-bordered.ant-list-sm .ant-list-footer {
  padding: 8px 16px;
}
.ant-list-bordered.ant-list-lg .ant-list-header,
.ant-list-bordered.ant-list-lg .ant-list-footer {
  padding: 16px 24px;
}
@media screen and (max-width: 768px) {
  .ant-list-item-action {
    margin-left: 24px;
  }
  .ant-list-vertical .ant-list-item-extra {
    margin-left: 24px;
  }
}
@media screen and (max-width: 576px) {
  .ant-list-item {
    flex-wrap: wrap;
  }
  .ant-list-item-action {
    margin-left: 12px;
  }
  .ant-list-vertical .ant-list-item {
    flex-wrap: wrap-reverse;
  }
  .ant-list-vertical .ant-list-item-main {
    min-width: 220px;
  }
  .ant-list-vertical .ant-list-item-extra {
    margin: auto auto 16px;
  }
}

/* stylelint-disable at-rule-empty-line-before,at-rule-name-space-after,at-rule-no-unknown */
/* stylelint-disable no-duplicate-selectors */
/* stylelint-disable */
/* stylelint-disable declaration-bang-space-before,no-duplicate-selectors,string-no-newline */
.ant-spin {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  color: rgba(0, 0, 0, 0.65);
  font-size: 14px;
  font-variant: tabular-nums;
  line-height: 1.5;
  list-style: none;
  font-feature-settings: "tnum";
  position: absolute;
  display: none;
  color: #1890ff;
  text-align: center;
  vertical-align: middle;
  opacity: 0;
  transition: transform 0.3s cubic-bezier(0.78, 0.14, 0.15, 0.86);
}
.ant-spin-spinning {
  position: static;
  display: inline-block;
  opacity: 1;
}
.ant-spin-nested-loading {
  position: relative;
}
.ant-spin-nested-loading > div > .ant-spin {
  position: absolute;
  top: 0;
  left: 0;
  z-index: 4;
  display: block;
  width: 100%;
  height: 100%;
  max-height: 400px;
}
.ant-spin-nested-loading > div > .ant-spin .ant-spin-dot {
  position: absolute;
  top: 50%;
  left: 50%;
  margin: -10px;
}
.ant-spin-nested-loading > div > .ant-spin .ant-spin-text {
  position: absolute;
  top: 50%;
  width: 100%;
  padding-top: 5px;
  text-shadow: 0 1px 2px #fff;
}
.ant-spin-nested-loading > div > .ant-spin.ant-spin-show-text .ant-spin-dot {
  margin-top: -20px;
}
.ant-spin-nested-loading > div > .ant-spin-sm .ant-spin-dot {
  margin: -7px;
}
.ant-spin-nested-loading > div > .ant-spin-sm .ant-spin-text {
  padding-top: 2px;
}
.ant-spin-nested-loading > div > .ant-spin-sm.ant-spin-show-text .ant-spin-dot {
  margin-top: -17px;
}
.ant-spin-nested-loading > div > .ant-spin-lg .ant-spin-dot {
  margin: -16px;
}
.ant-spin-nested-loading > div > .ant-spin-lg .ant-spin-text {
  padding-top: 11px;
}
.ant-spin-nested-loading > div > .ant-spin-lg.ant-spin-show-text .ant-spin-dot {
  margin-top: -26px;
}
.ant-spin-container {
  position: relative;
  transition: opacity 0.3s;
}
.ant-spin-container::after {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  z-index: 10;
  display: none \9;
  width: 100%;
  height: 100%;
  background: #fff;
  opacity: 0;
  transition: all 0.3s;
  content: "";
  pointer-events: none;
}
.ant-spin-blur {
  clear: both;
  overflow: hidden;
  opacity: 0.5;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  pointer-events: none;
}
.ant-spin-blur::after {
  opacity: 0.4;
  pointer-events: auto;
}
.ant-spin-tip {
  color: rgba(0, 0, 0, 0.45);
}
.ant-spin-dot {
  position: relative;
  display: inline-block;
  font-size: 20px;
  width: 1em;
  height: 1em;
}
.ant-spin-dot-item {
  position: absolute;
  display: block;
  width: 9px;
  height: 9px;
  background-color: #1890ff;
  border-radius: 100%;
  transform: scale(0.75);
  transform-origin: 50% 50%;
  opacity: 0.3;
  -webkit-animation: antSpinMove 1s infinite linear alternate;
  animation: antSpinMove 1s infinite linear alternate;
}
.ant-spin-dot-item:nth-child(1) {
  top: 0;
  left: 0;
}
.ant-spin-dot-item:nth-child(2) {
  top: 0;
  right: 0;
  -webkit-animation-delay: 0.4s;
  animation-delay: 0.4s;
}
.ant-spin-dot-item:nth-child(3) {
  right: 0;
  bottom: 0;
  -webkit-animation-delay: 0.8s;
  animation-delay: 0.8s;
}
.ant-spin-dot-item:nth-child(4) {
  bottom: 0;
  left: 0;
  -webkit-animation-delay: 1.2s;
  animation-delay: 1.2s;
}
.ant-spin-dot-spin {
  transform: rotate(45deg);
  -webkit-animation: antRotate 1.2s infinite linear;
  animation: antRotate 1.2s infinite linear;
}
.ant-spin-sm .ant-spin-dot {
  font-size: 14px;
}
.ant-spin-sm .ant-spin-dot i {
  width: 6px;
  height: 6px;
}
.ant-spin-lg .ant-spin-dot {
  font-size: 32px;
}
.ant-spin-lg .ant-spin-dot i {
  width: 14px;
  height: 14px;
}
.ant-spin.ant-spin-show-text .ant-spin-text {
  display: block;
}
@media all and (-ms-high-contrast: none), (-ms-high-contrast: active) {
  /* IE10+ */
  .ant-spin-blur {
    background: #fff;
    opacity: 0.5;
  }
}
@-webkit-keyframes antSpinMove {
  to {
    opacity: 1;
  }
}
@keyframes antSpinMove {
  to {
    opacity: 1;
  }
}
@-webkit-keyframes antRotate {
  to {
    transform: rotate(405deg);
  }
}
@keyframes antRotate {
  to {
    transform: rotate(405deg);
  }
}

/* stylelint-disable at-rule-empty-line-before,at-rule-name-space-after,at-rule-no-unknown */
/* stylelint-disable no-duplicate-selectors */
/* stylelint-disable */
/* stylelint-disable declaration-bang-space-before,no-duplicate-selectors,string-no-newline */
.ant-pagination {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  color: rgba(0, 0, 0, 0.65);
  font-size: 14px;
  font-variant: tabular-nums;
  line-height: 1.5;
  list-style: none;
  font-feature-settings: "tnum";
}
.ant-pagination ul,
.ant-pagination ol {
  margin: 0;
  padding: 0;
  list-style: none;
}
.ant-pagination::after {
  display: block;
  clear: both;
  height: 0;
  overflow: hidden;
  visibility: hidden;
  content: " ";
}
.ant-pagination-total-text {
  display: inline-block;
  height: 32px;
  margin-right: 8px;
  line-height: 30px;
  vertical-align: middle;
}
.ant-pagination-item {
  display: inline-block;
  min-width: 32px;
  height: 32px;
  margin-right: 8px;
  font-family: Arial;
  line-height: 30px;
  text-align: center;
  vertical-align: middle;
  list-style: none;
  background-color: #fff;
  border: 1px solid #d9d9d9;
  border-radius: 4px;
  outline: 0;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}
.ant-pagination-item a {
  display: block;
  padding: 0 6px;
  color: rgba(0, 0, 0, 0.65);
  transition: none;
}
.ant-pagination-item a:hover {
  text-decoration: none;
}
.ant-pagination-item:focus,
.ant-pagination-item:hover {
  border-color: #1890ff;
  transition: all 0.3s;
}
.ant-pagination-item:focus a,
.ant-pagination-item:hover a {
  color: #1890ff;
}
.ant-pagination-item-active {
  font-weight: 500;
  background: #fff;
  border-color: #1890ff;
}
.ant-pagination-item-active a {
  color: #1890ff;
}
.ant-pagination-item-active:focus,
.ant-pagination-item-active:hover {
  border-color: #40a9ff;
}
.ant-pagination-item-active:focus a,
.ant-pagination-item-active:hover a {
  color: #40a9ff;
}
.ant-pagination-jump-prev,
.ant-pagination-jump-next {
  outline: 0;
}
.ant-pagination-jump-prev .ant-pagination-item-container,
.ant-pagination-jump-next .ant-pagination-item-container {
  position: relative;
}
.ant-pagination-jump-prev
  .ant-pagination-item-container
  .ant-pagination-item-link-icon,
.ant-pagination-jump-next
  .ant-pagination-item-container
  .ant-pagination-item-link-icon {
  display: inline-block;
  font-size: 12px;
  font-size: 12px \9;
  transform: scale(1) rotate(0deg);
  color: #1890ff;
  letter-spacing: -1px;
  opacity: 0;
  transition: all 0.2s;
}
:root
  .ant-pagination-jump-prev
  .ant-pagination-item-container
  .ant-pagination-item-link-icon,
:root
  .ant-pagination-jump-next
  .ant-pagination-item-container
  .ant-pagination-item-link-icon {
  font-size: 12px;
}
.ant-pagination-jump-prev
  .ant-pagination-item-container
  .ant-pagination-item-link-icon-svg,
.ant-pagination-jump-next
  .ant-pagination-item-container
  .ant-pagination-item-link-icon-svg {
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  margin: auto;
}
.ant-pagination-jump-prev
  .ant-pagination-item-container
  .ant-pagination-item-ellipsis,
.ant-pagination-jump-next
  .ant-pagination-item-container
  .ant-pagination-item-ellipsis {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  display: block;
  margin: auto;
  color: rgba(0, 0, 0, 0.25);
  letter-spacing: 2px;
  text-align: center;
  text-indent: 0.13em;
  opacity: 1;
  transition: all 0.2s;
}
.ant-pagination-jump-prev:focus .ant-pagination-item-link-icon,
.ant-pagination-jump-next:focus .ant-pagination-item-link-icon,
.ant-pagination-jump-prev:hover .ant-pagination-item-link-icon,
.ant-pagination-jump-next:hover .ant-pagination-item-link-icon {
  opacity: 1;
}
.ant-pagination-jump-prev:focus .ant-pagination-item-ellipsis,
.ant-pagination-jump-next:focus .ant-pagination-item-ellipsis,
.ant-pagination-jump-prev:hover .ant-pagination-item-ellipsis,
.ant-pagination-jump-next:hover .ant-pagination-item-ellipsis {
  opacity: 0;
}
.ant-pagination-prev,
.ant-pagination-jump-prev,
.ant-pagination-jump-next {
  margin-right: 8px;
}
.ant-pagination-prev,
.ant-pagination-next,
.ant-pagination-jump-prev,
.ant-pagination-jump-next {
  display: inline-block;
  min-width: 32px;
  height: 32px;
  color: rgba(0, 0, 0, 0.65);
  font-family: Arial;
  line-height: 32px;
  text-align: center;
  vertical-align: middle;
  list-style: none;
  border-radius: 4px;
  cursor: pointer;
  transition: all 0.3s;
}
.ant-pagination-prev,
.ant-pagination-next {
  outline: 0;
}
.ant-pagination-prev a,
.ant-pagination-next a {
  color: rgba(0, 0, 0, 0.65);
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}
.ant-pagination-prev:hover a,
.ant-pagination-next:hover a {
  border-color: #40a9ff;
}
.ant-pagination-prev .ant-pagination-item-link,
.ant-pagination-next .ant-pagination-item-link {
  display: block;
  height: 100%;
  font-size: 12px;
  text-align: center;
  background-color: #fff;
  border: 1px solid #d9d9d9;
  border-radius: 4px;
  outline: none;
  transition: all 0.3s;
}
.ant-pagination-prev:focus .ant-pagination-item-link,
.ant-pagination-next:focus .ant-pagination-item-link,
.ant-pagination-prev:hover .ant-pagination-item-link,
.ant-pagination-next:hover .ant-pagination-item-link {
  color: #1890ff;
  border-color: #1890ff;
}
.ant-pagination-disabled,
.ant-pagination-disabled:hover,
.ant-pagination-disabled:focus {
  cursor: not-allowed;
}
.ant-pagination-disabled a,
.ant-pagination-disabled:hover a,
.ant-pagination-disabled:focus a,
.ant-pagination-disabled .ant-pagination-item-link,
.ant-pagination-disabled:hover .ant-pagination-item-link,
.ant-pagination-disabled:focus .ant-pagination-item-link {
  color: rgba(0, 0, 0, 0.25);
  border-color: #d9d9d9;
  cursor: not-allowed;
}
.ant-pagination-slash {
  margin: 0 10px 0 5px;
}
.ant-pagination-options {
  display: inline-block;
  margin-left: 16px;
  vertical-align: middle;
}
.ant-pagination-options-size-changer.ant-select {
  display: inline-block;
  width: auto;
  margin-right: 8px;
}
.ant-pagination-options-quick-jumper {
  display: inline-block;
  height: 32px;
  line-height: 32px;
  vertical-align: top;
}
.ant-pagination-options-quick-jumper input {
  position: relative;
  display: inline-block;
  width: 100%;
  height: 32px;
  padding: 4px 11px;
  color: rgba(0, 0, 0, 0.65);
  font-size: 14px;
  line-height: 1.5;
  background-color: #fff;
  background-image: none;
  border: 1px solid #d9d9d9;
  border-radius: 4px;
  transition: all 0.3s;
  width: 50px;
  margin: 0 8px;
}
.ant-pagination-options-quick-jumper input::-moz-placeholder {
  color: #bfbfbf;
  opacity: 1;
}
.ant-pagination-options-quick-jumper input:-ms-input-placeholder {
  color: #bfbfbf;
}
.ant-pagination-options-quick-jumper input::-webkit-input-placeholder {
  color: #bfbfbf;
}
.ant-pagination-options-quick-jumper input:-moz-placeholder-shown {
  text-overflow: ellipsis;
}
.ant-pagination-options-quick-jumper input:-ms-input-placeholder {
  text-overflow: ellipsis;
}
.ant-pagination-options-quick-jumper input:placeholder-shown {
  text-overflow: ellipsis;
}
.ant-pagination-options-quick-jumper input:hover {
  border-color: #40a9ff;
  border-right-width: 1px !important;
}
.ant-pagination-options-quick-jumper input:focus {
  border-color: #40a9ff;
  border-right-width: 1px !important;
  outline: 0;
  box-shadow: 0 0 0 2px rgba(24, 144, 255, 0.2);
}
.ant-pagination-options-quick-jumper input-disabled {
  color: rgba(0, 0, 0, 0.25);
  background-color: #f5f5f5;
  cursor: not-allowed;
  opacity: 1;
}
.ant-pagination-options-quick-jumper input-disabled:hover {
  border-color: #d9d9d9;
  border-right-width: 1px !important;
}
.ant-pagination-options-quick-jumper input[disabled] {
  color: rgba(0, 0, 0, 0.25);
  background-color: #f5f5f5;
  cursor: not-allowed;
  opacity: 1;
}
.ant-pagination-options-quick-jumper input[disabled]:hover {
  border-color: #d9d9d9;
  border-right-width: 1px !important;
}
textarea.ant-pagination-options-quick-jumper input {
  max-width: 100%;
  height: auto;
  min-height: 32px;
  line-height: 1.5;
  vertical-align: bottom;
  transition: all 0.3s, height 0s;
}
.ant-pagination-options-quick-jumper input-lg {
  height: 40px;
  padding: 6px 11px;
  font-size: 16px;
}
.ant-pagination-options-quick-jumper input-sm {
  height: 24px;
  padding: 1px 7px;
}
.ant-pagination-simple .ant-pagination-prev,
.ant-pagination-simple .ant-pagination-next {
  height: 24px;
  line-height: 24px;
  vertical-align: top;
}
.ant-pagination-simple .ant-pagination-prev .ant-pagination-item-link,
.ant-pagination-simple .ant-pagination-next .ant-pagination-item-link {
  height: 24px;
  border: 0;
}
.ant-pagination-simple .ant-pagination-prev .ant-pagination-item-link::after,
.ant-pagination-simple .ant-pagination-next .ant-pagination-item-link::after {
  height: 24px;
  line-height: 24px;
}
.ant-pagination-simple .ant-pagination-simple-pager {
  display: inline-block;
  height: 24px;
  margin-right: 8px;
}
.ant-pagination-simple .ant-pagination-simple-pager input {
  box-sizing: border-box;
  height: 100%;
  margin-right: 8px;
  padding: 0 6px;
  text-align: center;
  background-color: #fff;
  border: 1px solid #d9d9d9;
  border-radius: 4px;
  outline: none;
  transition: border-color 0.3s;
}
.ant-pagination-simple .ant-pagination-simple-pager input:hover {
  border-color: #1890ff;
}
.ant-pagination.mini .ant-pagination-total-text,
.ant-pagination.mini .ant-pagination-simple-pager {
  height: 24px;
  line-height: 24px;
}
.ant-pagination.mini .ant-pagination-item {
  min-width: 24px;
  height: 24px;
  margin: 0;
  line-height: 22px;
}
.ant-pagination.mini .ant-pagination-item:not(.ant-pagination-item-active) {
  background: transparent;
  border-color: transparent;
}
.ant-pagination.mini .ant-pagination-prev,
.ant-pagination.mini .ant-pagination-next {
  min-width: 24px;
  height: 24px;
  margin: 0;
  line-height: 24px;
}
.ant-pagination.mini .ant-pagination-prev .ant-pagination-item-link,
.ant-pagination.mini .ant-pagination-next .ant-pagination-item-link {
  background: transparent;
  border-color: transparent;
}
.ant-pagination.mini .ant-pagination-prev .ant-pagination-item-link::after,
.ant-pagination.mini .ant-pagination-next .ant-pagination-item-link::after {
  height: 24px;
  line-height: 24px;
}
.ant-pagination.mini .ant-pagination-jump-prev,
.ant-pagination.mini .ant-pagination-jump-next {
  height: 24px;
  margin-right: 0;
  line-height: 24px;
}
.ant-pagination.mini .ant-pagination-options {
  margin-left: 2px;
}
.ant-pagination.mini .ant-pagination-options-quick-jumper {
  height: 24px;
  line-height: 24px;
}
.ant-pagination.mini .ant-pagination-options-quick-jumper input {
  height: 24px;
  padding: 1px 7px;
  width: 44px;
}
.ant-pagination.ant-pagination-disabled {
  cursor: not-allowed;
}
.ant-pagination.ant-pagination-disabled .ant-pagination-item {
  background: #f5f5f5;
  border-color: #d9d9d9;
  cursor: not-allowed;
}
.ant-pagination.ant-pagination-disabled .ant-pagination-item a {
  color: rgba(0, 0, 0, 0.25);
  background: transparent;
  border: none;
  cursor: not-allowed;
}
.ant-pagination.ant-pagination-disabled .ant-pagination-item-active {
  background: #dbdbdb;
  border-color: transparent;
}
.ant-pagination.ant-pagination-disabled .ant-pagination-item-active a {
  color: #fff;
}
.ant-pagination.ant-pagination-disabled .ant-pagination-item-link,
.ant-pagination.ant-pagination-disabled .ant-pagination-item-link:hover,
.ant-pagination.ant-pagination-disabled .ant-pagination-item-link:focus {
  color: rgba(0, 0, 0, 0.45);
  background: #f5f5f5;
  border-color: #d9d9d9;
  cursor: not-allowed;
}
.ant-pagination.ant-pagination-disabled
  .ant-pagination-jump-prev:focus
  .ant-pagination-item-link-icon,
.ant-pagination.ant-pagination-disabled
  .ant-pagination-jump-next:focus
  .ant-pagination-item-link-icon,
.ant-pagination.ant-pagination-disabled
  .ant-pagination-jump-prev:hover
  .ant-pagination-item-link-icon,
.ant-pagination.ant-pagination-disabled
  .ant-pagination-jump-next:hover
  .ant-pagination-item-link-icon {
  opacity: 0;
}
.ant-pagination.ant-pagination-disabled
  .ant-pagination-jump-prev:focus
  .ant-pagination-item-ellipsis,
.ant-pagination.ant-pagination-disabled
  .ant-pagination-jump-next:focus
  .ant-pagination-item-ellipsis,
.ant-pagination.ant-pagination-disabled
  .ant-pagination-jump-prev:hover
  .ant-pagination-item-ellipsis,
.ant-pagination.ant-pagination-disabled
  .ant-pagination-jump-next:hover
  .ant-pagination-item-ellipsis {
  opacity: 1;
}
@media only screen and (max-width: 992px) {
  .ant-pagination-item-after-jump-prev,
  .ant-pagination-item-before-jump-next {
    display: none;
  }
}
@media only screen and (max-width: 576px) {
  .ant-pagination-options {
    display: none;
  }
}
.ant-avatar {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  color: rgba(0, 0, 0, 0.65);
  font-size: 14px;
  font-variant: tabular-nums;
  line-height: 1.5;
  list-style: none;
  font-feature-settings: "tnum";
  position: relative;
  display: inline-block;
  overflow: hidden;
  color: #fff;
  white-space: nowrap;
  text-align: center;
  vertical-align: middle;
  background: #ccc;
  width: 32px;
  height: 32px;
  line-height: 32px;
  border-radius: 50%;
}
.ant-avatar-image {
  background: transparent;
}
.ant-avatar-string {
  position: absolute;
  left: 50%;
  transform-origin: 0 center;
}
.ant-avatar.ant-avatar-icon {
  font-size: 18px;
}
.ant-avatar-lg {
  width: 40px;
  height: 40px;
  line-height: 40px;
  border-radius: 50%;
}
.ant-avatar-lg-string {
  position: absolute;
  left: 50%;
  transform-origin: 0 center;
}
.ant-avatar-lg.ant-avatar-icon {
  font-size: 24px;
}
.ant-avatar-sm {
  width: 24px;
  height: 24px;
  line-height: 24px;
  border-radius: 50%;
}
.ant-avatar-sm-string {
  position: absolute;
  left: 50%;
  transform-origin: 0 center;
}
.ant-avatar-sm.ant-avatar-icon {
  font-size: 14px;
}
.ant-avatar-square {
  border-radius: 4px;
}
.ant-avatar > img {
  display: block;
  width: 100%;
  height: 100%;
  -o-object-fit: cover;
  object-fit: cover;
}
</style>
