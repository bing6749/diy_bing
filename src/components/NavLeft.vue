<template>
  <div class="navLeft">
    <el-row class="tac">
      <el-col :span="3">
        <el-menu
          default-active="1-4-1"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          :collapse="false"
        >
          <router-link to="/panelView">
            <el-menu-item index="2">
              <i class="el-icon-menu"></i>
              <span slot="title"> 仪 表 盘</span>
            </el-menu-item>
          </router-link>
          <router-link to="/articleManagement">
            <el-menu-item index="3">
              <i class="el-icon-document"></i>
              <span slot="title">文章管理</span>
            </el-menu-item>
          </router-link>
          <el-menu-item index="4">
            <i class="el-icon-setting"></i>
            <span slot="title">标签管理</span>
          </el-menu-item>
          <el-menu-item index="4" disabled>
            <i class="el-icon-document"></i>
            <span slot="title">系统配置</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-row>

  </div>
</template>

<script>
export default {};
</script>

<style scoped>
/* .tac .el-row{
  all: initial;
} */
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 125px;
  min-height: 900px;
}
.navLeft{
  display: block;
  float: left;
}
</style>