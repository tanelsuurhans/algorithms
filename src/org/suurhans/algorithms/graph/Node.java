package org.suurhans.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    private T data;
    private boolean visited;
    public List<Node<T>> nodes;


    public Node(T data) {
        this.data = data;
        this.visited = false;
        this.nodes = new ArrayList<Node<T>>();
    }

    public void visit() {
        this.visited = true;
    }

    public void unvisit() {
        this.visited = false;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public boolean contains(Node<T> node) {
        return this.nodes.contains(node);
    }

    public void add(Node<T> node) {
        this.nodes.add(node);
    }

    public List<Node<T>> siblings() {
        return this.nodes;
    }

    public boolean equals(Object node) {
        return (node instanceof Node) && ((Node) node).data.equals(data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return this.data.toString();
    }

}
