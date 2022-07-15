<template>
  <div class="navTop">
    <el-menu
      :default-active="$route.path"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
    >
    <el-menu-item style='float:right' @click="goback()">退出</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  methods: {
    goback(){
      console.log(this.$cookies.get('token'));
      this.$cookies.set('token','0');
      this.$router.push('/');
    }
  }
}
</script>

<style>
.navTop{
  display:  inline-block;

}
</style>