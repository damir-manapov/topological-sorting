package ru.damirmanapov;

import java.util.*;
import java.util.stream.Collectors;

public class TopologicalSorting {

    public static List<Node> sort(List<Node> nodes) {
        Map<Node, Integer> depths = new HashMap();
        List<Node> order = new LinkedList<>();

        order.addAll(nodes.stream().filter(x -> x.getParents().isEmpty()).collect(Collectors.toList()));

        for (Node node : order) {
            compute(node, depths, 1);
        }

        return depths.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).map(x -> x.getKey()).collect(Collectors.toList());
    }

    private static void compute(Node node, Map<Node, Integer> depths, int depth) {

        if (!depths.containsKey(node) || depths.get(node) < depth) {
            depths.put(node, depth);
        }

        node.getChildren().stream().forEach(x -> compute(x, depths, depth + 1));
    }

}


