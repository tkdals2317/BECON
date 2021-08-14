import Stomp from "webstomp-client";
import SockJS from "sockjs-client";

const URL = "i5d102.p.ssafy.io:8443";
// const URL = "localhost:8080";

function stomp() {
    let socket = new SockJS(`https://${URL}/ws-stomp`);
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