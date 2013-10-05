package org.suurhans.algorithms.linkedlist;

import java.util.Iterator;

/**
 * Author: Tanel Suurhans
 * Created: 9/4/12 10:53 PM
 */
public class NodeIterator<T> implements Iterator<T> {

    private Node<T> node;

    public NodeIterator(Node<T> node) {
        Node<T> head = new Node<T>();

        head.next = node;
        this.node = head;
    }

    public boolean hasNext() {
        return this.node.next != null;
    }

    public T next() {
        return (this.node = this.node.next).data;
    }

    public void remove() {
        throw new UnsupportedOperationException("");
    }

}
