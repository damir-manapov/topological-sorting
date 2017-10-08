package ru.damirmanapov;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

@org.testng.annotations.Test(groups = "integration")
public class Test {

    @org.testng.annotations.Test
    public void testIs() {
        assertThat(true, is(true));
    }

    @org.testng.annotations.Test
    public void testSamePropertyValuesAs() {

        TestEntity expectedTestEntity = new TestEntity("Test Name");

        TestEntity actualTestEntity = new TestEntity("Test Name");

        assertThat(actualTestEntity, samePropertyValuesAs(expectedTestEntity));
    }

}
