import gaxios from 'axios'

const axios = gaxios.create({
  baseURL: BASE_URI,
  timeout: 5000,
})

const IP_ADDRESS = "http://54.173.187.126/"
const BASE_URI = `http://${IP_ADDRESS}/style-alert/api`


export async function MAKE_REQUEST(method, requestEndpoint, payload={}) {
  switch(method) {
    case 'GET':
      return await axios.get(requestEndpoint)
    case 'POST':
      return await axios.post(requestEndpoint, payload)
  }
}