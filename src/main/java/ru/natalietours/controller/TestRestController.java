package ru.natalietours.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.natalietours.domain.TestEntity;
import ru.natalietours.service.TestService;

@RestController
public class TestRestController {

    private static final Logger log = LoggerFactory.getLogger(TestRestController.class);

    @Autowired
    TestService testService;

    @RequestMapping("/blank")
    public String blankStub() {
        return "blank";
    }

    @RequestMapping("/blank/{param1}/read")
    @ResponseBody
    public String blankStub(@PathVariable("param1") String param1) {
        log.warn("test warn");
        TestEntity testEntity = testService.getSomething();
        testEntity.setName(param1);
        return "testEntity = " + testEntity;
    }
}
