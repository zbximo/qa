package com.example.zuccqa.controller;

import com.example.zuccqa.service.FeedbackService;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: ximo
 * @date: 2022/4/23 13:25
 * @description:
 */
public class DateTimeJob implements Job {
    @Autowired
    private FeedbackService feedbackService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        System.out.println((String) jobDataMap.get("fbId"));
        feedbackService.postTips((String) jobDataMap.get("fbId"));
    }
}
