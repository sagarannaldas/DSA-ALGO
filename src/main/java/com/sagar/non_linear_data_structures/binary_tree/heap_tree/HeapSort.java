package com.sagar.non_linear_data_structures.binary_tree.heap_tree;

public class HeapSort {
    public int[] sortAscending(int[] numbers) {
        // Max Heap
        Heap heap = new Heap(numbers.length);
        var ascendingSorted = new int[numbers.length];
        for (int i : numbers) {
            heap.insert(i);
        }
        for (int i = numbers.length - 1; i >= 0; i--) {
            ascendingSorted[i] = heap.remove();
        }
        return ascendingSorted;
    }
}
