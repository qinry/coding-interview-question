package io.dure.coding.dynamicprogramming;

public class MinPathSum {
    // O(mn) time | O(mn) space
//    public int minPathSum(int[][] grid) {
//        int[][] dp = new int[grid.length][grid[0].length];
//        dp[0][0] = grid[0][0];
//        for (int j = 1; j < grid[0].length; j++) {
//            dp[0][j] = dp[0][j-1] + grid[0][j];
//        }
//        for (int i = 1; i < grid.length; i++) {
//            dp[i][0] = dp[i-1][0] + grid[i][0];
//            for (int j = 1; j < grid[0].length; j++) {
//                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
//            }
//        }
//        return dp[grid.length - 1][grid[0].length - 1];
//    }

    // O(mn) time | O(n) space
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int j = 1; j < grid[0].length; j++) {
            dp[j] = dp[j-1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < grid[0].length; j++) {
                dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
            }
        }
        return dp[grid[0].length - 1];
    }
}
