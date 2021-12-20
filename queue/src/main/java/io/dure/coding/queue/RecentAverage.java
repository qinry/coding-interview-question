package io.dure.coding.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RecentAverage {
    private int windowSize;
    private Queue<Integer> times;
    public RecentAverage() {
        times = new LinkedList<>();
        windowSize = 3000;
    }

    public int ping(int t) {
        times.offer(t);
        while (times.peek() + windowSize < t) {
            times.poll();
        }
        return times.size();
    }

}
