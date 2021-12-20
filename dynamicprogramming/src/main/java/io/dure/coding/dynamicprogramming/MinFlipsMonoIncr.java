package io.dure.coding.dynamicprogramming;

public class MinFlipsMonoIncr {
    // O(n) time | O(1) space
    public int minFlipsMonoIncr(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[2][2];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[1][0] = s.charAt(0) == '1' ? 0 : 1;

        for (int i = 1; i < len; i++) {
            char ch = s.charAt(i);
            int prev0 = dp[0][(i - 1) % 2];
            int prev1 = dp[1][(i - 1) % 2];
            dp[0][i%2] = prev0 + (ch == '0' ? 0 : 1);
            dp[1][i%2] = Math.min(prev0, prev1) + (ch == '1' ? 0 : 1);
        }

        return Math.min(dp[0][(len - 1) % 2], dp[1][(len - 1) % 2]);
    }
}
