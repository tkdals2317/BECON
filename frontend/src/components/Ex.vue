<template>
    <html>
<head>
<meta charset="utf-8">
<link rel="styleSheet" href="style.css" type="text/css" media="screen">
</head>
<body>
	<div id="container">
		<div id="wrapper">
			<div id="join" class="animate join">
				<h1>Join a Room</h1>
				<!-- <form onsubmit="register(); return false;" accept-charset="UTF-8"> -->
					<p>
						<input type="text" name="name" value="" id="name"
							placeholder="Username" required>
					</p>
					<p>
						<input type="text" name="room" value="" id="roomName"
							placeholder="Room" required>
					</p>
					<p class="submit">
						<input type="button" name="commit" value="Join!" @click="register()">
					</p>
				<!-- </form> -->
			</div>
			<div id="room" style="display: none;">
				<h2 id="room-header"></h2>
				<div id="participants"></div>
				<input type="button" id="button-leave" onmouseup="leaveRoom();"
					value="Leave room">
			</div>
		</div>
	</div>
</body>
</html>

</template>
<script>
import Participant from "../common/lib/participant"; 
import kurentoUtils from "kurento-utils";

export default {    
    data:function(){
        return{
            ws:null,
            name:'',
            participants:[],
        }
    },
    created(){
        this.connect();
        console.log(this.ws);
    },
    methods:{
        connect(){
            this.ws=new WebSocket('ws://localhost:8080/groupcall');
            this.ws.onmessage = function(message) {
                var parsedMessage = JSON.parse(message.data);
                console.info('Received message: ' + message.data);

                switch (parsedMessage.id) {
                case 'existingParticipants':
                    this.onExistingParticipants(parsedMessage);
                    break;
                case 'newParticipantArrived':
                    this.onNewParticipant(parsedMessage);
                    break;
                case 'participantLeft':
                    this.onParticipantLeft(parsedMessage);
                    break;
                case 'receiveVideoAnswer':
                    this.receiveVideoResponse(parsedMessage);
                    break;
                case 'iceCandidate':
                    this.participants[parsedMessage.name].rtcPeer.addIceCandidate(parsedMessage.candidate, function (error) {
                        if (error) {
                            console.error("Error adding candidate: " + error);
                            return;
                        }
                    });
                    break;
                default:
                    console.error('Unrecognized message', parsedMessage);
                }
            }
        },
        register() {
            console.log("regist")
            var name = document.getElementById('name').value;
            var room = document.getElementById('roomName').value;

            document.getElementById('room-header').innerText = 'ROOM ' + room;
            document.getElementById('join').style.display = 'none';
            document.getElementById('room').style.display = 'block';

            var message = {
                id : 'joinRoom',
                name : name,
                room : room,
            }
            this.sendMessage(message);
        },
        onNewParticipant(request) {
            this.receiveVideo(request.name);
        },
        receiveVideoResponse(result) {
            this.participants[result.name].rtcPeer.processAnswer (result.sdpAnswer, function (error) {
                if (error) return console.error (error);
            });
        },
        callResponse(message) {
            if (message.response != 'accepted') {
                console.info('Call not accepted by peer. Closing call');
                stop();
            } else {
                this.webRtcPeer.processAnswer(message.sdpAnswer, function (error) {
                    if (error) return console.error (error);
                });
            }
        },
        onExistingParticipants(msg) {
            var constraints = {
                audio : true,
                video : {
                    mandatory : {
                        maxWidth : 320,
                        maxFrameRate : 15,
                        minFrameRate : 15
                    }
                }
            };
            console.log(name + " registered in room " + this.room);
            var participant = new Participant(name);
            this.participants[name] = participant;
            var video = participant.getVideoElement();

            var options = {
                localVideo: video,
                mediaConstraints: constraints,
                onicecandidate: participant.onIceCandidate.bind(participant)
                }
            participant.rtcPeer = new kurentoUtils.WebRtcPeer.WebRtcPeerSendonly(options,
                function (error) {
                if(error) {
                    return console.error(error);
                }
                this.generateOffer (participant.offerToReceiveVideo.bind(participant));
            });

            msg.data.forEach(this.receiveVideo);
        },
        leaveRoom() {
            this.sendMessage({
                id : 'leaveRoom'
            });

            for ( var key in this.participants) {
                this.participants[key].dispose();
            }
            document.getElementById('join').style.display = 'block';
            document.getElementById('room').style.display = 'none';
            this.socket.close();
        },
        receiveVideo(sender) {
            var participant = new Participant(sender);
            this.participants[sender] = participant;
            var video = participant.getVideoElement();

            var options = {
            remoteVideo: video,
            onicecandidate: participant.onIceCandidate.bind(participant)
            }

            participant.rtcPeer = new kurentoUtils.WebRtcPeer.WebRtcPeerRecvonly(options,
                    function (error) {
                    if(error) {
                        return console.error(error);
                    }
                    this.generateOffer (participant.offerToReceiveVideo.bind(participant));
            });
        },
        onParticipantLeft(request) {
            console.log('Participant ' + request.name + ' left');
            var participant = this.participants[request.name];
            participant.dispose();
            delete this.participants[request.name];
        },
        sendMessage(message) {
            var jsonMessage = JSON.stringify(message);
            console.log('Sending message: ' + jsonMessage);
            this.ws.send(jsonMessage);
        },
    }

};
</script>
 