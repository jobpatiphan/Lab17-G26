package com.websocket.demo.config;

import com.websocket.demo.chat.ChatMessage;
import com.websocket.demo.chat.MessageType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
public class WebSocketEventListener {
    private final SimpMessageSendingOperations messageSendingOperations;

//    @EventListener
//    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
//            ChatMessage.addCount();
//            var chatMessage = ChatMessage.builder()
//                    .type(MessageType.LEAVE)
//                    .sender("")
//                    .getCount(ChatMessage.count)
//                    .build();
//        messageSendingOperations.convertAndSend("/topic/public", chatMessage);
//    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        ChatMessage.mintCount();
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if (username != null) {
            var chatMessage = ChatMessage.builder()
                    .type(MessageType.LEAVE)
                    .sender(username)
                    .getcount(ChatMessage.count)
                    .build();
            messageSendingOperations.convertAndSend("/topic/public", chatMessage);

        }


    }
}
