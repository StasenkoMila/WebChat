package chat;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;

@WebSocket
public class ChatWebSocket  {
    private Session session;

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
    }

    @OnWebSocketConnect
    public void onOpen(Session session) {
        this.session = session;
    }

    @OnWebSocketMessage
    public void onMessage(String message) {
        try {
            session.getRemote().sendString(message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
