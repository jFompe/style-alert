export const loadComponent = function loadComponent(componentName) {
  return require(`../components/${componentName}.vue`).default
  // return require(`../components/${componentName}/${componentName}.vue`).default
}

export const loadView = function loadView(viewName) {
  return require(`../views/${viewName}.vue`).default
  // return require(`../views/${viewName}/${viewName}.vue`).default
}
