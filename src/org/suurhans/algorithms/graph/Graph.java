package org.suurhans.algorithms.graph;

import java.util.*;

public class Graph<T> {

    private List<Node<T>> nodes;

    public Graph() {
        this.nodes = new ArrayList<Node<T>>();
    }

    public Graph(T[][] grid) {

        this.nodes = new ArrayList<Node<T>>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                Node<T> node = new Node<T>(grid[i][j]);

                if (i > 0) {
                    this.addEdge(node, new Node<T>(grid[i - 1][j]));
                }

                if (i < grid.length - 1) {
                    this.addEdge(node, new Node<T>(grid[i + 1][j]));
                }

                if (j > 0) {
                    this.addEdge(node, new Node<T>(grid[i][j - 1]));
                }

                if (j < grid.length - 1) {
                    this.addEdge(node, new Node<T>(grid[i][j + 1]));
                }

            }
        }

    }

    public void addEdge(Node<T> node1, Node<T> node2) {

        if (!this.nodes.contains(node1))
            this.nodes.add(node1);

        if (!this.nodes.contains(node2))
            this.nodes.add(node2);

        if (!node1.contains(node2))
            node1.add(node2);

        if (!node2.contains(node1))
            node2.add(node1);

    }

    public void traverse() {
        this.traverse(nodes.get(0));
    }

    public void traverse(Node<T> node) {

        if (node == null)
            return;

        if (!node.isVisited()) {

            node.visit();

            System.out.println(node.toString());

            for (Node<T> sibling : node.siblings()) {
                this.traverse(sibling);
            }
        }

    }

    public void depthFirst() {
        this.depthFirst(nodes.get(0));
    }

    public void depthFirst(Node<T> start) {

        Stack<Node<T>> stack = new Stack<Node<T>>();

        stack.push(start);

        while(!stack.isEmpty()) {

            Node<T> node = stack.pop();

            if (!node.isVisited()) {
                node.visit();

                System.out.println(node.toString());

                for (Node<T> sibling : node.siblings()) {
                    stack.push(sibling);
                }
            }
        }
    }

    public void breadthFirst() {
        this.breadthFirst(nodes.get(0));
    }

    public void breadthFirst(Node<T> start) {

        Queue<Node<T>> queue = new LinkedList<Node<T>>();

        queue.add(start);

        while(!queue.isEmpty()) {

            Node<T> node = queue.poll();

            if (!node.isVisited()) {

                node.visit();

                System.out.println(node);

                for (Node<T> sibling : node.siblings()) {
                    queue.add(sibling);
                }
            }
        }
    }

    public List<String> findPaths(Node<T> node1, Node<T> node2) {
        return this.findPath(node1, node2, "", new ArrayList<String>());
    }

    private List<String> findPath(Node<T> node1, Node<T> node2, String path, List<String> paths) {

        if (!path.contains(node1.toString())) {

            path += node1.toString();

            if (node1.equals(node2)) {
                paths.add(path);
            } else {
                for (Node<T> sibling : node1.siblings()) {
                    findPath(sibling, node2, path, paths);
                }
            }

        }

        return paths;
    }

    public List<Node<T>> getDirections(Node<T> node1, Node<T> node2) {

        List<Node<T>> directions = new LinkedList<Node<T>>();
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        Map<Node<T>, Node<T>> backlinks = new HashMap<Node<T>, Node<T>>();

        queue.add(node1);

        while(!queue.isEmpty()) {

            Node<T> node = queue.poll();

            if (!node.isVisited()) {

                if (node == node2)
                    break;

                node.visit();

                for (Node<T> sibling : node.siblings()) {

                    if (!sibling.isVisited()) {
                        backlinks.put(sibling, node);
                        queue.add(sibling);
                    }

                }
            }
        }

        for(Node<T> node = node2; node != null; node = backlinks.get(node)) {
            directions.add(node);
        }

        Collections.reverse(directions);

        return directions;
    }

    public void reset() {

        for (Node<T> node : nodes) {
            node.unvisit();
        }

    }

    public String toString() {
        return nodes.toString();
    }

    public static void main(String[] args) {

        Node<String> nodeA = new Node<String>("A");
        Node<String> nodeB = new Node<String>("B");
        Node<String> nodeC = new Node<String>("C");
        Node<String> nodeD = new Node<String>("D");
        Node<String> nodeE = new Node<String>("E");
        Node<String> nodeF = new Node<String>("F");
        Node<String> nodeG = new Node<String>("G");

        Graph<String> graph = new Graph<String>();
        graph.addEdge(nodeA, nodeB);
        graph.addEdge(nodeA, nodeC);
        graph.addEdge(nodeB, nodeD);
        graph.addEdge(nodeD, nodeE);
        graph.addEdge(nodeD, nodeG);
        graph.addEdge(nodeG, nodeE);
        graph.addEdge(nodeE, nodeF);

        System.out.println(graph.findPaths(nodeA, nodeE));
        System.out.println(graph.getDirections(nodeA, nodeE));

    }

}
