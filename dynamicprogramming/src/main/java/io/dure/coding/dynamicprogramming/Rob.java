package io.dure.coding.dynamicprogramming;

import java.util.Arrays;

public class Rob {
    // O(n) time | O(n) space
//    public int rob(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, -1);
//
//        helper(nums, nums.length - 1, dp);
//        return dp[nums.length - 1];
//    }
//
//    private void helper(int[] nums, int i, int[] dp) {
//        if (i == 0) {
//            dp[i] = nums[0];
//        }  else if (i == 1) {
//            dp[i] = Math.max(nums[0], nums[1]);
//        } else if (dp[i] < 0) {
//            helper(nums, i - 2, dp);
//            helper(nums, i - 1, dp);
//            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
//        }
//    }

    // O(n) time | O(n) space
//    public int rob(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        if (nums.length > 1) {
//            dp[1] = Math.max(nums[0], nums[1]);
//        }
//        for (int i = 2; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//        }
//        return dp[nums.length - 1];
//    }

    // O(n) time | O(1) space
//    public int rob(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int[] dp = new int[2];
//        dp[0] = nums[0];
//        if (nums.length > 1) {
//            dp[1] = Math.max(nums[0], nums[1]);
//        }
//        for (int i = 2; i < nums.length; i++) {
//            dp[i] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i]);
//        }
//        return dp[(nums.length - 1) % 2];
//    }

    // O(n) time | O(1) space
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[][] dp = new int[2][2];

        dp[0][0] = 0;
        dp[1][0] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[0][i % 2] = Math.max(dp[0][(i - 1) % 2], dp[1][(i - 1) % 2]);
            dp[1][i % 2] = nums[i] + dp[0][(i - 1) % 2];
        }
        return Math.max(dp[0][(len - 1) % 2], dp[1][(len - 1) % 2]);
    }
}
