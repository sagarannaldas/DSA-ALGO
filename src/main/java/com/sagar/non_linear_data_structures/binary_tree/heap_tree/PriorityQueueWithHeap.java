package com.sagar.non_linear_data_structures.binary_tree.heap_tree;

public class PriorityQueueWithHeap {
    private Heap heap = new Heap(10);

    public void enqueue(int item) {
        heap.insert(item);
    }

    public int dequeue() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
