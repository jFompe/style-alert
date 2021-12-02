<template>
  <v-list-item>
    <v-list-item-avatar>
      <v-img :src="iconUrl"></v-img>
    </v-list-item-avatar>

    <v-list-item-content @click="linkToUrl(consulta.url)">
      <v-list-item-title v-text="consulta.url" />
      <v-list-item-subtitle v-text="consulta.date" />
    </v-list-item-content>

    <v-list-item-action>
      <v-row>
        <v-btn icon @click="showCreateConsulta">
          <v-icon >mdi-pencil</v-icon>
        </v-btn>
        <v-btn icon @click="deleteConsulta(consulta.id)">
          <v-icon>mdi-delete</v-icon>
        </v-btn>
      </v-row>
    </v-list-item-action>
  </v-list-item>
</template>

<script>
export default {
  name: 'Consulta',

  props: {
    consulta: Object,
  },

  data: () => ({

  }),
  created() {

  },
  mounted() {

  },
  computed: {
    iconUrl() {
      let url = this.consulta.url
      const httpPattern = /https?:\/\//
      if (httpPattern.test(this.consulta.url)) {
        url = url.substring(url.indexOf('//') + 2, url.length)
      }
      if (url.split('/').length - 1 > 1) {
        url = url.substring(0, url.indexOf('/'))
      }
      return 'http://' + url + '/favicon.ico'
    }
  },
  methods: {
    linkToUrl(url) {
      window.open('http://' + url, '_blank', null, true)
    },
    showCreateConsulta() {
      this.$store.dispatch('SET_CURRENT_CONSULTA', { ...this.consulta })
      this.$store.dispatch('HIDE_SHOW_CREATE_CONSULTA', { 
        doShow: true, isEditing: true 
      })
    },
    deleteConsulta(id) {
      if (!window.confirm(`Estás seguro de que deseas borrar la consulta:\n${this.consulta.name}`)) 
        return

      this.$store.dispatch('DELETE_CONSULTA', id)
    },
  }
}
</script>