


const state = {
  user: null,
  isLoading: false,
}

const getters = {
  getUser: state => state.user,
  getLoading: state => state.isLoading,
}

const actions = { 
  async initAppData({ commit }) {
    
  },
  SET_LOADING({ commit }, isLoading) {
    commit('_setLoading', isLoading)
  },
}

const mutations = {
  _setUser(state, payload) {
    state.user = payload
  },
  _setLoading(state, payload) {
    state.isLoading = payload
  }
}


export default {
  state,
  getters,
  actions,
  mutations,
}