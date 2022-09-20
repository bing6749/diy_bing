import Vue from 'vue'
import VueRouter from 'vue-router'
// import ContentView from '../views/ContentView.vue'
// import BingView from '../views/BingView.vue'
// import ProFile from '../views/ProFile.vue'
import LoginView from '../views/LoginView.vue'
import MainView from '../views/MainView.vue'
import CPURankView from "../views/CPURankView.vue"
import GPURankView from "../views/GPURankView.vue"
import TampermonkeyView from "../views/TampermonkeyView.vue"
import ArticlesView from "../views/ArticlesView.vue"
import BackedView from "../views/BackedView.vue"
import PanelVuew from "../views/PanelVuew.vue"
import ArticleManagement from "../views/ArticleManagement.vue"
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: MainView
  },
  {
    path: '/CPURank',
    component: CPURankView
  },
  {
    path: '/GPURank',
    component: GPURankView
  },
  {
    path: '/articles/:id',
    component: ArticlesView
  },
  {
    path: '/tampermonkey',
    component: TampermonkeyView
  },
  {
    path:'/backedView',
    name: 'backedView',
    component: BackedView,
    meta: { requiresAuth: true } // 添加表示需要验证
  },
  {
    path:'/panelView',
    component: PanelVuew,
  },
  {
    path:'/articleManagement',
    component: ArticleManagement,
  },
  {
  //   path: '/content',
  //   component: ContentView,
  //   children: [{
  //     path: '/proFile/:id',
  //     name: 'proFile',
  //     component: ProFile,
  //     props: true
  //   }
  //   ]
  // },{
    path: '/login',
    component: LoginView
  },
  // {
  //   path: "/*",
  //   component: MainView
  // }
]

const router = new VueRouter({
  mode:'history',
  routes
})
// const isLogin = this.$cookies.get('token')
// router.beforeEach((to, from, next) => {
//   if (to.name == 'backedView' ) {
//       next('/login');
      
//   } else {
//       next() // 确保一定要调用 next()
//   }
// })

export default router
