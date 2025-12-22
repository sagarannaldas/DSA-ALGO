package com.sagar.non_linear_data_structures;

import java.util.ArrayList;

public class Tree {

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    public void insert(int value) {
        var newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }

        var currentNode = root;
        while (true) {
            if (value < currentNode.value) {
                if (currentNode.leftChild == null) {
                    currentNode.leftChild = newNode;
                    break;
                }
                currentNode = currentNode.leftChild;
            } else {
                if (currentNode.rightChild == null) {
                    currentNode.rightChild = newNode;
                    break;
                }
                currentNode = currentNode.rightChild;
            }
        }
    }

    public boolean find(int value) {
        var currentNode = root;

        while (currentNode != null) {
            if (value < currentNode.value) {
                currentNode = currentNode.leftChild;
            } else if (value > currentNode.value) {
                currentNode = currentNode.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    // recursion technic
    private void traversePreOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.value);
        traversePreOrder(node.leftChild);
        traversePreOrder(node.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node node) {
        if (node == null)
            return;
        traverseInOrder(node.leftChild);
        System.out.println(node.value);
        traverseInOrder(node.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node node) {
        if (node == null)
            return;
        traversePostOrder(node.leftChild);
        traversePostOrder(node.rightChild);
        System.out.println(node.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null)
            return -1;

        if (isLeaf(node))
            return 0;

        return 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    public int min() {
        return min(root);
    }

    // O(n)
    private int min(Node node) {
        if (isLeaf(node))
            return node.value;

        var leftSubtree = min(node.leftChild);
        var rightSubtree = min(node.rightChild);

        return Math.min(Math.min(leftSubtree, rightSubtree), node.value);
    }

    private boolean isLeaf(Node node) {
        return (node.leftChild == null && node.rightChild == null);
    }

    // O(log n)
    public int minBST() {
        var current = root;

        if (current == null)
            throw new IllegalStateException();

        var last = current;

        while (current != null) {
            last = current;
            current = current.leftChild;
        }

        return last.value;
    }

    public boolean equals(Tree other) {
        if (other == null)
            return false;
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null) {
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }

        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node node, int min, int max) {

        if (node == null)
            return true;

        if (node.value < min || node.value > max)
            return false;

        return isBinarySearchTree(node.leftChild, min, node.value - 1)
                && isBinarySearchTree(node.rightChild, node.value + 1, max);

    }

    public void swapRootChildren() {
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null)
            return;

        if (distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);

    }

    public void traverseLevelOrder() {
        for (int i = 0; i <= height(); i++) {
            for (var value : getNodesAtDistance(i)) {
                System.out.println(value);
            }
        }
    }
}
