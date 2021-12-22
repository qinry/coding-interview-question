package io.dure.coding.dynamicprogramming;

public class PermutationSum {
    // O(nt) time | O(t) space
    public int permutationSum(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
