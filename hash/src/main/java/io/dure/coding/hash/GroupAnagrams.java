package io.dure.coding.hash;

import java.util.*;

public class GroupAnagrams {
    // O(nmlogm) time | O(1）space
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groups = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            groups.putIfAbsent(key, new LinkedList<>());
            groups.get(key).add(s);
        }
        return new LinkedList<>(groups.values());
    }
}
