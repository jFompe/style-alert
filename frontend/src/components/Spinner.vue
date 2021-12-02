<template >
  <transition name="fade" mode="out-in">
    <div class="loading" v-if="spinner === true">
      <v-progress-circular indeterminate color="primary"></v-progress-circular>
    </div>
  </transition>
</template>

<script>
export default {
  name: 'Spinner',
  computed: {
    spinner() {
      return this.$store.getters.getLoading
    }
  }
}
</script>

<style lang="scss" scoped>
.loading {
    position: absolute;
    width:100%;
    height:100%;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
    z-index: 99999999;
    background-color: rgba(white, 0.4);
}
.v-progress-circular {
        left: calc(50% - 16px);
        top: calc(50% - 16px);
        position: fixed;
    }
.fade-enter-active, .fade-leave-active {
    transition: opacity .2s
}
.fade-enter, .fade-leave-to {
    opacity: 0
}
</style>
