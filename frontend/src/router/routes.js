import { loadView } from '../utils/dynamic-loader'

const Home = loadView('Home')
const Consultas = loadView('Consultas')
const LogIn = loadView('LogIn')
const SignUp = loadView('SignUp')
const ForgotPassword = loadView('ForgotPassword')

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
  },
  {
    path: '/log/login',
    name: 'logIn',
    component: LogIn
  },
  {
    path: '/log/signup',
    name: 'signup',
    component: SignUp
  },
  {
    path: '/log/forgotpassword',
    name: 'ForgotPassword',
    component: ForgotPassword
  }
]