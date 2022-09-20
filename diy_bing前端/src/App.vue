<template>
  <div id="app">
    <!-- <router-link to="/demo">首页</router-link>
    <router-link to="/content">内容页</router-link>
    <router-link to="/bing">冰页</router-link>
    <router-link :to="{name:'proFile', params:{id: 12}}">冰页</router-link> -->
    <!-- <router-link to="/login">登录</router-link> -->
    <el-container>
      <el-header
        style="height: 90px"
        v-if="!(path === '/backedView') &&
          !(this.path === '/panelView') &&
          !(path === '/articleManagement')"
      >
        <HeaderView></HeaderView>
      </el-header>

      <router-view></router-view>
      <!-- <el-main><MainView></MainView></el-main> -->
      <el-footer>
        <FooterView></FooterView>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import FooterView from "./views/FooterView.vue";
import HeaderView from "./views/HeaderView.vue";

export default {
  name: "app",
  data() {
    return {
      path: "/panelView",
      flag:true,
    };
  },
  components: { FooterView, HeaderView },
  created() {
    
  },
  mounted() {
    this.path = this.$route.path;
  },
  watch: {
    // eslint-disable-next-line
    $route(to, from) {
      this.path = to.path;
    },
  },
};
</script>

<style>
/* #app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
} */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.nav-link active:after {
  color: #f66d6d;
}
/* 设置滚动条整体部分的样式 */
::-webkit-scrollbar {
  width: 8px;
  height: 6px;
}

/* 滚动槽--外层轨道 */
::-webkit-scrollbar-track {
  background: transparent;
  opacity: 0;
}

/* 内层轨道（不包含滚动块部分） */
::-webkit-scrollbar-track-piece {
  opacity: 0; /* 透明度设置为全透明，使得滚动条背景色为网页颜色 */
}

/* 滚动条滑块 */
::-webkit-scrollbar-thumb {
  border-radius: 3px;
  background: rgba(92, 110, 130, 0.6);
}

/* 滚动条按钮 */
::-webkit-scrollbar-button {
  display: none;
}

/* 横向滚动条和纵向滚动条相交处尖角的颜色 */
::-webkit-scrollbar-corner {
  background-color: transparent;
}
</style>
