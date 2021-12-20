package io.dure.coding.array;

public class NumSubArrayProductLessThanK {
    // O(n) time | O(1) space
    public int numSubArrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int product = 1;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k && left <= right) {
                product /= nums[left++];
            }
            count += right >= left ? right - left + 1 : 0;
        }
        return count;
    }
}
