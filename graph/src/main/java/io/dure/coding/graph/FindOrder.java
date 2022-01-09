package io.dure.coding.graph;

import java.util.*;

public class FindOrder {
    // O(m+n) time
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new LinkedList<>());
        }

        int[] inDegrees = new int[numCourses];
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
            inDegrees[prereq[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new LinkedList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order.add(course);
            for (int next : graph.get(course)) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return order.size() == numCourses
                ? order.stream().mapToInt(i -> i).toArray()
                : new int[0];
    }
}
