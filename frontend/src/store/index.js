import Vue from 'vue'
import Vuex from 'vuex'

import general from './modules/general.store'
import consultas from './modules/consultas.store'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    general,
    consultas,
  }
})

export default store
