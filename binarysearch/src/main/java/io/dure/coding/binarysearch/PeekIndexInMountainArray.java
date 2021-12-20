package io.dure.coding.binarysearch;

public class PeekIndexInMountainArray {
    // O(logn) time | O(1) space
    public int peekIndexInMountainArray(int[] nums) {
        int left = 1;
        int right = nums.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            }
            if (nums[mid] > nums[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
