package com.websocket.demo.chat;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class ChatMessage {
    private String content;
    private String timestamp;
    private String sender;
    private MessageType type;
    public static int count = 0;
    private int getcount;
    public static void addCount(){
        count++;
    }
    public static void mintCount(){
        count--;
    }






   
}
