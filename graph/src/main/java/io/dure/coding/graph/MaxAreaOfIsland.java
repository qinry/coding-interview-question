package io.dure.coding.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = getArea(grid, visited, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    // O(mn) time | O(mn) space
//    private int getArea(int[][] grid, boolean[][] visited, int i, int j) {
//        visited[i][j] = true;
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{i,j});
//        int[][] dirs = { {-1,0}, {1,0}, {0,-1}, {0, 1} };
//        int area = 0;
//        while (!queue.isEmpty()) {
//            int[] pos = queue.poll();
//            area++;
//            for (int[] dir : dirs) {
//                int r = pos[0] + dir[0];
//                int c = pos[1] + dir[1];
//                if (r >= 0 && r < grid.length
//                        && c >= 0 && c < grid[0].length
//                        && grid[r][c] == 1 && !visited[r][c]) {
//                    queue.add(new int[]{r, c});
//                    visited[r][c] = true;
//                }
//            }
//        }
//        return area;
//    }
    // O(mn) time | O(mn) space
//    private int getArea(int[][] grid, boolean[][] visited, int i, int j) {
//        visited[i][j] = true;
//        int[][] dirs = { {-1,0}, {1,0}, {0,-1}, {0, 1} };
//        Stack<int[]> stack = new Stack<>();
//        stack.push(new int[]{i,j});
//        int area = 0;
//        while (!stack.isEmpty()) {
//            int[] pos = stack.pop();
//            area++;
//            for (int[] dir : dirs) {
//                int r = pos[0] + dir[0];
//                int c = pos[1] + dir[1];
//                if (r >= 0 && r < grid.length
//                        && c >= 0 && c < grid[0].length
//                        && grid[r][c] == 1 && !visited[r][c]) {
//                    stack.push(new int[]{r, c});
//                    visited[r][c] = true;
//                }
//            }
//        }
//        return area;
//    }
    // O(mn) time | O(mn) space
    private int getArea(int[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        int[][] dirs = { {-1,0}, {1,0}, {0,-1}, {0, 1} };

        int area = 1;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r < grid.length
                    && c >= 0 && c < grid[0].length
                    && grid[r][c] == 1 && !visited[r][c]) {
                area += getArea(grid, visited, r, c);
            }
        }
        return area;
    }
}
