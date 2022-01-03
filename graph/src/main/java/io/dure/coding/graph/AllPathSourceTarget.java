package io.dure.coding.graph;

import java.util.LinkedList;
import java.util.List;

public class AllPathSourceTarget {
    public List<List<Integer>> allPathSourceTarget(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        dfs(0, graph, path, result);
        return result;
    }

    private void dfs(int source, int[][] graph, List<Integer> path, List<List<Integer>> results) {
        path.add(source);

        if (source == graph.length - 1) {
            results.add(new LinkedList<>(path));
        } else {
            for (int next : graph[source]) {
                dfs(next, graph, path, results);
            }
        }
        path.remove(path.size() - 1);
    }
}
