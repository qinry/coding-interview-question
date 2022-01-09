package io.dure.coding.graph;

public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] lengths = new int[matrix.length][matrix[0].length];
        int longest = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int length = dfs(matrix, lengths, i, j);
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    private int dfs(int[][] matrix, int[][] lengths, int i, int j) {
        if (lengths[i][j] != 0) {
            return lengths[i][j];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int length = 1;
        for (int[] dir : dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;
            if (r >= 0 && c >= 0 && r < rows && c < cols
                    && matrix[r][c] > matrix[i][j]) {
                int path = dfs(matrix, lengths, r, c);
                length = Math.max(path + 1, length);
            }
        }
        lengths[i][j] = length;
        return length;
    }
}
