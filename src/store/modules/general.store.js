


const state = {
  user: null,
}

const getters = {
  getUser: state => state.user,
}

const actions = { 
  async initAppData({ commit }) {
    
  }
}

const mutations = {
  _setUser(state, payload) {
    state.user = payload
  }
}


export default {
  state,
  getters,
  actions,
  mutations,
}