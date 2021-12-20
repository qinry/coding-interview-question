package io.dure.coding.binarysearch;

import java.util.Random;

public class PickIndex {
    int total;
    int[] sums;
    public PickIndex(int[] w) {
        sums = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            sums[i] = total;
        }
    }

    // O(logn) time | O(1) space
    public int pickIndex() {
        Random rand = new Random();
        int p = rand.nextInt(total);
        int left = 0;
        int right = sums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sums[mid] > p) {
                if (mid == 0 || sums[mid - 1] <= p) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
