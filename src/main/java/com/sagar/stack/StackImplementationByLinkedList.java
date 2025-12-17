package com.sagar.stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class StackImplementationByLinkedList {

    private Node first;
    private Node last;
    private int count = 0;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // push
    // pop
    // peek
    // isEmpty

    public void push(int value) {
        var node = new Node(value);
        if (isEmpty()) {
            first = last = node;
            count++;
            return;
        }
        var currentNode = first;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
        last = node;
        count++;
    }

    // 10 20 30 40
    public void pop() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            count--;
        }

        var currentNode = first;
        var previousNode = first;
        while (currentNode != null) {
            if (currentNode.next == last) {
                previousNode = currentNode;
            }
            currentNode = currentNode.next;
        }
        previousNode.next = null;
        last = previousNode;
        count--;
    }

    public int peek() {
        return last.value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        var contentArray = new int[count];
        var currentNode = first;
        int i = 0;
        while (currentNode != null) {
            contentArray[i++] = currentNode.value;
            currentNode = currentNode.next;
        }
        return Arrays.toString(contentArray);
    }
}
