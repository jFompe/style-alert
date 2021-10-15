<template>
  <div>

    <v-card>
      <v-card-title>
        <span>Mis Consultas</span>
        <v-spacer></v-spacer>
        
        <v-tooltip top>
          <template v-slot:activator="{ on, attrs }">
            <v-btn 
              icon 
              x-large
              v-bind="attrs"
              v-on="on"
            >
              <v-icon>mdi-bell-alert</v-icon>
            </v-btn>
          </template>
          <span>Consultas con cambios</span>
        </v-tooltip>
        <v-tooltip top>
          <template v-slot:activator="{ on, attrs }">
            <v-btn 
              icon 
              x-large
              v-bind="attrs"
              v-on="on"
              @click="showCreateConsulta()"
            >
              <v-icon>mdi-plus-circle</v-icon>
            </v-btn>
          </template>
          <span>Nueva Consulta</span>
        </v-tooltip>
      </v-card-title>
      <v-card-text>
        <v-list>
          <Consulta
            v-for="consulta in consultas"
            :key="consulta.id"
            :consulta="consulta"
          />
        </v-list>
      </v-card-text>
    </v-card>

    <CreateConsultaDialog />
  </div>

</template>

<script>
import Consulta from '../components/Consulta.vue'
import CreateConsultaDialog from '../components/CreateConsultaDialog.vue'
import { ConsultaModel } from '../utils/entities'

export default {
  name: 'Consultas',

  components: {
    Consulta,
    CreateConsultaDialog,
  },

  data: () => ({
    
  }),
  created() {
    
  },
  async mounted() {
    await this.$store.dispatch('FETCH_CONSULTAS')
  },
  computed: {
    consultas() {
      return this.$store.getters.getConsultasByUserId(1)
    } 
  },
  methods: {
    showCreateConsulta() {
      console.log(ConsultaModel);
      this.$store.dispatch('SET_CURRENT_CONSULTA', { ...ConsultaModel })
      this.$store.dispatch('HIDE_SHOW_CREATE_CONSULTA', true)
    }
  }
}
</script>