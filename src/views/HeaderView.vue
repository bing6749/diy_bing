<template>
  <nav class="navbar fixed-top navbar-expand-lg nav-header-wrapper">
    <div class="container">
      <!-- <button
        class="navbar-toggler custom-navbar-toggler"
        type="button"
        data-bs-toggle="offcanvas"
        data-bs-target="#offcanvasNavbar"
        aria-controls="offcanvasNavbar"
      >
        <img
          src="../assets/logo.jpg"
          alt="menus" width="20%" height="20%" 
        /></button> -->
      <a class="navbar-brand m-0 logo-container" href="/"
        ><img
          class="logo"
          src="../assets/logo.jpg"
          alt="logo"
          width="240px"
          height="77px"
        />
      </a>

      <ul class="d-none d-lg-flex navbar-nav ms-lg-5 me-auto mb-2 mb-lg-0">
        <li class="nav-item home-nav-item">
          <a class="nav-link active" href="/" title="首页">首页</a>
        </li>
        <li class="nav-item home-nav-item">
          <router-link to="/CPURank" class="nav-link" title="CPU天梯图">
          CPU天梯图
          </router-link>
        </li>
        <li class="nav-item home-nav-item">
          <router-link to="/GPURank" class="nav-link" title="显卡天梯图">
          显卡天梯图
          </router-link>
        </li>
        <li class="nav-item home-nav-item">
          <router-link class="nav-link" to="/tampermonkey/" title="油猴脚本"
            >油猴脚本</router-link
          >
        </li>
        <li class="nav-item home-nav-item" @click="aleart()">
          <router-link class="nav-link" to="/" title="装机推荐"
            >装机推荐</router-link
          >
        </li>
      </ul>
      <!-- <div class="d-flex header-search-user">
        <div class="search-input" id="searchBody">
          <div class="search-button" id="showSearchIcon">
            <i class="iconfont icon-search"></i>
          </div>
          <div class="search-input-wrapper">
            <input placeholder="输入关键词搜索" name="search" /><i
              class="iconfont icon-qingchu clear-icon"
            ></i
            ><i class="iconfont icon-search search-icon"></i>
          </div>
        </div>
      </div> -->
      <router-link to="/login">
        <div class="avatar" ><el-avatar :size="40" src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"></el-avatar></div>
      </router-link> 
    </div>
  </nav>
</template>

<script>
// import axios from 'axios';

export default {
  methods: {
    aleart(){
      this.aleart("功能暂待开发...")
    }
    // login(){
    //   if(this.user == null){
    //     axios.get()
    //   }
    // }
  },
  data(){
    return {
      user:[],
    }
  },
};
</script>

<style>
.logo-container {
  padding-left: 50px;
}
.fixed-top {
  position: fixed;
  top: 0;
  right: 0;
  left: 0;
  z-index: 1030;
}
.nav-header-wrapper {
  height: 90px;
  box-shadow: 0 3px 6px 0 rgb(0 0 0 / 6%);
  font-size: 16px;
  font-family: PingFangSC-Regular, PingFang SC;
  background: #fff;
  transition: top 0.2s;
  z-index: 1050;
  text-align: center;
}
.container {
  height: 90px;
  display: flex;
  flex-wrap: inherit;
  align-items: center;
  justify-content: space-between;
  margin-right: auto;
  margin-left: auto;
  text-align: center;
  cursor:default;
}
.m-0 {
  margin: 0;
}
.logo {
  width: "240px";
  height: "77px";
}
ul {
  display: block;
  list-style-type: disc;
  margin-block-start: 1em;
  margin-block-end: 1em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
  padding-inline-start: 40px;
  list-style: none;
  margin-left: 50px;
}
li {
  display: inline;
  line-height: 40px;
  display: inline-block;
  font-size: 22px;
  font-family: PingFangSC-Regular, PingFang SC;
  font-weight: 400;
  color: #585677;
  line-height: 1.5;
  padding: 8px 15px;
}
.navbar-nav {
  padding-left: 0;
  list-style: none;
  flex-direction: row;
}
/* .nav-link:visited{
  color: #f66d6d;
} */
.me-auto {
  margin-right: auto !important;
}
.nav-header-wrapper .nav-link.active::before {
  position: absolute;
  bottom: -5px;
  left: 50%;
  width: 64px;
  height: 12px;
  content: "";
  transform: translateX(-50%) scale(0.25);
  border-radius: 6px;
  background: var(--theme-color);
}
/* .nav-link {
    display: block;
    padding: .5rem 1rem;
    text-decoration: none;
    transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out;
} */
a:hover {
  color: #f66d6d;
}
.avatar{
  margin: 0 70px 0 30px!important;
  text-align: center;
}
</style>