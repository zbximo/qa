package com.example.zuccqa.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @author pengbin
 * @version 1.0
 */
@RabbitListener(queues = "#{directFatalQue.name}")
public class DirectFatalConsumer {
    private final Logger logger = LoggerFactory.getLogger(DirectFatalConsumer.class);
    private String name = "DirectFatalConsumer";

    @RabbitHandler
    public void handleMsg(ZuccEchoMessage msg){
        logger.warn("[{}]got [{}]", this.name, msg.stringfy());
        logger.warn("[{}]DirectFatalConsumer handle fatal .", this.name);
    }
}
