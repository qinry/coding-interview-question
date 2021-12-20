package io.dure.coding.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private Queue<Integer> queue;
    private int capacity;
    private int sum;
    public MovingAverage(int size) {
        this.capacity = size;
        this.queue = new LinkedList<>();
    }

    // O(1) time | O(1) space
    public double next(int val) {
        queue.offer(val);
        sum += val;
        if (queue.size() > capacity) {
            sum -= queue.poll();
        }
        return (double)sum / queue.size();
    }

}
