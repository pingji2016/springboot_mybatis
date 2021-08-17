package org.example.springboot.config;

import org.example.springboot.jobs.MyFirstJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail getJobDetial() {
        return JobBuilder.newJob(MyFirstJob.class).storeDurably().build();
    }

    // 创建触发器
    @Bean
    public Trigger trigger01() {
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().repeatForever()
                .withIntervalInSeconds(1)
                .repeatForever();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger01", "group01")
                .withSchedule(simpleScheduleBuilder)
                .forJob(getJobDetial())
                .build();
        return trigger;
    }

    @Bean
    public Trigger trigger02() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ? *");

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger02", "group01")
                .withSchedule(cronScheduleBuilder)
                .forJob(getJobDetial())
                .build();
        return trigger;
    }
}
