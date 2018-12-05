package ru.kpfu.itis.example.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfiguration {

    @Bean
    public Queue myQueue1() {
        return new Queue("queue-example-2");
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct-exchange-example-1");
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(myQueue1()).to(new DirectExchange("exchange-example-1")).with("example");
//        return BindingBuilder.bind(myQueue1()).to(new DirectExchange("exchange-example-1")).withQueueName();
    }
}