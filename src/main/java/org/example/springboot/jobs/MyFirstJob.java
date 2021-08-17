package org.example.springboot.jobs;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFirstJob implements Job {

    private Logger log = LoggerFactory.getLogger(MyFirstJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("定时任务");
        log.info("当前时间", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
    }
}
