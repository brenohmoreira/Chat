package com.websocket_java.websocket_java.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("[afterConnectionEstablished] session id " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("[handleTextMessage] message " + message.getPayload());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("[afterConnectionClosed] session id " + session.getId());
    }
}
