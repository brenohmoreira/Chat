package com.websocket_java.websocket_java.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private final CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    // Executado assim que a conexão é estabelecida
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);           
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        /*
            Este método é chamado quando uma mensagem de texto é recebida de um cliente.
            Percorre todas as sessões WebSocket na lista e envia a mensagem para cada uma delas.

            Cada sessão tem um id que representa a pessoa. O for abaixo percorre todas as sessões e envia a mensagem para todos.
            Se você desejar, por exemplo, que a mensagem não seja enviada para o usuário que mandou a mensagem, então basta usar a session
            passada como parâmetro neste método. Acontece que, diferente de sessions - que possui todas as sessões -, a session se trata
            da sessão do usuário que está conectado. Assim sendo, utilizando getId(), fica simples não enviar a mensagem para a pessoa x ou y.
         */
        for(WebSocketSession webSocketSession : sessions) {
            webSocketSession.sendMessage(message);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
    }


}
