package com.example.zuccqa.mq;

import com.example.zuccqa.entity.Feedback;
import com.example.zuccqa.service.AnswerSheetService;
import com.example.zuccqa.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author pengbin
 * @version 1.0
 */
@Component
@RabbitListener(queues = {Constants.QUE_SIMPLE})
public class SimpleConsumer {
    private final Logger logger = LoggerFactory.getLogger(SimpleConsumer.class);
    @Autowired
    private AnswerSheetService answerSheetService;

    @RabbitHandler
    public void handleMsg(ZuccEchoMessage msg){
        if (msg.getCategory().equals(ZuccEchoMessage.CATEGORY_BLANKSHEET_CREATE)){
            answerSheetService.addBlankAnswerSheets((Feedback) msg.getContent().get("feedback"));
            logger.warn("create blank answerSheets after create a feedback {}", msg.stringfy());
        }
        if (msg.getCategory().equals("TipsAfterUpdateCourse")){
            logger.warn("course info {} to teacher", msg.stringfy());
        }

    }
}
