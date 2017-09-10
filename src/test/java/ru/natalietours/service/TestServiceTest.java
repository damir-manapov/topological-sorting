package ru.natalietours.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import ru.natalietours.TestConfig;
import ru.natalietours.domain.TestEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;

@SpringBootTest(classes = TestConfig.class)
@Test(groups = "units")
@ActiveProfiles("units")
public class TestServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    TestService testService;

    @Test
    public void testGetdSomething() {

        TestEntity expectedTestEntity = TestEntity
                .builder()
                .name("Test Name")
                .build();

        TestEntity actualTestEntity = testService.getSomething();

        assertThat(actualTestEntity, samePropertyValuesAs(expectedTestEntity));
    }

}