<template>
  <v-app>
    <v-app-bar
      app
      clipped-left
      color="primary"
      dark
    >
      <v-app-bar-nav-icon @click="showDrawer = !showDrawer"></v-app-bar-nav-icon>
      <v-toolbar-title>Style Alert</v-toolbar-title>
    </v-app-bar>

    <v-navigation-drawer
      v-model="showDrawer"
      app
      clipped
    >
      <v-list
        nav
        dense
      >
        <v-list-item
          v-for="option in menuOptions"
          :key="option.name"
          link
          :to="option.route"
        >
          <v-list-item-icon>
            <v-icon>{{ option.icon }}</v-icon>
          </v-list-item-icon>
          <v-list-item-title>{{ option.name }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-main>
      <v-container 
        fluid
      >
        <router-view/>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    showDrawer: false,

    menuOptions: [
      { name: 'Home', icon: 'mdi-home', route: '/' },
      { name: 'Consultas', icon: 'mdi-magnify', route: '/consultas' },
      { name: 'Cuenta', icon: 'mdi-account', route: '/account' }
    ]
  }),

  created() {

  },
  mounted() {

  },
  computed: {

  },
  methods: {

  }
};
</script>
