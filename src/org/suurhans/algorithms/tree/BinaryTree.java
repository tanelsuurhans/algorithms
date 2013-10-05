package org.suurhans.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root;

    public Node<T> insert(T data) {

        Node<T> node = new Node<T>(data);

        if (this.root == null) {
            this.root = node;
        } else {

            Queue<Node<T>> queue = new LinkedList<Node<T>>();
            queue.add(this.root);

            while(!queue.isEmpty()) {

                Node<T> current = queue.poll();

                if (current.left == null) {
                    current.left = node;
                    queue.clear();
                } else if (current.right == null) {
                    current.right = node;
                    queue.clear();
                } else {
                    queue.add(current.left);
                    queue.add(current.right);
                }

            }

        }

        return node;
    }

    public void inOrder() {
        this.inOrder(this.root);
    }

    public void preOrder() {
        this.preOrder(this.root);
    }

    public void postOrder() {
        this.postOrder(this.root);
    }

    public void inOrder(Node<T> node) {

        if (node == null)
            return;

        this.inOrder(node.left);
        System.out.println(node);
        this.inOrder(node.right);
    }

    public void preOrder(Node<T> node) {

        if (node == null)
            return;

        System.out.println(node);
        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    public void postOrder(Node<T> node) {

        if (node == null)
            return;

        this.postOrder(node.left);
        this.postOrder(node.right);

        System.out.println(node);
    }

    public Node<T> leastCommonAncestor(T data1, T data2, Node<T> node) {

        if (node == null)
            return null;

        if (node.data == data1 || node.data == data2)
            return node;

        Node<T> left = this.leastCommonAncestor(data1, data2, node.left);
        Node<T> right = this.leastCommonAncestor(data1, data2, node.right);

        if (left != null && right != null)
            return node;

        if (left != null) {
            return left;
        } else {
            return right;
        }

    }

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<Integer>();

        tree.insert(3);
        tree.insert(5);
        tree.insert(1);
        tree.insert(2);
        tree.insert(6);
        tree.insert(0);
        tree.insert(8);
        tree.insert(7);
        tree.insert(4);

        //System.out.println(tree.leastCommonAncestor(4, 20, tree.root));
        System.out.println("=== in order ===");
        tree.inOrder();
        System.out.println("=== pre order ===");
        tree.preOrder();
        System.out.println("=== post order ===");
        tree.postOrder();
    }

}
