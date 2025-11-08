package com.kafka_consumidor.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {

    private final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @KafkaListener(topics = {"topic-test-1"}, groupId = "grupo-test-1")
    public void listener(String mensaje){
        LOGGER.info("Mensaje recibido: {}", mensaje);
    }
}
