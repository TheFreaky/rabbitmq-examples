package ru.kpfu.itis.example.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

    @RabbitListener(queues = "queue-example-1")
    public void processQueue1(String message) {
        log.info("Received: {}", message);
    }

}
