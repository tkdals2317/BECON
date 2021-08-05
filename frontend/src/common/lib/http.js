import axios from 'axios';

export default axios.create({
    baseURL:'https://3.36.67.58:8443',
    //baseURL:'http://localhost:8080',
    headers:{
        'Content-type':'application/json'
    },
});