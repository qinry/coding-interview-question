package io.dure.coding.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    HashMap<Integer, Integer> numToLocation;
    ArrayList<Integer> nums;

    public RandomizedSet() {
        numToLocation = new HashMap<>();
        nums = new ArrayList<>();
    }
    // O(1) time | O(1) space
    public boolean insert(int val) {
        if (numToLocation.containsKey(val)) {
            return false;
        }
        numToLocation.put(val, nums.size());
        nums.add(val);
        return true;
    }
    // O(1) time | O(1) space
    public boolean remove(int val) {
        if (!numToLocation.containsKey(val)) {
            return false;
        }
        int location = numToLocation.get(val);
        numToLocation.put(nums.get(nums.size() - 1), location);
        numToLocation.remove(val);
        nums.set(location, nums.get(nums.size() - 1));
        nums.remove(nums.size() - 1);
        return true;
    }
    public int getRandom() {
        Random rand = new Random();
        int r = rand.nextInt(nums.size());
        return nums.get(r);
    }
}
