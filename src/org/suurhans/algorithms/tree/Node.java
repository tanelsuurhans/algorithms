package org.suurhans.algorithms.tree;

public class Node<T extends Comparable<T>> {

    public Node<T> left;
    public Node<T> right;

    public T data;

    public Node(T data) {
        this.data = data;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Node[data: " + data + "]");

        if (this.left == null) {
            builder.append(" (left: null)");
        } else {
            builder.append(" (left: " + left.data + ")");
        }

        if (this.right == null) {
            builder.append(" (right: null)");
        } else {
            builder.append(" (right: " + right.data + ")");
        }

        return builder.toString();
    }

}
