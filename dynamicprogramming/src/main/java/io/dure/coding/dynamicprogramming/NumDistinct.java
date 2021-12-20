package io.dure.coding.dynamicprogramming;

public class NumDistinct {
    // O(mn) time | O(mn) space
//    public int numDistinct(String s, String t) {
//        int[][] dp = new int[s.length() + 1][t.length() + 1];
//        dp[0][0] = 1;
//        for (int i = 0; i < s.length(); i++) {
//            dp[i+1][0] = 1;
//            for (int j = 0; j <= i && j < t.length(); j++) {
//                if (s.charAt(i) == t.charAt(j)) {
//                    dp[i+1][j+1] = dp[i][j+1] + dp[i][j];
//                } else {
//                    dp[i+1][j+1] = dp[i][j+1];
//                }
//            }
//        }
//        return dp[s.length()][t.length()];
//    }

    // O(mn) time | O(n) space
    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length() + 1];
        if (s.length() > 0) {
            dp[0] = 1;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = Math.min(i, t.length() - 1); j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return dp[t.length()];
    }
}
