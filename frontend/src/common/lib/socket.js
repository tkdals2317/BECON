import Stomp from "webstomp-client";
import SockJS from "sockjs-client";

const URL = "localhost:8080";
// const URL = "3.36.67.58:8080";

function stomp() {
    let socket = new SockJS(`http://${URL}/ws-stomp`);
    let stomp = new Stomp.over(socket);
    return stomp;
}

function webSocket() {
    let socket = new WebSocket(`wss://${URL}/groupcall`);
    return socket;
}

export {
    stomp,
    webSocket,
}