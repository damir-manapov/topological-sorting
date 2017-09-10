package ru.natalietours.job;

import eu.hinsch.spring.boot.actuator.metric.ExecutionMetric;
import org.springframework.boot.logging.LogLevel;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Jobs {

    @Scheduled(fixedDelayString = "#{${app.heartbeat} * 1000}")
    @ExecutionMetric(value = "app.heartbeat", loglevel = LogLevel.TRACE)
    public void heartBeat() {
        // Need for periodic updating metric, for knowing whether service still alive
    }

}
