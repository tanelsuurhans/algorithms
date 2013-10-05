package org.suurhans.algorithms.questions;

import java.util.ArrayList;
import java.util.List;

public class ReverseDestroy {

    public static class Node<T> {

        private T data;
        private Node<T> next;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }

        public String toString() {
            return "<Node: " + this.data + ">";
        }

    }

    public static class LinkedList<T> {

        private Node<T> head;
        private Integer size = 0;

        public LinkedList() {
        }

        public void append(T data) {
            this.insert(data, this.size);
        }

        public void insert(T data, int index) {

            if (index < 0)
                throw new IndexOutOfBoundsException("Cannot insert element to position a position below zero");

            if (index > this.size)
                throw new IndexOutOfBoundsException("Cannot insert element beyond " + this.size);

            if (this.head == null) {

                this.head = new Node<T>(data);

            } else if (index == 0) {

                Node<T> node = new Node<T>(data);

                node.next = head;
                this.head = node;

            } else {

                Node<T> node = this.head;

                for (int i = 0; i < index - 1; i++) {
                    node = node.next;
                }

                Node<T> added = new Node<T>(data);

                added.next = node.next;
                node.next = added;
            }

            this.size++;
        }

        public void remove(int index) {

            if (index < 0)
                throw new IndexOutOfBoundsException("Cannot remove element with index below 0");

            if (index > size - 1)
                throw new IndexOutOfBoundsException("Cannot remove element at position: " + index);

            if (index == 0) {

                head = head.next;

            } else {

                Node<T> node = this.head;
                Node<T> prev = null;

                for (int i = 0; i < index; i++) {
                    prev = node;
                    node = node.next;
                }

                prev.next = node.next;
            }

            this.size--;
        }

        public Node<T> elementAt(int index) {

            if (index < 0)
                throw new IndexOutOfBoundsException("Cannot get element from position below zero");

            if (index > size - 1)
                throw new IndexOutOfBoundsException("Index is out of range");


            Node<T> node = this.head;

            for (int i = 0; i < index; i++) {
                node = node.next;
            }

            return node;
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

    }

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<Integer>();

        list.append(1);
        list.append(4);
        list.append(2);
        list.append(5);
        list.append(3);

        System.out.println(list.toString());
    }

}
