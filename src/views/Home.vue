<template>
  <hello-world />
</template>

<script>
  import HelloWorld from '../components/HelloWorld'

  export default {
    name: 'Home',

    components: {
      HelloWorld,
    },

    created() {
      // Ir directamente a la pantalla de consultas
      this.$router.push('consultas')
    }
  }
</script>
