package io.dure.coding.graph;

public class FindRedundantConnection {
    // O(n) time
    public int[] findRedundantConnection(int[][] edges) {
        int maxVertex = 0;
        for (int[] edge : edges) {
            maxVertex = Math.max(maxVertex, edge[0]);
            maxVertex = Math.max(maxVertex, edge[1]);
        }
        int[] fathers = new int[maxVertex + 1];
        for (int i = 1; i <= maxVertex; i++) {
            fathers[i] = i;
        }
        for (int[] edge : edges) {
            if (!union(fathers, edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[2];
    }

    private int findFather(int[] fathers, int i) {
        if (fathers[i] != i) {
            fathers[i] = findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }

    private boolean union(int[] fathers, int i, int j) {
        int fahterOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);
        if (fahterOfI != fatherOfJ) {
            fathers[fahterOfI] = fatherOfJ;
            return true;
        }
        return false;
    }
}
