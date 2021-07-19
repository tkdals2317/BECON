// API : dispatch
import $axios from 'axios'

export function requestLogin ({ state }, payload) {
  console.log('requestLogin', state, payload)
  const url = '/api/v1/auth/login'
  let body = payload
  return $axios.post(url, body)
}

export function requestRegister ({ state }, payload) {
  console.log('requestRegist', state, payload)
  const url = '/api/v1/users/regist'
  let body = payload
  return $axios.post(url, body)
}

export function requestDuplicate ({ state }, payload) {
  console.log('requestDuplicate', state, payload)
  const url = '/api/v1/users/'+payload
  return $axios.get(url)
}

export function requestSearch ({ state }) {
  console.log('requestSearch', state)
  const url = '/api/v1/users/me'
  return $axios.get(url)
}

export function requestModify ({ state }, payload) {
  console.log('requestModify', state, payload)
  const url = '/api/v1/users/'+payload.id
  let body = payload.body
  return $axios.patch(url, body)
}

export function requestDelete ({ state }, payload) {
  console.log('requestDelete', state)
  const url = '/api/v1/users/'+ payload.id
  return $axios.delete(url)
}
