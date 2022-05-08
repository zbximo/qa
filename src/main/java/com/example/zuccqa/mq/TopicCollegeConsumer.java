package com.example.zuccqa.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @author pengbin
 * @version 1.0
 */
@RabbitListener(queues = "#{topicCollegeStatQue.name}")
public class TopicCollegeConsumer {
    private final Logger logger = LoggerFactory.getLogger(TopicCollegeConsumer.class);
    private String name = "TopicCollegeConsumer";

    @RabbitHandler
    public void handleMsg(ZuccEchoMessage msg){
        logger.warn("[{}]got [{}]", this.name, msg.stringfy());
        logger.warn("[{}]TopicCollegeConsumer do statistics by college .", this.name);
    }
}
