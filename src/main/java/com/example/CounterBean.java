package com.example;

import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.ScheduledExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class CounterBean {
    Logger logger = LoggerFactory.getLogger("counterLogger");
    private AtomicInteger counter = new AtomicInteger();

    public int get() {
        return counter.get();
    }

    @Scheduled(cron = "{cron.expr}")
    void increment() {
        counter.incrementAndGet();
        if (counter.get() % 10 == 0) {
            logger.debug("Incremented to " + counter);
        }
    }
}
