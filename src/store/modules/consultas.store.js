import { MAKE_REQUEST } from '../../requests/requests'
import { REQ_CONSULTATION } from '../../requests/endpoints'

const state = {
  consultas: [],
  currentConsulta: {},
  showCreateConsulta: false,
}

const getters = {
  getConsultas: state => state.consultas,
  getConsultasByUserId: state => id => state.consultas.filter(c => c.userId == id),
  getCurrentConsulta: state => state.currentConsulta,
  getShowCreateConsulta: state => state.showCreateConsulta,
}

const actions = {
  async FETCH_CONSULTAS({ commit, rootGetters }) {
    const consultas = [
      { id: 1, userId: 1, name: 'Google', url: 'google.com', date: '11/10/2021' },
      { id: 2, userId: 1, name: 'Twitter', url: 'twitter.com', date: '11/09/2021' },
      { id: 3, userId: 1, name: 'Netflix', url: 'netflix.com', date: '11/10/2021' },
      { id: 4, userId: 1, name: 'Google ES', url: 'google.es', date: '11/10/2021' },
      { id: 5, userId: 2, name: 'Reddit', url: 'reddit.com', date: '11/10/2021' },
      { id: 6, userId: 2, name: 'Stackof', url: 'stackoverflow.com', date: '11/10/2021' },
      { id: 7, userId: 2, name: 'Google', url: 'google.com', date: '11/10/2021' },
      { id: 8, userId: 2, name: 'Google', url: 'google.com', date: '11/10/2021' },
      { id: 9, userId: 3, name: 'Google', url: 'google.com', date: '11/10/2021' },
      { id: 10, userId: 3, name: 'Google', url: 'google.com', date: '11/10/2021' },
      { id: 11, userId: 3, name: 'Google', url: 'google.com', date: '11/10/2021' },
      { id: 12, userId: 4, name: 'Google', url: 'google.com', date: '11/10/2021' },
      { id: 13, userId: 5, name: 'Google', url: 'google.com', date: '11/10/2021' },
      { id: 14, userId: 5, name: 'Google', url: 'google.com', date: '11/10/2021' },
      { id: 15, userId: 5, name: 'Google', url: 'google.com', date: '11/10/2021' },
    ]

    // const consultas2 = await MAKE_REQUEST('GET', rootGetters.getUser.getId)

    commit('_setConsultas', consultas)
  },
  SET_CURRENT_CONSULTA({ commit }, current) {
    commit('_setCurrentConsulta', Object.assign({}, current))
  },
  UPDATE_CURRENT_CONSULTA({ commit }, { key, value }) {
    commit('_updateCurrentConsulta', { key, value })
  },
  async SAVE_CONSULTA({ commit, getters }) {
    commit('_addConsulta', getters.getCurrentConsulta)
  },
  HIDE_SHOW_CREATE_CONSULTA({ commit }, doShow) {
    commit('_setShowCreateConsulta', doShow)
  },
}

const mutations = {
  _setConsultas(state, payload = []) {
    state.consultas = payload
  },
  _addConsulta(state, payload = {}) {
    state.consultas.push(payload)
  },
  _setCurrentConsulta(state, payload) {
    state.currentConsulta = payload
  },
  _updateCurrentConsulta(state, payload) {
    state.currentConsulta[payload.key] = payload.value
  },
  _setShowCreateConsulta(state, payload) {
    state.showCreateConsulta = payload
  },
}


export default {
  state,
  getters,
  actions,
  mutations,
}