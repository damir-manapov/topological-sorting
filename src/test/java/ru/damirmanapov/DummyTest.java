package ru.damirmanapov;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

@Test
public class DummyTest {

    private static final Logger logger = LoggerFactory.getLogger(DummyTest.class);

    public static <T> List<T> asList(T... elements) {
        ArrayList<T> result = new ArrayList<>(elements.length);
        for (T val : elements) {
            result.add(val);
        }
        return result;
    }

    @Test
    public void testIs() {
        logger.info("Test message");
        assertThat(true, is(true));
    }

    @Test
    public void testSamePropertyValuesAs() {

        TestEntity expectedTestEntity = new TestEntity("DummyTest Name");

        TestEntity actualTestEntity = new TestEntity("DummyTest Name");

        assertThat(actualTestEntity, samePropertyValuesAs(expectedTestEntity));
    }

    @Test
    public void testSamePropertyValuesAs___() {
        OptionParser parser = new OptionParser();
        OptionSpec<Integer> port = parser.accepts("port").withRequiredArg().ofType(Integer.class);
        OptionSpec<Void> knownPeerPorts = parser.accepts("known-peer-ports");
        OptionSpec<String> ports = parser.nonOptions().ofType(String.class);

        OptionSet options = parser.parse("--port", "33333", "--known-peer-ports", "44444", "55555");

        assertTrue(options.has(knownPeerPorts));

        assertTrue(options.has(port));
        assertTrue(options.hasArgument(port));
        Integer expectedCount = 33333;
        assertEquals(expectedCount, options.valueOf(port));
        assertEquals(expectedCount, port.value(options));
        assertEquals(asList(expectedCount), options.valuesOf(port));
        assertEquals(asList(expectedCount), port.values(options));
        assertEquals(asList("44444", "55555"), options.valuesOf(ports));

        assertEquals(asList("44444", "55555"), ports.values(options));

    }
}


