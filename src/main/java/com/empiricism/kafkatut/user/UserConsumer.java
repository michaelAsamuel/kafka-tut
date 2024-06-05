package com.empiricism.kafkatut.user;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserConsumer.class);

    @KafkaListener(topics ="users", groupId = "ourUsers")
    public void consume(User user){
        LOGGER.info(String.format("JSOM message received: %s", user.toString()));

    }
}
