package io.dure.coding.binarysearch;

public class SingleNonDuplicate {

    // O(n) time | O(1) space
//    public int singleNonDuplicate(int[] nums) {
//        int xor = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            xor ^= nums[i];
//        }
//        return xor;
//    }
    // O(logn) time | O(1) space
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2; // 两两分组的中间分组编号
            int i = 2 * mid;
            if (i < nums.length - 1 && nums[i] != nums[i+1]) {
                if (mid == 0 || nums[i - 2] == nums[i - 1]) {
                    return nums[i];
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[nums.length - 1];
    }
}
