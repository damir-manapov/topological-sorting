package ru.damirmanapov.configuration;

import eu.hinsch.spring.boot.actuator.metric.ExecutionMetricFactory;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricConfiguration {

    @Bean
    public ExecutionMetricFactory executionMetricFactory(CounterService gaugeService, GaugeService counterService) {
        return new ExecutionMetricFactory(gaugeService, counterService);
    }

}
