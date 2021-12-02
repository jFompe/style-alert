import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import { loadComponent } from './utils/dynamic-loader'
import 'bootstrap/dist/css/bootstrap.min.css'
import '@/assets/css/main.css'



Vue.config.productionTip = false

const Spinner = loadComponent('Spinner')

Vue.component(Spinner)

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
