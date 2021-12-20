package io.dure.coding.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Partition {
    public String[][] partition(String s) {
        List<String[]> result = new LinkedList<>();
        helper(s, 0, new LinkedList<>(), result);
        return result.toArray(String[][]::new);
    }

    private void helper(String str,
                        int start,
                        LinkedList<String> substrings,
                        List<String[]> result) {
        if (start == str.length()) {
            result.add(substrings.toArray(String[]::new));
            return;
        }
        for (int i = start; i < str.length(); i++) {
            if (isPalindrome(str, start, i)) {
                substrings.add(str.substring(start, i + 1));
                helper(str, i + 1, substrings, result);
                substrings.removeLast();
            }
        }
    }
    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}