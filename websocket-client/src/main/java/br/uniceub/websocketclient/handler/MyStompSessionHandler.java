package br.uniceub.websocketclient.handler;

import br.uniceub.websocketclient.dto.HelloMessage;
import br.uniceub.websocketclient.dto.MessageInfo;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

public class MyStompSessionHandler extends StompSessionHandlerAdapter {

    private Logger logger = LogManager.getLogger(MyStompSessionHandler.class);

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        logger.info("New session established : " + session.getSessionId());
        session.subscribe("/topic/messages", this);
        logger.info("Subscribed to /topic/messages");
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                session.send("/app/chat", getSampleMessage());
                try {
                    Thread.sleep(Double.valueOf(Math.random() * 2000).longValue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("Got an exception", exception);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return MessageInfo.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        MessageInfo msg = (MessageInfo) payload;
        msg.setId(headers.getMessageId());
        logger.info("Received : " + msg);
    }

    private HelloMessage getSampleMessage() {
        HelloMessage msg = new HelloMessage();
        msg.setFrom("Nicky");
        msg.setText(RandomStringUtils.randomAlphanumeric(10));
        return msg;
    }
}
