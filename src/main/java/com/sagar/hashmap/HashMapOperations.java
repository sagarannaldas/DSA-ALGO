package com.sagar.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapOperations {

    public Character firstNonRepeatedCharacter(String text) {
        // a green apple

        Map<Character, Integer> hashmap = new HashMap<>();
        char[] chars = text.toCharArray();

        for (char ch : chars) {
            if (hashmap.containsKey(ch))
                hashmap.put(ch, hashmap.get(ch) + 1);
            else
                hashmap.put(ch, 1);
        }

        for (char ch : chars)
            if (hashmap.get(ch) == 1)
                return ch;

        return Character.MIN_VALUE;
    }

    public Character firstRepeatedCharacter(String text) {
        // a green apple
        Set<Character> hashSet = new HashSet<>();

        for (char ch : text.toCharArray()) {
            if (hashSet.contains(ch))
                return ch;

            hashSet.add(ch);
        }
        return Character.MIN_VALUE;
    }
}