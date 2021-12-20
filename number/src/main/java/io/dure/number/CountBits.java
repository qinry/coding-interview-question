package io.dure.number;

public class CountBits {
    // O(nk) time | O(n) space
//    public int[] countBits(int num) {
//        int[] result = new int[num + 1];
//        for (int i = 0; i <= num; i++) {
//            int j = i;
//            while (j != 0) {
//                result[i]++;
//                j = j & (j - 1);
//            }
//        }
//        return result;
//    }

    // O(n) time | O(n) space
//    public int[] countBits(int num) {
//        int[] result = new int[num + 1];
//        for (int i = 1; i <= num; i++) {
//            result[i] = result[i & (i - 1)] + 1;
//        }
//        return result;
//    }
    // O(n) time | O(n) space
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
