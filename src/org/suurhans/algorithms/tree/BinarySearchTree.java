package org.suurhans.algorithms.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public String inOrderReverse() {
        return this.inOrderReverse(this.root, new ArrayList<T>()).toString();
    }

    public String inOrder() {
        return this.inOrder(this.root, new ArrayList<T>()).toString();
    }

    public String preOrder() {
        return this.preOrder(this.root, new ArrayList<T>()).toString();
    }

    public String postOrder() {
        return this.postOrder(this.root, new ArrayList<T>()).toString();
    }

    public List<T> inOrder(Node<T> node, List<T> buffer) {

        if (node == null)
            return null;

        this.inOrder(node.left, buffer);
        buffer.add(node.data);
        this.inOrder(node.right, buffer);

        return buffer;
    }

    public List<T> inOrderReverse(Node<T> node, List<T> buffer) {

        if (node == null)
            return null;

        this.inOrderReverse(node.right, buffer);
        buffer.add(node.data);
        this.inOrderReverse(node.left, buffer);

        return buffer;
    }

    public List<T> preOrder(Node<T> node, List<T> buffer) {

        if (node == null)
            return null;

        buffer.add(node.data);
        this.preOrder(node.left, buffer);
        this.preOrder(node.right, buffer);

        return buffer;
    }

    public List<T> postOrder(Node<T> node, List<T> buffer) {

        if (node == null)
            return null;

        this.postOrder(node.left, buffer);
        this.postOrder(node.right, buffer);

        buffer.add(node.data);

        return buffer;
    }

    public void insert(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot insert null data");
        }

        this.root = this.insert(data, this.root);
    }

    public Node<T> insert(T data, Node<T> node) {

        if (node == null) {
            node = new Node<T>(data);
        } else if (data.compareTo(node.data) < 0) {
            node.left = this.insert(data, node.left);
        } else if (data.compareTo(node.data) > 0) {
            node.right = this.insert(data, node.right);
        } else {
            return node;
        }

        return node;
    }

    public Node<T> leastCommonAncestor(T data1, T data2) {

        if (data1.compareTo(data2) < 0) {
            return this.leastCommonAncestor(data1, data2, this.root);
        } else {
            return this.leastCommonAncestor(data2, data1, this.root);
        }

    }

    public Node<T> leastCommonAncestor(T data1, T data2, Node<T> node) {

        if (node.data == data1 || node.data == data2)
            return node;

        if (node.left != null && (node.left.data == data1 || node.left.data == data2))
            return node;

        if (node.right != null && (node.right.data == data1 || node.right.data == data2))
            return node;

        // if current node value is larger than my smaller value
        if (data1.compareTo(node.data) < 0) {

            return this.leastCommonAncestor(data1, data2, node.left);

        // if current node  value is smaller than my larger value
        } else if (data2.compareTo(node.data) > 0) {

            return this.leastCommonAncestor(data1, data2, node.right);

        }

        return null;
    }

    public Node<T> leastCommonAncestor2(T data1, T data2) {

        if (data1.compareTo(data2) < 0) {
            return this.leastCommonAncestor2(data1, data2, this.root);
        } else {
            return this.leastCommonAncestor2(data2, data1, this.root);
        }

    }

    public Node<T> leastCommonAncestor2(T data1, T data2, Node<T> node) {

        if (node == null)
            return null;

        if (data1.compareTo(node.data) < 0 && data2.compareTo(node.data) < 0) {
            return this.leastCommonAncestor2(data1, data2, node.left);
        } else if (data1.compareTo(node.data) > 0 && data2.compareTo(node.data) > 0) {
            return this.leastCommonAncestor2(data1, data2, node.right);
        } else if (data1.compareTo(node.data) < 0 && data2.compareTo(node.data) > 0) {
            return node;
        } else {
            return null;
        }

    }

    public Node<T> successor(T data) {
        return this.successor(data, this.root);
    }

    public Node<T> predecessor(T data) {
        return this.predecessor(data, this.root);
    }

    // smallest larger value than data
    public Node<T> successor(T data, Node<T> node) {

        // current node too small for what we are looking for
        // so we need to check right for larger values
        if (data.compareTo(node.data) >= 0) {

            // there are no larger values, bail
            if (node.right == null)
                return null;
            else
                return this.successor(data, node.right);

        // current node too big, need to find smaller ones from left
        } else {

            // there's no left subtree, meaning there aren't any smaller values to look for
            if (node.left == null)
                return node;

            // traverse the left subtree for smaller values
            Node<T> left = this.successor(data, node.left);

            // did not find smaller values
            if (left == null)
                return null;
            else {

                if (left.data.compareTo(node.data) > 0) {
                    return node;
                } else {
                    return left;
                }

            }
        }
    }

    // biggest value smaller than data
    public Node<T> predecessor(T data, Node<T> node) {

        // if the node is too big or has the same value
        if (data.compareTo(node.data) <= 0) {

            // if there are no smaller values, return null
            if (node.left == null)
                return null;
            else
                return this.predecessor(data, node.left);

        // the node is too small, need to traverse right for bigger values
        } else {

            // if there are no bigger values, then we are the smallest
            if (node.right == null)
                return node;

            Node<T> right = this.predecessor(data, node.right);

            // did not find a bigger value
            if (right == null) {
                return node;
            } else {

                // found a bigger value, compare and return the bigger one
                if (right.data.compareTo(node.data) < 0) {
                    return node;
                } else {
                    return right;
                }

            }

        }

    }

    public static void main(String[] args) {

        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

        tree.insert(20);
        tree.insert(8);
        tree.insert(22);
        tree.insert(4);
        tree.insert(12);
        tree.insert(10);
        tree.insert(14);
        tree.insert(16);

        //System.out.println(tree.leastCommonAncestor(16, 4));
        //System.out.println(tree.leastCommonAncestor2(16, 4));
        //Node<Integer> node2 = tree.LCA(12, 14, tree.root);

        System.out.println(tree.preOrder());
        System.out.println(tree.inOrder());
        //System.out.println(tree.inOrderReverse());
        System.out.println(tree.postOrder());

        //System.out.println("Successor of 12 is " + tree.successor(12).data);
        //System.out.println("Predecessor of 12 is "+ tree.predecessor(12).data);
    }
}
