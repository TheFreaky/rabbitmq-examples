package ru.kpfu.itis.example.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfiguration {

    @Bean
    public Queue myQueue1() {
        return new Queue("queue-example-1");
    }
}