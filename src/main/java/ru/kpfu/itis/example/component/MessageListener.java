package ru.kpfu.itis.example.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class MessageListener {

    private Random random = new Random();

    @RabbitListener(queues = "log-queue-example-1")
    public void worker1(String message) throws InterruptedException {
        log.info("Worker #1. Received: {}", message);
        Thread.sleep(100 * random.nextInt(20));
    }

    @RabbitListener(queues = "log-queue-example-2")
    public void worker2(String message) throws InterruptedException {
        System.err.println("Worker #2. Received: " + message);
        Thread.sleep(100 * random.nextInt(20));
    }

}
