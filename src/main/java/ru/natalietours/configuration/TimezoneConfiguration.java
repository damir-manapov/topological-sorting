package ru.natalietours.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@Configuration
public class TimezoneConfiguration {

    @Value("${app.timezone}")
    String timezone;

    @PostConstruct
    public void timeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone(timezone));
    }

}
