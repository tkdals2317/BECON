package com.ssafy.api.controller.api.v1;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.ssafy.api.dto.ChatMessage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ChatController {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic channelTopic;
    
    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
    	String name = message.getSender();
    	// 로그인 회원 정보로 대화명 설정
        // 채팅방 입장시에는 대화명과 메시지를 자동으로 세팅한다.
        if (ChatMessage.MessageType.ENTER.equals(message.getType())) {
            message.setSender("[알림]");
            message.setMessage(name + "님이 입장하셨습니다.");
        }
        // Websocket에 발행된 메시지를 redis로 발행(publish)
        redisTemplate.convertAndSend(channelTopic.getTopic(), message);
    }
}
