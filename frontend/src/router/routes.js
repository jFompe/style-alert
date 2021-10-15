import { loadView } from '../utils/dynamic-loader'

const Home = loadView('Home')
const Consultas = loadView('Consultas')


export default [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/consultas',
    name: 'consultas',
    component: Consultas
  }
]