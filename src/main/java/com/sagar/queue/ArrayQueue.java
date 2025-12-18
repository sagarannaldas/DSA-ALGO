package com.sagar.queue;

import java.util.Arrays;

public class ArrayQueue {
    private int[] items = new int[5];
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    // ArrayQueue / ArrayDeque
    // enqueue
    // dequeue
    // peek
    // isEmpty
    // isFull
    // [10, 20, 30, 40, 50]
    //  F               R
    //  0   1   2   3   4

    // 5 -> 0    // right side numbers are remainders of division 5
    // 6 -> 1     // left % length = remainder
    // 7 -> 2
    // 8 -> 3
    // 9 -> 4
    // 10 -> 0
    // 11 -> 1
    public void enqueue(int value) {
        if (isFull())
            throw new IllegalArgumentException();

        items[rear] = value;
        rear = (rear + 1) % items.length; // modulus - circular array
        count++;
    }

    public int dequeue() {
        if (count == 0)
            throw new IllegalArgumentException();

        var firstItem = items[front];
        items[front] = 0;
        front = (front + 1) % items.length; // modulus - circular array
        count--;
        return firstItem;
    }

    private int peek() {
        return items[front];
    }

    private boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
