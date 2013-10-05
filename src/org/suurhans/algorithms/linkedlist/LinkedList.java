package org.suurhans.algorithms.linkedlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Author: Tanel Suurhans
 * Created: 9/4/12 10:49 PM
 */
public class LinkedList<T> {

    protected Node<T> head;
    protected Node<T> tail;

    protected int size = 0;

    public LinkedList() {

    }

    public void insert(T item, int position) {

        if (position < 0) {
            throw new IndexOutOfBoundsException("Cannot insert node in a position smaller than 0");
        }

        if (position > this.size) {
            throw new IndexOutOfBoundsException("Cannot insert node in a position larger than " + this.size);
        }

        if (item == null) {
            throw new IllegalArgumentException("Cannot insert a null item");
        }

        if (this.head == null) {
            this.head = new Node<T>(item);
            this.tail = this.head;
        } else {

            if (position == 0) {

                Node<T> node = new Node<T>();
                node.next = this.head;
                node.data = item;

                this.head = node;


            } else if (position == this.size) {

                Node<T> node = new Node<T>();
                node.prev = this.tail;
                node.data = item;

                this.tail.next = node;
                this.tail = node;

            } else {

                Node<T> node = this.head;

                for (int i = 0; i < position; i++) {
                    node = node.next;
                }

                Node<T> added = new Node<T>(item);

                added.next = node.next;
                added.prev = node;

                node.next = added;
            }

        }

        this.size++;
    }

    public void append(T item) {
        this.insert(item, this.size);
    }

    public void prepend(T item) {
        this.insert(item, 0);
    }

    public void addAll(Collection<T> list) {

        if (list == null) {
            throw new IllegalArgumentException("List has a null value");
        }

        for (T item : list) {
            this.append(item);
        }
    }

    public void remove(T item) {
        int index = this.search(item);

        if (index == -1) {
            throw new IllegalArgumentException("Cannot remove non-existent item");
        }

        this.remove(index);
    }

    public void remove(int index) {

        if (index < 0) {
            throw new IndexOutOfBoundsException("Cannot remove element from position smaller than 0");
        }

        if (index > this.size - 1) {
            throw new IndexOutOfBoundsException("Cannot remove element from position greater than " + this.size);
        }

        if (this.head == null) {
            throw new IllegalArgumentException("Cannot remove element from an empty list");
        }

        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {

            if (index == 0) {

                this.head = this.head.next;
                this.head.prev = null;

            } else if (index == this.size - 1) {

                this.tail = this.tail.prev;
                this.tail.next = null;

            } else {

                Node<T> node = this.head;
                Node<T> prev = null;

                for(int i = 0; i < index; i++) {
                    prev = node;
                    node = node.next;
                }

                prev.next = node.next;
                prev.next.prev = prev;
            }

        }

        this.size--;
    }

    public int size() {
        return this.size;
    }

    public int search(T item) {

        if (this.size > 0) {

            Node<T> node = this.head;

            for (int i = 0; i < this.size; i++) {

                if (item == null && node.data == null) {
                    return i;
                } else if (node.data.equals(item)) {
                    return i;
                }

                node = node.next;
            }
        }

        return -1;
    }

    public Node<T> elementAt(int index) {

        if (index < 0) {
            throw new IndexOutOfBoundsException("Cannot find element at position below 0");
        }

        if (index > this.size - 1) {
            throw new IndexOutOfBoundsException("Cannot find element beyond position " + this.size);
        }

        Node<T> node;

        if (index == this.size - 1) {
            node = this.tail;
        } else {

            node = this.head;

            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }

        return node;
    }

    public NodeIterator<T> iterator() {
        return new NodeIterator<T>(this.head);
    }

    public T get(int index) {
        return this.elementAt(index).data;
    }

    public void set(T data, int index) {
        this.elementAt(index).data = data;
    }

    public String toString() {

        List<T> list = new ArrayList<T>();
        Node<T> node = this.head;

        while(node != null) {
            list.add(node.data);
            node = node.next;
        }

        return list.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.append(1);
        list.append(2);

        System.out.println(list);
    }

}
