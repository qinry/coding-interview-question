package io.dure.coding.backtracking;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        helper(candidates, target, 0, combination, result);
        return result;
    }
    private void helper(int[] candidates, int target, int i, LinkedList<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<Integer>(combination));
        } else if (target > 0 && i < candidates.length) {
            helper(candidates, target, i + 1, combination, result);

            combination.add(candidates[i]);
            helper(candidates, target - candidates[i], i, combination, result);
            combination.removeLast();
        }
    }
}
