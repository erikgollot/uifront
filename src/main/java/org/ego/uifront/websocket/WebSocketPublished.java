package org.ego.uifront.websocket;

import org.ego.message.DeployMessage;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Session;


@Component
public class WebSocketPublished {

    @Autowired
    private SimpMessagingTemplate template;

    @JmsListener(destination = "admin.deploy", containerFactory = "jmsFactory")
    public void receiveTopicMessage(@Payload DeployMessage deployMessage,
                                    @Headers MessageHeaders headers,
                                    Message message, Session session) {
        System.out.println("Received "+deployMessage.getMessage());
        receiveMessage(deployMessage);
    }

    public void receiveMessage(DeployMessage message) {

        template.convertAndSend("/topic/messages", message);
    }
}
