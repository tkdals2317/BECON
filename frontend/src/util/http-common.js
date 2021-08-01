import axios from 'axios';

export default axios.create({
    baseURL:'http://3.36.67.58:8080',
    headers:{
        'Content-type':'application/json'
    },
});