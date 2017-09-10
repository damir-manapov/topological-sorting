package ru.natalietours.integration;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
@Test(groups = "integration")
public class DymmyIntegrationTest extends AbstractTestNGSpringContextTests {

    @Test
    public void dummy() {
        assertThat(true, is(true));
    }

}
