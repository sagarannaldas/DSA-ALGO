package com.sagar.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    private Node first;
    private Node last;
    private int size;

    // addFirst
    // addLast
    // deleteFirst
    // deleteLast
    // contains
    // indexOf

    public void addLast(int value) {
        var node = new Node(value);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int value) {
        var node = new Node(value);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public int indexOf(int value) {
        var index = 0;
        var currentNode = first;
        while (currentNode != null) {
            if (currentNode.value == value) return index;
            index++;
            currentNode = currentNode.next;
        }
        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        } else {
            var secondNode = first.next;
            first.next = null;
            first = secondNode;
        }

        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        } else {
            var previousNode = getPrevious(last);
            previousNode.next = null;
            last = previousNode;
        }

        size--;
    }

    private Node getPrevious(Node node) {
        var currentNode = first;
        while (currentNode != null) {
            if (currentNode.next == node) return currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }

    // O(1)
    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int[] toArray() {
        var array = new int[size];
        var currentNode = first;
        var index = 0;
        while (currentNode != null) {
            array[index++] = currentNode.value;
            currentNode = currentNode.next;
        }

        return array;
    }

    /*public void reverse() {
        var array = toArray();

        if (array.length == 0){
            return;
        }
        first = null;
        last = null;
        first = new Node(array[array.length-1]);
        var currentNode = first;
        for (int i = array.length-2; i >= 0; i--) {
            currentNode.next = new Node(array[i]);
            currentNode = currentNode.next;
            if (i == 0){
                last = currentNode;
            }
        }
        System.out.println(first);
        System.out.println(last);
    }*/

    public void reverse() {
        //  f           l
        // [10 -> 20 -> 30]
        //  p     c     n

        // [10 -> 20 -> 30]
        //        p     c     n

        // [10 <- 20]

        if (isEmpty()) return;

        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthNodeFromTheEnd(int k) {
        // Find the kth node from the end of a linked list in one pass.

        // [ 10 -> 20 -> 30 -> 40 -> 50]
        //               *1st        *2nd
        // k = 1 (50)
        // k = 2 (40)
        // k = 3 (30) (distance = 2)  / apart - (k-1)

        // distance = k-1
        if (isEmpty()) throw new IllegalStateException();
        if (first == last) {
            if (k == 0) {
                return 0;
            } else {
                throw new IllegalStateException();
            }
        }

        var a = first;
        var b = first;

        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null)
                throw new IllegalArgumentException();
        }

        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }
}
