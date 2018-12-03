package ru.kpfu.itis.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SampleController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public String sendMessageToQueue(@RequestParam(name = "message") String message) {
        log.info("Send message to queue");
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("queue-example-2", message + " " + i);
        }
        return "Message has been send";
    }

}