package ru.natalietours;

import eu.hinsch.spring.boot.actuator.metric.ExecutionMetricFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

import static org.mockito.Mockito.mock;

@EnableConfigurationProperties
@SpringBootConfiguration
@Profile("units")
@ComponentScan({"ru.natalietours.service",
        "ru.natalietours.controller"})
@EnableWebMvc
public class TestConfig {

    @Value("${app.timezone}")
    String TIMEZONE;

    @Bean
    public CounterService counterService() {
        return mock(CounterService.class);
    }

    @Bean
    public ExecutionMetricFactory executionMetricFactory() {
        CounterService gaugeService = mock(CounterService.class);
        GaugeService counterService = mock(GaugeService.class);
        return new ExecutionMetricFactory(gaugeService, counterService);
    }

    @Bean
    public RestTemplate restTemplate() {
        return null;
    }

    @PostConstruct
    public void timeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone(TIMEZONE));
    }

}
