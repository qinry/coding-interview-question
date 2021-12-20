package io.dure.coding.binarysearch;

public class MinEatingSpeed {
    // O(mlogn) time | O(1) space
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }

        int left = 1;
        int right = max;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (getHours(piles, mid) <= h) {
                if (mid == 1 || getHours(piles, mid - 1) > h) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    // O(m) time | O(1) space
    private int getHours(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
        }
        return hours;
    }
}
