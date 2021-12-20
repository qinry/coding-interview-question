package io.dure.coding.dynamicprogramming;

public class Rob2 {
    // O(n) time | O(1) space
    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int result1 = helper(nums, 0, nums.length - 2);
        int result2 = helper(nums, 1, nums.length - 1);
        return Math.max(result1, result2);
    }

    private int helper(int[] nums, int start, int end) {
        int[] dp = new int[2];
        dp[0] = nums[start];
        if (start < end) {
            dp[1] = Math.max(nums[start], nums[start + 1]);
        }
        for (int i = start + 2; i <= end; i++) {
            int j = i - start;
            dp[j%2] = Math.max(dp[(j - 1) % 2], dp[(j - 2) % 2] + nums[i]);
        }
        return dp[(end - start) % 2];
    }
}
