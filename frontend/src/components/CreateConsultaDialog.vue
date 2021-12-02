<template>
  <v-dialog
    v-model="showCreateConsulta"
    width=500px
  >
    <v-card>
      <v-card-title>{{isEditing ? 'Editar' : 'Crear'}} Consulta</v-card-title>
      <v-card-text>
        <v-text-field
          label="Nombre de la consulta"
          outlined
          v-model="currentConsulta.name"
          @change="updateField('name', $event)"
        ></v-text-field>
        <v-text-field
          label="URL de la consulta"
          outlined
          v-model="currentConsulta.url"
          @change="updateField('url', $event)"
          :rules="[rules.url]"
        ></v-text-field>
      </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn
          @click="closeCreateConsulta()"
        >Cancelar</v-btn>
        <v-btn
          @click="closeCreateConsulta(true)"
        >Aceptar</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  name: 'CreateConsultaDialog',

  data: () => ({
    rules: {
      url: value => {
        const pattern = /((https?:\/\/|^)(?:www\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|www\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9]+\.[^\s]{2,}|www\.[a-zA-Z0-9]+\.[^\s]{2,})/
        return pattern.test(value)
      }
    }
  }),
  created() {

  },
  mounted() {

  },
  computed: {
    showCreateConsulta: {
      set() {
        this.$store.dispatch('HIDE_SHOW_CREATE_CONSULTA', { 
          doShow: false, isEditing: null 
        })
      },
      get() {
        return this.$store.getters.getShowCreateConsulta
      }
    },
    isEditing() {
      return this.$store.getters.getIsEditingConsulta
    },
    currentConsulta() {
      return this.$store.getters.getCurrentConsulta
    },
  },
  methods: {
    async closeCreateConsulta(save = false) {
      this.showCreateConsulta = false
      if (!save) return

      await this.$store.dispatch('SAVE_CONSULTA', this.getCurrentConsulta)
    },
    updateField(key, value) {
      this.$store.dispatch('UPDATE_CURRENT_CONSULTA', { key, value })
    },
  }
}
</script>