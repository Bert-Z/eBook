// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import "../src/common/bower_components/sidebar-nav.min.css"
import "../src/common/css/animate.css"
import "../src/common/css/style.css"
import "../src/common/css/colors/megna-dark.css"

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})
