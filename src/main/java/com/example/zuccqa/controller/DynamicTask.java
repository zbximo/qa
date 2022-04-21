package com.example.zuccqa.controller;

import com.example.zuccqa.impl.FeedbackServiceImpl;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * @author: ximo
 * @date: 2022/4/20 14:55
 * @description:
 */
@RestController
@Component
public class DynamicTask {
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture<?> future;
    public static ConcurrentHashMap<String, ScheduledFuture> map = new ConcurrentHashMap<String, ScheduledFuture>();
    @Autowired
    private FeedbackServiceImpl feedbackService;

    public ScheduledFuture<?> startCron(String feedbackId) {
        System.out.println(threadPoolTaskScheduler);
        future = threadPoolTaskScheduler.schedule(new PostTips(), new CronTrigger("0/2 * * * * *"));
        DynamicTask.map.put(feedbackId,future);
        System.out.println("DynamicTask.startCron()");
        return future;
    }



    private class PostTips implements Runnable {

        @Override
        public void run() {
            // 获取所有问卷Id，如果问卷已经关闭，则取消定时任务
            List<String> courseIdList = feedbackService.getAllCache();
            DynamicTask.map.forEach(
                    (key,value)->{
                        if (!courseIdList.contains(key)){
                            System.out.println("cancle: "+key);
                            value.cancel(true);
                        }
                    }
            );
        }
    }

}
