// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.

import Vue from 'vue'
import VueRouter from 'vue-router';

// mdb vue component
import 'bootstrap-css-only/css/bootstrap.min.css';
import 'mdbvue/build/css/mdb.css';
import iView from 'iview'  //引入ivew库
import BootstrapVue from 'bootstrap-vue'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'iview/dist/styles/iview.css'  // 使用 CSS

import App from './App'
import VueResource from 'vue-resource'
import router from './router'


Vue.use(VueResource);
Vue.use(BootstrapVue);
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
