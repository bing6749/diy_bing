<template>
  <el-form
    ref="AccountFrom"
    :model="account"
    :rules="rules"
    label-position="left"
    label-width="0px"
    class="demo-ruleFrom login-container"
  >
    <h3 class="h3_title">资讯管理后台登录</h3>
    <el-form-item prop="userName">
      <el-input
        type="text"
        v-model="account.userName"
        auto-complete="off"
        placeholder="用户名"
      ></el-input>
    </el-form-item>
    <el-form-item prop="userPassword">
      <el-input
        type="password"
        v-model="account.userPassword"
        auto-complete="off"
        placeholder="密码"
      ></el-input>
    </el-form-item>
    <el-checkbox checked class="remember">记住密码</el-checkbox>
    <el-form-item style="margin-top:10px;">
      <el-button style="margin-left:30px;" type="primary" @click="handleLogin" :loading="logining"
        >登录</el-button
      >
      <el-button type="primary" style="margin-left:130px;">
        <router-link to="/">返回</router-link>
      </el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  data() {
    //表单校验,默认的用户名，密码
    return {
      logining: false,
      account: {
        userName: "",
        userPassword: "",
      },
      /*判断：如果用户没有输入用户名，提示“请输入账号”
      判断：如果用户没有输入密码，提示“请输入密码”用于表单验证*/
      rules: {
        userName: [
          {
            required: true,
            message: "请输入账号",
            trigger: "blur",
          },
        ],
        userPassword: [
          {
            required: true,
            message: "请输入密码",
            trigger: "blur",
          },
        ],
      },
      checked: true,
    };
  },
  methods: {
    tokenLogin(){
      // 如果前端有token
      if(this.$cookies.get('token')){
        console.log(this.$cookies.get('token'));
        this.axios.post("/user/login").then((res) => {
          if(res.flag){
            this.$router.push({path:'/backedView',params: {token: res.data}})
          }
        });
      }
    },
    async handleLogin() {
      // }else{
        
        await this.axios.post("/user/login", this.account).then((res) => {
          // console.log(res);
          if (res.flag) {
            if(res.data){
              console.log(res.data);
              this.$cookies.set("token",res.data)
            this.$router.push({path:'/panelView',params: {token: res.data}})
            // location.href = "/panelView/"
            }
          }else{
            this.$message.error(res.message);
          }
        });
      // }
      
    },
  },
  created(){
  this.tokenLogin();
  },
};
</script>

<style scoped>
body {
  background: aquamarine;
}
.login-container {
  width: 350px;
  height: 500px;
  margin-left: 20%;
  margin: 50px auto;
}
.h3_title{
  color: #435077;
  text-align: center;
}
</style>
