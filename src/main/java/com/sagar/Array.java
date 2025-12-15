package com.sagar;

public class Array {

    private int[] array;
    private int count = 0;

    public Array(int length) {
        array = new int[length];
    }

    public void insert(int item) {
        if (count == array.length) {
            int[] newArray = new int[count * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[count++] = item;
    }

    public void printArray() {
        for (int i = 0; i < count; i++) {
            System.out.println(array[i]);
        }
    }

    public void size() {
        System.out.println(array.length);
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            array[i] = array[i + 1];

        count--;
    }

    public int indexOf(int item) {
        // O(n) - run time complexity
        for (int i = 0; i < count; i++)
            if (array[i] == item)
                return i;

        return -1;
    }
}
