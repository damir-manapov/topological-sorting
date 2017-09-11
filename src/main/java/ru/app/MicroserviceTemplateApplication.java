package ru.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class MicroserviceTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceTemplateApplication.class, args);
    }

}
