package com.example.zuccqa.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @author pengbin
 * @version 1.0
 */
@RabbitListener(queues = "#{fanoutTrackQue.name}")
public class FanoutTrackConsumer {
    private final Logger logger = LoggerFactory.getLogger(FanoutTrackConsumer.class);
    private String name = "Fanout-Tracker";

    @RabbitHandler
    public void handleMsg(ZuccEchoMessage msg){
        logger.warn("[{}]got [{}]", this.name, msg.stringfy());
        logger.warn("[{}]FanoutTrackConsumer do track status.", this.name);
    }
}
