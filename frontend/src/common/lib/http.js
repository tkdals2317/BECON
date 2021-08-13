import axios from 'axios';

export default axios.create({
    // baseURL:'http://localhost:8080',
    baseURL:'https://i5d102.p.ssafy.io:8443',
    headers:{
        'Content-type':'application/json'
    },
});