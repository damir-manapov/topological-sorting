package ru.damirmanapov;

import java.util.LinkedList;
import java.util.List;

public class Node {

    private int id;

    private List<Node> children = new LinkedList<>();
    private List<Node> parents = new LinkedList<>();

    public Node(int id) {
        this.id = id;
    }

    public Node(int id, List<Node> children) {
        this.id = id;
        this.children = children;
        for (Node child : children) {
            child.addParent(this);
        }
    }

    public void addParent(Node parent) {
        parents.add(parent);
    }

    public List<Node> getChildren() {
        return children;
    }

    public List<Node> getParents() {
        return parents;
    }

    @Override
    public String toString() {
        return "id: " + id;
    }
}
