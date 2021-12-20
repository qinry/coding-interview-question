package io.dure.number;

public class MaxProduct {
    // O(n^2) time | O(n) space
//    public int maxProduct(String[] words) {
//        boolean[][] flags = new boolean[words.length][26];
//        for (int i = 0; i < words.length; i++) {
//            for (char c : words[i].toCharArray()) {
//                flags[i][c - 'a'] = true;
//            }
//        }
//        int result = 0;
//        for (int i = 0; i < words.length; i++) {
//            for (int j = i + 1; j < words.length; j++) {
//                int k = 0;
//                for (;k < 26; k++) {
//                    if (flags[i][k] && flags[j][k]) {
//                        break;
//                    }
//                }
//                if (k == 26) {
//                    int prod = words[i].length() * words[j].length();
//                    maxProduct = Math.max(prod, result);
//                }
//            }
//        }
//        return maxProduct;
//    }

    // O(n^2) time | O(n) space
    public int maxProduct(String[] words) {
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                flags[i] |= 1 << (c - 'a');
            }
        }
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((flags[i] & flags[j]) == 0) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(prod, result);
                }
            }
        }
        return result;
    }
}
