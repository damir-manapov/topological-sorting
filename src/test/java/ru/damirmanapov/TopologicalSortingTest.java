package ru.damirmanapov;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static ru.damirmanapov.TopologicalSorting.sort;

public class TopologicalSortingTest {

    @Test
    public void testIs() {

        // Level 3
        Node n2 = new Node(2);
        Node n9 = new Node(9);
        Node n10 = new Node(10);

        // Level 2
        Node n11 = new Node(11, Arrays.asList(n2, n9, n10));
        Node n8 = new Node(8, Arrays.asList(n9));

        // Level 1
        Node n7 = new Node(7, Arrays.asList(n11, n8));
        Node n5 = new Node(5, Arrays.asList(n11));
        Node n3 = new Node(3, Arrays.asList(n8, n10));


        List<Node> nodes = Arrays.asList(n2, n3, n5, n7, n8, n9, n10, n11);

        List<Node> order = sort(nodes);

        assertThat(order.indexOf(n7), is(both(greaterThanOrEqualTo(0)).and(lessThanOrEqualTo(2))));
        assertThat(order.indexOf(n5), is(both(greaterThanOrEqualTo(0)).and(lessThanOrEqualTo(2))));
        assertThat(order.indexOf(n3), is(both(greaterThanOrEqualTo(0)).and(lessThanOrEqualTo(2))));
        assertThat(order.indexOf(n11), is(both(greaterThanOrEqualTo(3)).and(lessThanOrEqualTo(4))));
        assertThat(order.indexOf(n8), is(both(greaterThanOrEqualTo(3)).and(lessThanOrEqualTo(4))));
        assertThat(order.indexOf(n2), is(both(greaterThanOrEqualTo(5)).and(lessThanOrEqualTo(7))));
        assertThat(order.indexOf(n9), is(both(greaterThanOrEqualTo(5)).and(lessThanOrEqualTo(7))));
        assertThat(order.indexOf(n10), is(both(greaterThanOrEqualTo(5)).and(lessThanOrEqualTo(7))));
    }

}


