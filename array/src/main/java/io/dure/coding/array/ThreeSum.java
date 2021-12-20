package io.dure.coding.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    // O(n^2) time | O(1) space
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length >= 3) {
            Arrays.sort(nums);
        }
        int i = 0;
        while (i < nums.length - 2) {
            twoSum(nums, i, results);
            int temp = nums[i];
            while (i < nums.length && temp == nums[i]) {
                i++;
            }
        }
        return results;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> results) {
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                int temp = nums[j];
                while (j < k && temp == nums[j]) {
                    j++;
                }
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                j++;
            } else {
                k--;
            }
        }
    }
}
