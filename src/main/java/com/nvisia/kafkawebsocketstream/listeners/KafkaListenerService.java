package com.nvisia.kafkawebsocketstream.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class KafkaListenerService {

//    @Value("${websocket.topic.pageviews}")
//    public String pageviewsTopic;

    private static final Logger logger = Logger.getLogger( KafkaListenerService.class.getName() );

    @Autowired
    SimpMessagingTemplate template;

    @KafkaListener(topics="pageviews")
    public void receivePageViews(@Payload String message) {
        logger.info("Received message: " + message);
        template.convertAndSend("/topics/pageviews", message);
    }

}
