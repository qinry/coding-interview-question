package io.dure.coding.dynamicprogramming;

import java.util.List;

public class MinimumTotal {
    // O(mn) time | O(mn) space
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int size = triangle.size();
//        int[][] dp = new int[size][size];
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j <= i; j++) {
//                dp[i][j] = triangle.get(i).get(j);
//                if (i > 0 && j == 0) {
//                    dp[i][j] += dp[i-1][j];
//                } else if (i > 0 && i == j) {
//                    dp[i][j] += dp[i-1][j-1];
//                } else if (i > 0) {
//                    dp[i][j] += Math.min(dp[i-1][j], dp[i-1][j-1]);
//                }
//            }
//        }
//        int min = Integer.MAX_VALUE;
//        for (int num : dp[size-1]) {
//            min = Math.min(min, num);
//        }
//        return min;
//    }

    // O(mn) time | O(n) space
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for (List<Integer> row : triangle) {
            for (int j = row.size() - 1; j >= 0; j--) {
                if (j == 0) {
                    dp[j] += row.get(j);
                } else if (j == row.size() - 1) {
                    dp[j] = dp[j-1] + row.get(j);
                } else {
                    dp[j] = Math.min(dp[j-1], dp[j]) + row.get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp) {
            min = Math.min(min, num);
        }
        return min;
    }
}
