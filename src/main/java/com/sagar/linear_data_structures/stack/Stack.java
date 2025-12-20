package com.sagar.linear_data_structures.stack;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class Stack {

    private final List<Character> leftBracketsArray = Arrays.asList('(', '<', '{', '[');
    private final List<Character> rightBracketsArray = Arrays.asList(')', '>', '}', ']');

    public String ReverseAString(String message) {

        if (message == null)
            throw new IllegalArgumentException();

        java.util.Stack messageStack = new java.util.Stack<Character>();
        for (char ch : message.toCharArray()) {
            messageStack.push(ch);
        }

        StringBuffer reverseString = new StringBuffer();
        while (!messageStack.isEmpty()) {
            reverseString.append(messageStack.pop());
        }

        return reverseString.toString();
    }

    public boolean balancedExpression(String exp) {
        var bracketsStack = new java.util.Stack<Character>();
        for (char ch : exp.toCharArray()) {
            if (isLeftBrackets(ch)) {
                bracketsStack.push(ch);
            } else if (isRightBrackets(ch)) {
                if (bracketsStack.isEmpty())
                    return false;

                var top = bracketsStack.pop();
                return matchBrackets(top, ch);
            }
        }
        return bracketsStack.isEmpty();
    }

    private boolean isLeftBrackets(char ch) {
        return leftBracketsArray.contains(ch);
    }

    private boolean isRightBrackets(char ch) {
        return rightBracketsArray.contains(ch);
    }

    private boolean matchBrackets(char left, char right) {
        return leftBracketsArray.indexOf(left) == rightBracketsArray.indexOf(right);
    }
}
