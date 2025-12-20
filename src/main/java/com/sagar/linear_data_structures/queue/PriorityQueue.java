package com.sagar.linear_data_structures.queue;

import java.util.Arrays;

public class PriorityQueue {
    private int[] priorityItems = new int[5];
    private int count;

    public PriorityQueue(int capacity) {
        priorityItems = new int[capacity];
    }

    public void add(int value) {
        if (isFull())
            throw new IllegalStateException();

        //Shifting items
        int i = shiftItemsToInsert(value);
        priorityItems[i] = value;
        count++;
    }

    private int shiftItemsToInsert(int value) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (priorityItems[i] > value) {
                priorityItems[i + 1] = priorityItems[i];
            } else {
                break;
            }
        }
        return i + 1;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        return priorityItems[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == priorityItems.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(priorityItems);
    }
}
