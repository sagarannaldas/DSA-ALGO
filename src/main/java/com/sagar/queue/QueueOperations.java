package com.sagar.queue;

import java.util.Queue;
import java.util.Stack;

public class QueueOperations {

    public static void reverse(Queue<Integer> queue) {
        var stack = new Stack<Integer>();
        // add
        // remove
        // isEmpty
        // [10 20 30] -> [30 20 10]
        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());
    }
}
