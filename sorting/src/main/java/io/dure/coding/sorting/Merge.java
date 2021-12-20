package io.dure.coding.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
    // O(nlogn) time
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);
        List<int[]> merged = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int[] temp = new int[]{ intervals[i][0], intervals[i][1]};
            int j = 1;
            while (j < intervals.length && intervals[j][0] <= temp[1]) {
                temp[1] = Math.max(temp[1], intervals[j][1]);
                j++;
            }
            merged.add(temp);
            i = j;
        }
        int[][] results = new int[merged.size()][];
        return merged.toArray(results);
    }
}
