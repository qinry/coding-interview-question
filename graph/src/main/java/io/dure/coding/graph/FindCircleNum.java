package io.dure.coding.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FindCircleNum {
    // O(n^2) time
    public int findCircleNum(int[][] isConnected) {
        int count = isConnected.length;
        int[] fathers = new int[isConnected.length];
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i+1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && union(fathers, i, j)) {
                    count--;
                }
            }
        }
        return count;
    }

    private int findFather(int[] fathers, int i) {
        if (fathers[i] != i) {
            // 路径压缩
            fathers[i] = findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }

    private boolean union(int[] fathers, int i, int j) {
        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);

        if (fatherOfI != fatherOfJ) {
            fathers[fatherOfI] = fatherOfJ;
            return true;
        }
        return false;
    }

    // O(n^2) time
//    public int findCircleNum(int[][] isConnected) {
//        boolean[] visited = new boolean[isConnected.length];
//        int result = 0;
//        for (int v = 0; v < isConnected.length; v++) {
//            if (!visited[v]) {
//                findCircle(visited, isConnected, v);
//                result++;
//            }
//        }
//        return result;
//    }

    // 广度优先搜索
//    private void findCircle(boolean[] visited, int[][] isConnected, int v) {
//        Queue<Integer> queue = new LinkedList<>();
//        visited[v] = true;
//        queue.offer(v);
//        while (!queue.isEmpty()) {
//            int t = queue.poll();
//            for (int friend = 0; friend < isConnected.length; friend++) {
//                if (isConnected[t][friend] == 1 && !visited[friend]) {
//                    queue.offer(friend);
//                    visited[friend] = true;
//                }
//            }
//        }
//    }

    // 深度优先搜索
//    private void findCircle(boolean[] visited, int[][] isConnected, int v) {
//        if (visited[v]) {
//            return;
//        }
//        visited[v] = true;
//        for (int friend = 0; friend < isConnected.length; friend++) {
//            if (isConnected[v][friend] == 1 && !visited[friend]) {
//                findCircle(visited, isConnected, friend);
//            }
//        }
//    }

//    private void findCircle(boolean[] visited, int[][] isConnected, int v) {
//        Stack<Integer> stack = new Stack<>();
//        visited[v] = true;
//        stack.push(v);
//        while (!stack.isEmpty()) {
//            int t = stack.pop();
//            for (int friend = 0; friend < isConnected.length; friend++) {
//                if (isConnected[t][friend] == 1 && !visited[friend]) {
//                    stack.push(friend);
//                    visited[friend] = true;
//                }
//            }
//        }
//    }
}
