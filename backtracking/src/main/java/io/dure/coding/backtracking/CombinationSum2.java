package io.dure.coding.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    // O(2^n) time
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        helper(candidates, target, 0, combination, result);
        return result;
    }

    private void helper(int[] candidates,
                        int target, int i,
                        LinkedList<Integer> combination,
                        List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<Integer>(combination));
        } else if (target > 0 && i < candidates.length) {
            helper(candidates, target, getNext(candidates, i), combination, result);

            combination.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, combination, result);
            combination.removeLast();
        }
    }

    private int getNext(int[] candidates, int idx) {
        int next = idx;
        while (next < candidates.length && candidates[next] == candidates[idx]) {
            next++;
        }
        return next;
    }
}
