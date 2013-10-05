package org.suurhans.algorithms.linkedlist;

public class SortableLinkedList<T extends Comparable<T>> extends LinkedList<T> {

    public void sort() {
        sort(head);
    }

    private Node<T> sort(Node<T> list) {

        if (list == null || list.next == null)
            return list;

        Node<T> slow = list;
        Node<T> fast = list;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node<T> left = list;
        Node<T> right = slow.next;

        slow.next = null;

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    private Node<T> merge(Node<T> left, Node<T> right) {

        Node<T> temp = new Node<T>();
        Node<T> head = temp;

        while (left != null && right != null) {

            if (left.data.compareTo(right.data) > 0) {
                temp.next = right;
                right = right.next;
            } else {
                temp.next = left;
                left = left.next;
            }

            temp = temp.next;
        }

        temp.next = (left == null) ? right : left;

        return head.next;
    }

    public static void main(String[] args) {

        SortableLinkedList<Integer> list = new SortableLinkedList<Integer>();

        list.append(1);
        list.append(4);
        list.append(2);
        list.append(5);
        list.append(3);

        System.out.println(list.toString());
        list.sort();
        System.out.println(list.toString());

    }

}
