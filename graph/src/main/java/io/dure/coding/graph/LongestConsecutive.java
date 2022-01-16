package io.dure.coding.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutive {
    // O(n) time
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> fathers = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        Set<Integer> all = new HashSet<>();
        for (int num : nums) {
            fathers.put(num, num);
            counts.put(num, 1);
            all.add(num);
        }

        for (int num : all) {
            if (all.contains(num + 1)) {
                union(fathers, counts, num, num + 1);
            }
            if (all.contains(num - 1)) {
                union(fathers, counts, num, num - 1);
            }
        }

        int longest = 0;
        for (int length : counts.values()) {
            longest = Math.max(longest, length);
        }
        return longest;
    }

    private int findFather(Map<Integer, Integer> fathers, int i) {
        if (fathers.get(i) != i) {
            fathers.put(i, findFather(fathers, fathers.get(i)));
        }
        return fathers.get(i);
    }

    private void union(Map<Integer, Integer> fathers, Map<Integer, Integer> counts, int i, int j) {
        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);

        if (fatherOfI != fatherOfJ) {
            fathers.put(fatherOfI, fatherOfJ);
            int countOfI = counts.get(fatherOfI);
            int countOfJ = counts.get(fatherOfJ);
            counts.put(fatherOfJ, countOfI + countOfJ);
        }
    }
}
