package io.dure.coding.graph;

import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix {
    // O(mn) time | O(mn) space
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dists = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    queue.add(new int[]{i,j});
                } else {
                    dists[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int dist = dists[pos[0]][pos[1]];
            for (int[] dir : dirs) {
                int r = dir[0] + pos[0];
                int c = dir[1] + pos[1];
                if (r >= 0 && c >= 0 && r < rows && c < cols) {
                    if (dists[r][c] > dist + 1) {
                        dists[r][c] = dist + 1;
                        queue.add(new int[]{r,c});
                    }
                }
            }
        }
        return dists;
    }
}
