package io.dure.coding.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LenLongestFibSubseq {
    // O(n^2) time | O(n^2) space
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int[][] dp = new int[arr.length][arr.length];
        int result = 2;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; i++) {
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                dp[i][j] = k >= 0 && k < j ? dp[j][k] + 1 : 2;
                result = Math.max(result, dp[i][j]);
            }
        }
        return result > 2 ? result : 0;
    }
}
