package ru.kpfu.itis.example.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class MessageListener {

    private Random random = new Random();

    @RabbitListener(queues = "queue-example-2")
    public void worker1(String message) {
//        throw new IllegalStateException();
        // Will not be redelivered
        throw new ClassCastException();
    }

    @RabbitListener(queues = "queue-example-2")
    public void worker2(String message) throws InterruptedException {
        log.info("Worker #2. Received: {}", message);
        Thread.sleep(100 * random.nextInt(20));
    }
}
