package io.dure.coding.array;

public class MinSubArrayLen {
    // O(n) time | O(1) space
    public int  minSubArrayLen(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= k && left <= right) {
                minLength = Math.min(right-left+1, minLength);
                sum -= nums[left++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
