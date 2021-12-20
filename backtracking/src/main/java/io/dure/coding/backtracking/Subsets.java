package io.dure.coding.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Subsets {
    // O(2^n) time
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        helper(nums, 0, new LinkedList<Integer>(), result);
        return result;
    }

    private void helper(int[] nums, int index, LinkedList<Integer> subset, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new LinkedList<>(new LinkedList<>(subset)));
        } else if (index < nums.length){
            helper(nums, index + 1, subset, result);

            subset.add(nums[index]);
            helper(nums, index + 1, subset, result);
            subset.removeLast();
        }
    }
}
