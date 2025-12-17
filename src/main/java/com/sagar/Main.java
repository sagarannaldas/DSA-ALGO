package com.sagar;

import com.sagar.linkedlist.LinkedList;
import com.sagar.stack.Stack;
import com.sagar.stack.StackImplementationByArray;
import com.sagar.stack.StackImplementationByLinkedList;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {

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

        Stack stack = new Stack();

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
        System.out.println(stackImplementationByLinkedList.isEmpty());
    }
}