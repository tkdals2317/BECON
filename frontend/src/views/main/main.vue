<template>
  <!-- <el-container class="main-wrapper">
    <main-header
      :height="`70px`"
      @openRegisterDialog="onOpenRegisterDialog"
      @openLoginDialog="onOpenLoginDialog"
      @openProfileDialog="onOpenProfileDialog"/>
    <el-container class="main-container">
      <el-aside class="hide-on-small" width="240px">
        <main-sidebar
          :width="`240px`"/>
      </el-aside>
      <el-main> -->
        <router-view></router-view>
      <!-- </el-main>
    </el-container>
    <main-footer :height="`110px`"/>
  </el-container>
  <login-dialog
    :open="loginDialogOpen"
    @closeLoginDialog="onCloseLoginDialog"/>
  <register-dialog
    :open="registerDialogOpen"
    @closeRegisterDialog="onCloseRegisterDialog"/>
  <profile-dialog
    :open="profileDialogOpen"
    @closeProfileDialog="onCloseProfileDialog"/> -->
</template>
<style>
  @import 'https://fonts.googleapis.com/css2?family=Teko:wght@300;400;500;600;700&display=swap';
  @import 'https://unpkg.com/element-plus/lib/theme-chalk/index.css';
  @import './main.css';
  @import '../../common/css/common.css';
  @import '../../common/css/element-plus.css';
  @import '../../common/css/animate.css';
  @import '../../common/css/bootstrap.css';
  @import '../../common/css/custom-animate.css';
  @import '../../common/css/flaticon.css';
  @import '../../common/css/fontawesome-all.css';
  @import '../../common/css/hover.css';
  @import '../../common/css/responsive.css';
  @import '../../common/css/rtl.css';
  @import '../../common/css/style.css';
  @import '../../common/css/colors/color-default.css';
  @import '../../common/plugins/glightbox/glightbox.min.css';
</style>
