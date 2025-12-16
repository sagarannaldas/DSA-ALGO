package com.sagar;

import com.sagar.linkedlist.LinkedList;

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

        var linkedList = new LinkedList();
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
        System.out.println(linkedList.getKthNodeFromTheEnd(5));

        //
    }
}