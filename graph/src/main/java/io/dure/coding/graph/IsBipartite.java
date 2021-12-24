package io.dure.coding.graph;

import java.util.LinkedList;
import java.util.Queue;

public class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1) {
                if (!setColor(graph, colors, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    // O(v+e) time | O(v) space
//    private boolean setColor(int[][] graph, int[] colors, int i, int color) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(i);
//        colors[i] = color;
//
//        while (!queue.isEmpty()) {
//            int v = queue.poll();
//            for (int neighbor : graph[v]) {
//                if (colors[neighbor] >= 0) {
//                    if (colors[v] == colors[neighbor]) {
//                        return false;
//                    }
//                } else {
//                    queue.offer(neighbor);
//                    colors[neighbor] = 1 - colors[v];
//                }
//            }
//        }
//        return true;
//    }

    // O(v+e) time | O(v+e) space
    private boolean setColor(int[][] graph, int[] colors, int i, int color) {
        if (colors[i] >= 0) {
            return colors[i] == color;
        }

        colors[i] = color;
        for (int neighbor : graph[i]) {
            if (!setColor(graph, colors, neighbor, 1-color)) {
                return false;
            }
        }
        return true;
    }
}
