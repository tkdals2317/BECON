<template>
  <el-row
    class="main-sidebar"
    :gutter="10"
    :style="{ 'width': width }">
    <div class="hide-on-small">
      <el-menu
        :default-active="String(state.activeIndex)"
        active-text-color="#ffd04b"
        class="el-menu-vertical-demo"
        @select="menuSelect">
        <div v-if="!isLogin">
          <el-menu-item>
            <i :class="['ic', state.menuItems[0].icon]"/>
            <span>{{ state.menuItems[0].title }}</span>
          </el-menu-item>
        </div>
        <div v-if="isLogin">
          <el-menu-item v-for="(item, index) in state.menuItems" :key="index" :index="index.toString()">
            <div v-if="item.title === '로그아웃'" @click="clickLogout">
              <i v-if="item.icon" :class="['ic', item.icon]"/>
              <span>{{ item.title }}</span>
            </div>
            <div v-else>
              <i v-if="item.icon" :class="['ic', item.icon]"/>
              <span>{{ item.title }}</span>
            </div>
          </el-menu-item>
        </div>
      </el-menu>
    </div>
  </el-row>
</template>
<style>
.main-sidebar .el-menu {
  margin-top: 0;
  padding-left: 0;
}
.main-sidebar .hide-on-small {
  height: 100%;
}
.main-sidebar .hide-on-small .el-menu {
  height: 100%;
}
.main-sidebar .el-menu .el-menu-item {
  cursor: pointer;
  border-right: none;
}
.main-sidebar .el-menu .el-menu-item .ic {
  margin-right: 5px;
}
</style>
<script>
import { reactive, computed } from 'vue'
import { useStore } from 'vuex'
import { useRouter } from 'vue-router'

export default {
  name: 'main-header',

  data: function () {
    return {
      isLogin : false,
    }
  },

  created() {
    const token = localStorage.getItem('token')
    if(token){
      this.isLogin = true
    }
  },

  mounted(){
    window.addEventListener('set-token', (event)=>{
      if(event.detail.token){
        this.isLogin=true;
      }else if(event.detail.token==null){
        this.isLogin=false;
      }
    });
  },

  props: {
    width: {
      type: String,
      default: '240px'
    }
  },

  setup() {
    const store = useStore()
    const router = useRouter()

    const state = reactive({
      searchValue: null,
      menuItems: computed(() => {
        const MenuItems = store.getters['root/getMenus']
        let keys = Object.keys(MenuItems)
        let menuArray = []
        for (let i = 0; i < keys.length; ++i) {
          let menuObject = {}
          menuObject.icon = MenuItems[keys[i]].icon
          menuObject.title = MenuItems[keys[i]].name
          menuArray.push(menuObject)
        }
        return menuArray
      }),
      activeIndex: computed(() => store.getters['root/getActiveMenuIndex'])
    })

    if (state.activeIndex === -1) {
      state.activeIndex = 0
      store.commit('root/setMenuActive', 0)
    }

    const clickLogout = () => {
      localStorage.removeItem('token')
      window.dispatchEvent(new CustomEvent('set-token',{
        detail:{
          token: localStorage.removeItem("token")
        }
      }));
    }

    const menuSelect = function (param) {
      store.commit('root/setMenuActive', param)
      const MenuItems = store.getters['root/getMenus']
      let keys = Object.keys(MenuItems)
      router.push({
        name: keys[param]
      })
    }

    return { state, clickLogout, menuSelect }
  }
}
</script>
