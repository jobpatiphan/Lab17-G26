package com.websocket.demo.chat;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChatMessage {
    private String content;
    private String timestamp;
    private String sender;
    private MessageType type;
    public static Integer count = 0;
    private  Integer online = count;
    public static void addCount(){
        count++;
    }
    public static void mintCount(){
        count--;
    }






   
}
