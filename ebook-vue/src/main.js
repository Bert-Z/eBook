// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import VueRouter from 'vue-router';
import App from './App'
import router from './router'
import iView from 'iview'  //引入ivew库
import BootstrapVue from 'bootstrap-vue'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'iview/dist/styles/iview.css'  // 使用 CSS

Vue.use(BootstrapVue)
Vue.use(VueRouter);
Vue.use(iView);

// The routing configuration
const RouterConfig = {
  routes: router
};
Vue.config.productionTip = false

new Vue({
  el: '#app',
  router: router,
  render: h => h(App)
});
