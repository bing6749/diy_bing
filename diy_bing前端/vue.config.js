const { defineConfig } = require('@vue/cli-service')
// $cookies.config(expireTimes)
module.exports = defineConfig({
  transpileDependencies: true
})


module.exports = {
  devServer: {
    open: true,
    host: 'localhost',
    port: 8080,
    https: false,
    //以上的ip和端口是我们本机的;下面为需要跨域的
    proxy: { //配置跨域
      '/tiantitu': {
        target: 'https://pdlib.pconline.com.cn/product/intf/tiantitu/', //这里后台的地址模拟的;应该填写你们真实的后台接口
        ws: true,
        changOrigin: true, //允许跨域
        pathRewrite: {
          '^/tiantitu': '' //请求的时候使用这个api就可以
        }
      },
        '/api': {
          target: 'http://127.0.0.1:9090/', //112.124.54.146这里后台的地址模拟的;应该填写你们真实的后台接口
          ws: true,
          changOrigin: true, //允许跨域
          pathRewrite: {
              '^/api': '' //请求的时候使用这个api就可以
          }
      }
    }
  }
}


