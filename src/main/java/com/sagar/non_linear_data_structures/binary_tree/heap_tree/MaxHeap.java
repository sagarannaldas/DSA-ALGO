package com.sagar.non_linear_data_structures.binary_tree.heap_tree;

public class MaxHeap {

    public static void heapify(int[] array) {
        // In perfect binary tree , half of the nodes are in the last level
        // Heapify property, every parent is greater >= child, so technically we dont have to perform this operation on leaf nodes
        // Only Heapify the Parents nodes, bcz leaf nodes dont have child
        // LastParentIndex = total nodes / 2 - 1
        var lastParentIndex = array.length / 2 - 1;
        for (int i = 0; i < lastParentIndex; i++)
            heapify(array, i);
    }

    private static void heapify(int[] array, int index) {
        var largerIndex = index;

        var leftChildIndex = index * 2 + 1;
        if (leftChildIndex < array.length && array[leftChildIndex] > array[largerIndex])
            largerIndex = leftChildIndex;

        var rightChildIndex = index * 2 + 2;
        if (rightChildIndex < array.length && array[rightChildIndex] > array[largerIndex])
            largerIndex = rightChildIndex;

        if (index == largerIndex)
            return;

        swap(array, largerIndex, index);

        heapify(array, largerIndex);
    }

    private static void swap(int[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int getKthLargest(int[] array, int k) {
        if (k < 1 || k > array.length)
            throw new IllegalArgumentException();

        Heap heap = new Heap(array.length);

        for (int i : array)
            heap.insert(i);

        for (int i = 0; i < k - 1; i++) {
            heap.remove();
        }
        return heap.maxHeap();
    }
}
