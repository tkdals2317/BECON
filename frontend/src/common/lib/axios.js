
import VueAxios from 'vue-axios'
import axios from 'axios'
// import config from '../config'

// const BASE_URL = '/api/v1'
const BASE_URL = 'http://localhost:8080/api/v1'
const DEFAULT_ACCEPT_TYPE = 'application/json'
const TOKEN_PREFIX = 'Bearer '

axios.defaults.baseURL = BASE_URL
axios.defaults.headers['Content-Type'] = DEFAULT_ACCEPT_TYPE
axios.defaults.Authorization = TOKEN_PREFIX

// Add a request interceptor
axios.interceptors.request.use(function (config) {
  // Do something before request is sent
  // 요청 보내기 전에 제어할 부분
  if (localStorage.getItem('token') != null) {
    config.headers.Authorization = TOKEN_PREFIX + localStorage.getItem('token');
  }
  return config;
}, function (error) {
  // Do something with request error
  // 요청 시 에러 처리
  return Promise.reject(error);
});

// Add a response interceptor
axios.interceptors.response.use(function (response) {
  // Any status code that lie within the range of 2xx cause this function to trigger
  // Do something with response data
  return response;
}, function (error) {
  // Any status codes that falls outside the range of 2xx cause this function to trigger
  // Do something with response error
  return Promise.reject(error);
});

export default { VueAxios, axios }
