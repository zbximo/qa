package com.example.zuccqa.controller;

import com.example.zuccqa.entity.Feedback;
import com.example.zuccqa.impl.FeedbackServiceImpl;
import org.quartz.CronScheduleBuilder;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.quartz.*;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

import static org.quartz.JobBuilder.newJob;

/**
 * @author: ximo
 * @date: 2022/4/20 14:55
 * @description:
 */
@RestController
@Component
public class DynamicTask {
    private final Logger logger = LoggerFactory.getLogger(DynamicTask.class);
    // 创建ThreadPoolTaskScheduler线程池
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    @Autowired
    private FeedbackServiceImpl feedbackService;
    private ScheduledFuture future;
    public static ConcurrentHashMap<String, ScheduledFuture> map = new ConcurrentHashMap<String, ScheduledFuture>();

    public ScheduledFuture startCron(@RequestParam("id") String feedbackId) {
        threadPoolTaskScheduler.setPoolSize(20);
        future = threadPoolTaskScheduler.schedule(new PostTips(feedbackId),
                new CronTrigger(System.currentTimeMillis() / 1000 % 60 + "/10 * * * * *"));

        assert future != null;
        DynamicTask.map.put(feedbackId, future);
        logger.info("DynamicTask Start feedbackId:{} Time:{} ", feedbackId, new Date(System.currentTimeMillis()));
        return future;
    }

    @RequestMapping(value = "/tese", method = RequestMethod.GET)
    public ScheduledFuture start(@RequestParam("id") String feedbackId) throws SchedulerException {
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        JobDetail jobDetail = newJob(DateTimeJob.class)
                .withIdentity(feedbackId, "group2")
                .withDescription(feedbackId)
                .build();

        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        jobDataMap.put("fbId", feedbackId);

        org.quartz.Trigger trigger = (org.quartz.Trigger) TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule(System.currentTimeMillis() / 1000 % 60 + "/10 * * * * *"))
                .withIdentity(feedbackId, "group2")
                .build();


        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
        return null;
    }

    private class PostTips implements Runnable {
        String fbId;

        public PostTips(String fbId) {
            this.fbId = fbId;
        }

        @Override
        public void run() {
            logger.info("startPostTips**** Time:{} fbId:{}", new Date(System.currentTimeMillis()), this.fbId);
            List<String> courseIdList = feedbackService.postTips(this.fbId);
//
        }
    }

}
