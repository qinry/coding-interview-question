package io.dure.coding.dynamicprogramming;

public class MinCostClimbingStairs {
    // O(2^n) time
//    public int minCostClimbingStairs(int[] cost) {
//        int len = cost.length;
//        return Math.min(helper(cost, len - 2), helper(cost, len - 1));
//    }
//    private int helper(int[] cost, int i) {
//        if (i < 2) {
//            return cost[i];
//        }
//        return Math.min(helper(cost, i - 2), helper(cost, i - 1)) + cost[i];
//    }

    // O(n) time | O(n) space
//    public int minCostClimbingStairs(int[] cost) {
//        int len = cost.length;
//        int[] dp = new int[len];
//        helper(cost, len - 2, dp);
//        helper(cost, len - 1, dp);
//        return Math.min(dp[len - 2], dp[len - 1]);
//    }
//    private void helper(int[] cost, int i, int[] dp) {
//        if (i < 2) {
//            dp[i] = cost[i];
//        } else if (dp[i] == 0) {
//            helper(cost, i - 2, dp);
//            helper(cost, i - 1, dp);
//            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
//        }
//    }

    // O(n) time | O(n) space
//    public int minCostClimbingStairs(int[] cost) {
//        int len = cost.length;
//        int[] dp = new int[len];
//        dp[0] = cost[0];
//        dp[1] = cost[1];
//
//        for (int i = 2; i < len; i++) {
//            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
//        }
//        return Math.min(dp[len - 2], dp[len - 1]);
//    }

    // O(n) time | O(1) space
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[2];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < len; i++) {
            dp[i % 2] = Math.min(dp[0], dp[1]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }
}
