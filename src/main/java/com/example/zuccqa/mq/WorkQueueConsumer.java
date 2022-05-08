package com.example.zuccqa.mq;

import com.example.zuccqa.form.AnswerSheetDto;
import com.example.zuccqa.service.AnswerSheetService;
import com.example.zuccqa.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author pengbin
 * @version 1.0
 */
@RabbitListener(queues = {Constants.QUE_WORK_QUEUE})
public class WorkQueueConsumer {
    private final Logger logger = LoggerFactory.getLogger(WorkQueueConsumer.class);

    @Autowired
    private AnswerSheetService answerSheetService;
    private String name;

    public WorkQueueConsumer(String name) {
        this.name = name;
    }

    @RabbitHandler
    public void handleMsg(ZuccEchoMessage msg){
        if (msg.getCategory().equals(ZuccEchoMessage.CATEGORY_SHEET_CREATE)){
            answerSheetService.updateAnswerSheet((AnswerSheetDto) msg.getContent().get("answerSheet"));
        }
        if (msg.getCategory().equals(ZuccEchoMessage.POST_TIP)){
            logger.warn("post tips");
        }
        logger.warn("[{}]WorkQueueConsumer got [{}]", this.name, msg.stringfy());
        logger.warn("[{}]WorkQueueConsumer do update status.", this.name);
    }
}
