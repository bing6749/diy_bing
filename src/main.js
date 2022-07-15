import Vue from 'vue'
import App from './App.vue'
import store from './store'
import router from './router'
import './plugins/element.js'
import axios from './utils/request'
import * as echarts from 'echarts'
import VueCookies from 'vue-cookie'
import  mavonEditor  from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'

Vue.use(mavonEditor)
axios.defaults.withCredentials=true;
Vue.prototype.$cookies = VueCookies;
Vue.component('v-chart', echarts)
Vue.prototype.$echarts = echarts
Vue.config.productionTip = false
Vue.prototype.axios = axios
new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')


