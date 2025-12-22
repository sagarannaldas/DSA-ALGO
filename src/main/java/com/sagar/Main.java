package com.sagar;

import com.sagar.non_linear_data_structures.binary_tree.Tree;
import com.sagar.non_linear_data_structures.binary_tree.avl_tree.AVLTree;

class Main {
    public static void main(String[] args) {

        //--------------------------------- Linear Data Structures ----------------------------------------------

        // Array

/*        Array numbers = new Array(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.removeAt(3);
        System.out.println(numbers.indexOf(50));
        numbers.printArray();
        numbers.size();*/

        // LinkedList

/*        var linkedList = new LinkedList();
        System.out.println(linkedList.size());
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addFirst(100);
        System.out.println(linkedList.indexOf(40));
        System.out.println(linkedList.contains(10));
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList.size());
        linkedList.reverse();
        linkedList.addFirst(100);
        linkedList.addLast(120);
        linkedList.removeFirst();
        linkedList.removeLast();
        var array = linkedList.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(linkedList.getKthNodeFromTheEnd(5));*/

        // Stack

        /*Stack stack = new Stack();

        var reverseString = stack.ReverseAString("macbook");
        System.out.println(reverseString);

        var balanceExp = stack.balancedExpression("((1+<2<))");
        System.out.println(balanceExp);

        // Stack via arrays

        StackImplementationByArray stackImplementationByArray = new StackImplementationByArray();
        stackImplementationByArray.push(10);
        stackImplementationByArray.push(20);
        stackImplementationByArray.push(30);
        stackImplementationByArray.push(40);
        stackImplementationByArray.push(50);
        stackImplementationByArray.push(60);
        stackImplementationByArray.push(70);
        stackImplementationByArray.push(80);
        stackImplementationByArray.push(90);
        stackImplementationByArray.push(100);
        stackImplementationByArray.push(110);
        stackImplementationByArray.pop();
        stackImplementationByArray.push(110);
        System.out.println(stackImplementationByArray);

        // Stack via linked list

        StackImplementationByLinkedList stackImplementationByLinkedList = new StackImplementationByLinkedList();
        stackImplementationByLinkedList.push(10);
        stackImplementationByLinkedList.push(20);
        stackImplementationByLinkedList.push(30);
        System.out.println(stackImplementationByLinkedList);
        stackImplementationByLinkedList.pop();
        System.out.println(stackImplementationByLinkedList);
        System.out.println(stackImplementationByLinkedList.peek());
        System.out.println(stackImplementationByLinkedList.isEmpty());*/

        // Queue

/*        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        arrayQueue.enqueue(40);
        arrayQueue.enqueue(50);
        System.out.println(arrayQueue);
        var front = arrayQueue.dequeue();
        System.out.println(front);
        front = arrayQueue.dequeue();
        System.out.println(front);
        arrayQueue.enqueue(60);
        System.out.println(arrayQueue);

        QueueImplementationBy2Stacks queueImplementationBy2Stacks = new QueueImplementationBy2Stacks();
        queueImplementationBy2Stacks.enqueue(10);
        queueImplementationBy2Stacks.enqueue(20);
        queueImplementationBy2Stacks.enqueue(30);
        queueImplementationBy2Stacks.enqueue(40);
        queueImplementationBy2Stacks.enqueue(50);
        queueImplementationBy2Stacks.dequeue();
        queueImplementationBy2Stacks.enqueue(50);
        System.out.println(queueImplementationBy2Stacks);

        PriorityQueue priorityQueue = new PriorityQueue(5); // Priority Queue
        priorityQueue.add(5);
        priorityQueue.add(3);
        priorityQueue.add(6);
        priorityQueue.add(1);
        priorityQueue.add(4);
        System.out.println(priorityQueue);

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }*/

        // Hash Map / Hash Tables

/*        HashMapOperations hashMapOperations = new HashMapOperations();
        char item = hashMapOperations.firstNonRepeatedCharacter("a green apple");
        System.out.println(item);

        char repeatedItem = hashMapOperations.firstRepeatedCharacter("a green apple");
        System.out.println(repeatedItem);

        HashMap hashMap = new HashMap();
        hashMap.put(6, "A");  // 1
        hashMap.put(8, "B");  // 3
        hashMap.put(11, "C"); // 1
        hashMap.put(6, "A+");

        System.out.println(hashMap.get(2));
        hashMap.remove(60);*/

        //---------------------------------- Non - Linear Data Structures -----------------------------------------

        //------------------------------------------------- Tree -----------------------------------------------------

/*        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);

        System.out.println(tree.find(11));
        System.out.println("Done");
        tree.traversePreOrder();
        tree.traverseInOrder();
        tree.traversePostOrder();
        System.out.println("Height is: " + tree.height());
        System.out.println("Min value is: " + tree.min());
        System.out.println("BST min value is: " + tree.minBST());


        Tree tree1 = new Tree();

        tree1.insert(4);
        tree1.insert(7);
        tree1.insert(9);
        tree1.insert(1);
        tree1.insert(6);
        tree1.insert(8);
        tree1.insert(10);

        System.out.println(tree.equals(tree1));

//        tree.swapRootChildren();
        System.out.println(tree.isBinarySearchTree());
        System.out.println(tree.getNodesAtDistance(2));

        tree.traverseLevelOrder();*/

        // -------------------------------------------- AVL Tree -----------------------------------------------------

        AVLTree avlTree = new AVLTree();

        avlTree.insert(30);
        avlTree.insert(15);
        avlTree.insert(18);
        avlTree.insert(10);
        avlTree.insert(16);
        avlTree.insert(7);
        avlTree.insert(8);
    }
}