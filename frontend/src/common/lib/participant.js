/* eslint-disable no-unused-vars */
/* eslint-disable no-undef */
/*
 * (C) Copyright 2014 Kurento (http://kurento.org/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

/**
 * Creates a video element for a new participant
 *
 * @param {String} name - the name of the new participant, to be used as tag
 *                        name of the video element.
 *                        The tag of the new element will be 'video<name>'
 * @return
 */

function Participant(name, sendMessage, concert) {
	this.name = name;
	var container = document.createElement('div');
	container.id = name;
	
	if (document.getElementById('participants')) {
		var rtcPeer;
	}
	if (document.getElementById('participants-img')) {
		container.classList.add('image', 'col');
		var img = document.createElement('img');
		img.setAttribute('src',  `https://i5d102.p.ssafy.io/profileImg/${name}.png`);
		img.style.borderRadius = '50%';
		img.style.width = '73px';
		img.style.height = '73px';
		container.appendChild(img);
		
		document.getElementById('participants-img').appendChild(container);
	}

	this.getElement = function() {
		return container;
	}

	this.offerToReceiveVideo = function(error, offerSdp, wp){
		if (error) return console.error ("sdp offer error")
		console.log('Invoking SDP offer callback function');
		var msg =  { id : "receiveVideoFrom",
				sender : name,
				sdpOffer : offerSdp
			};
		sendMessage(msg);
	}


	this.onIceCandidate = function (candidate, wp) {
		  var message = {
		    id: 'onIceCandidate',
		    candidate: candidate,
		    name: name
		  };
		  sendMessage(message);
	}

	Object.defineProperty(this, 'rtcPeer', { writable: true});

	this.dispose = function() {
		if (this.rtcPeer) this.rtcPeer.dispose();
		// container.parentNode.removeChild(container);
	};
}

export {
	Participant
}