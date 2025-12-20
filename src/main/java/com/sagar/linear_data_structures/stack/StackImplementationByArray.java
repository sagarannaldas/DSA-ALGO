package com.sagar.linear_data_structures.stack;

import java.util.Arrays;

public class StackImplementationByArray {
    private int[] array = new int[10];
    private int index = 0;

    // 10 20 30 40
    public void push(int item) {
        if (index >= array.length) {
            var newArray = new int[index * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[index++] = item;
    }

    public int pop() {
        if (array.length == 0)
            throw new IllegalStateException();
        var popItem = array[index - 1];
        array[--index] = 0;
        return popItem;
    }

    public int peek() {
        if (index == 0)
            throw new IllegalStateException();

        return array[index - 1];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public String toString() {
        var stackContent = Arrays.copyOfRange(array, 0, index);
        return Arrays.toString(stackContent);
    }
}
