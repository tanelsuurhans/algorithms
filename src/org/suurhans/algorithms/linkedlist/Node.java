package org.suurhans.algorithms.linkedlist;

/**
 * Author: Tanel Suurhans
 * Created: 9/4/12 10:50 PM
 */
public class Node<T> {

    public T data;
    public Node<T> next;
    public Node<T> prev;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public String toString() {

        Node<T> node = this;
        StringBuffer buffer = new StringBuffer();

        buffer.append("[" + data);

        while (node.next != null) {
            node = node.next;
            buffer.append(" => " + node.data);
        }

        buffer.append("]");

        return buffer.toString();
    }

}
