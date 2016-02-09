package com.slaffka.scheduler;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by slaffka85 on 08.02.2016.
 */
@Component//"#{T(scheduler.fixedRate : 5000})"
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    public static final ExpressionParser parser = new SpelExpressionParser();


    @Scheduled(fixedDelayString = "${scheduler.fixedRate:5000}")
    public void reportCurrentTime() {

        //parser.parseExpression("#{new Long('5000')}").getValue(Long.class);
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }
}
