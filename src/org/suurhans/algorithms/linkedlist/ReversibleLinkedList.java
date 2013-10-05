package org.suurhans.algorithms.linkedlist;

public class ReversibleLinkedList<T> extends LinkedList<T> {

    public void reverse() {

        int stop = size - 1;
        int half = size / 2;

        for (int i = 0; i < half; i++) {
            T a = this.get(i);
            T b = this.get(stop - i);

            this.set(b, i);
            this.set(a, stop - i);
        }
    }

    public void reverse2() {

        Node<T> prev = null;
        Node<T> head = this.head;

        while (head != null) {
            Node<T> temp = head;
            head = head.next;

            temp.next = prev;
            prev = temp;
        }

        this.head = prev;
    }

    public void reverse3() {

        Node<T> prev = null;
        Node<T> head = this.head;

        while (head != null) {

            Node<T> next = head.next;

            head.next = prev;
            prev = head;
            head = next;
        }

        this.head = prev;
    }

    public void reverse4() {
        this.head = this.reverse4(this.head);
    }

    public Node<T> reverse4(Node<T> head) {

        if (head.next == null)
            return head;

        Node<T> next = head.next;       // B
        Node<T> tail = reverse4(next);  // C => B

        head.next = null; // B => null
        next.next = head; // B => A

        return tail; // C => B => A
    }

    public void reversePrint() {
        reversePrint(this.head);
    }

    public void reversePrint(Node<T> node) {

        if (node.next == null) {
            System.out.println(node.data);
        } else {
            reversePrint(node.next);
            System.out.println(node.data);
        }

    }

    public static void main(String[] args) {


        ReversibleLinkedList<Integer> list = new ReversibleLinkedList<Integer>();

        list.append(1);
        list.append(4);
        list.append(2);
        list.append(5);
        list.append(3);
        list.reverse();

        System.out.println(list.toString());

    }

}
