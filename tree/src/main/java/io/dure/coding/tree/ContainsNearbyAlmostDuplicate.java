package io.dure.coding.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {
    // O(nlogk) time | O(k) space
//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        TreeSet<Long> set = new TreeSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            Long lower = set.floor((long)nums[i]);
//            if (lower != null && lower >= (long)nums[i] - t) {
//                return true;
//            }
//            Long higher = set.ceiling((long)nums[i]);
//            if (higher != null && higher <= (long)nums[i] + t) {
//                return true;
//            }
//            set.add((long)nums[i]);
//            if (i >= k) {
//                set.remove((long)nums[i - k]);
//            }
//        }
//        return false;
//    }

    // O(n) time | O(k) space
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Integer> buckets = new HashMap<>();
        int bucketSize = t + 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int id = getBucketID(num, bucketSize);
            if (buckets.containsKey(id)
                || buckets.containsKey(id - 1) && buckets.get(id - 1) + t >= num
                || buckets.containsKey(id + 1) && buckets.get(id + 1) - t <= num) {
                return true;
            }
            buckets.put(id, num);
            if (i >= k) {
                buckets.remove(getBucketID(nums[i - k], bucketSize));
            }
        }
        return false;
    }

    private int getBucketID(int num, int bucketSize) {
        return num >= 0
                ? num /  bucketSize
                : (num + 1) / bucketSize - 1;
    }
}
