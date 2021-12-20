package io.dure.coding.hash;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    // O(n) time | O(n) space
    public boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length() || str1.equals(str2)) {
            return false;
        }
        Map<Character,Integer> charToCount = new HashMap<>();
        for (char ch1 : str1.toCharArray()) {
            charToCount.put(ch1, charToCount.getOrDefault(ch1, 0) + 1);
        }
        for (char ch2 : str2.toCharArray()) {
            if (!charToCount.containsKey(ch2) || charToCount.get(ch2) == 0) {
                return false;
            }
            charToCount.put(ch2, charToCount.get(ch2) - 1);
        }
        return true;
    }
}
