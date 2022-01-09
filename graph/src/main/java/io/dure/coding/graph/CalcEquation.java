package io.dure.coding.graph;

import java.util.*;

public class CalcEquation {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            if (!graph.containsKey(from) || !graph.containsKey(to)) {
                result[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(graph, from, to, visited);
            }
        }
        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String from, String to, Set<String> visited) {
        if (from.equals(to)) {
            return 1.0;
        }
        visited.add(from);
        for (Map.Entry<String, Double> entry : graph.get(from).entrySet()) {
            String next = entry.getKey();
            if (!visited.contains(next)) {
                double nextValue = dfs(graph, next, to, visited);
                if (nextValue > 0) {
                    return entry.getValue() * nextValue;
                }
            }
        }
        visited.remove(from);
        return -1.0;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);
            graph.putIfAbsent(var1, new HashMap<String, Double>());
            graph.get(var1).put(var2, values[i]);

            graph.putIfAbsent(var2, new HashMap<String, Double>());
            graph.get(var2).put(var1, 1.0/values[i]);
        }
        return graph;
    }
}
