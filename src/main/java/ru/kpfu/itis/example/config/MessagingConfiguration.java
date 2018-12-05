package ru.kpfu.itis.example.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfiguration {

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout-exchange-example");
    }

    @Bean
    public Queue logQueue1() {
        return new Queue("log-queue-example-1");
    }

    @Bean
    public Queue logQueue2() {
        return new Queue("log-queue-example-2");
    }

    @Bean
    public Binding bindingLogQueue1() {
        return BindingBuilder.bind(logQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingLogQueue2() {
        return BindingBuilder.bind(logQueue2()).to(fanoutExchange());
    }
}