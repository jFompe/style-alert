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
        <v-btn icon>
          <v-icon>mdi-pencil</v-icon>
        </v-btn>
        <v-btn icon>
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
      return 'http://' + this.consulta.url + '/favicon.ico'
    }
  },
  methods: {
    linkToUrl(url) {
      window.open('http://' + url, '_blank', null, true)
    }
  }
}
</script>