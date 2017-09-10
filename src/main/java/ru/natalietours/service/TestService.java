package ru.natalietours.service;

import eu.hinsch.spring.boot.actuator.metric.ExecutionMetric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Service;
import ru.natalietours.domain.TestEntity;

@Service
public class TestService {

    private static final Logger log = LoggerFactory.getLogger(TestService.class);

    @ExecutionMetric(value = "app.TestService.sendSomething", loglevel = LogLevel.DEBUG)
    public TestEntity getSomething() {
        log.debug("sendSomething");
        TestEntity test = new TestEntity();
        test.setName("Test Name");
        return test;
    }
}
