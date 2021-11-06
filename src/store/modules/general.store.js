import { MAKE_REQUEST } from '../../requests/requests'
import { REQ_LOGIN } from '../../requests/endpoints'
import { sha256 } from 'js-sha256'

const state = {
  user: null,
  isLoading: false,
}

const getters = {
  getUser: state => state.user,
  getLoading: state => state.isLoading,
}

const actions = { 
  async initAppData({ dispatch }) {
    await Promise.all([
      dispatch('FETCH_USER')
    ])
  },
  FETCH_USER({ commit }, { username, password }) {
    const user = await MAKE_REQUEST('POST', REQ_LOGIN(), {
      user: username,
      pass: sha256(password)
    })
    console.log(user);
    commit('_setUser', user)
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