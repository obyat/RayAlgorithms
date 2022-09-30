import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 */

// @lc code=start
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] ansArray = new double[queries.size()];
        int i = 0;

        for (List<String> query : queries) {
            Set<String> visited = new HashSet<>();
            if (query.get(0).equals(query.get(1))) {
                if (graph.containsKey(query.get(0)))
                    ansArray[i++] = 1.0; // if the query is "a"/"a" and graph contains that variable then put 1;
                else
                    ansArray[i++] = -1.0; // if the query is "a"/"a" and graph does not contain that variable then put
                                          // -1;
            } else {
                double res = dfs(query.get(0), query.get(1), graph, visited);
                ansArray[i] = res;
                i++;
            }
        }

        return ansArray;
    }

    private double dfs(String a, String b, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (!graph.containsKey(a))
            return -1.0;

        if (graph.get(a).containsKey(b))
            return graph.get(a).get(b);

        visited.add(a);

        Map<String, Double> startMap = graph.get(a);
        for (Map.Entry<String, Double> node : startMap.entrySet()) {
            if (!visited.contains(node.getKey())) {
                double currVal = dfs(node.getKey(), b, graph, visited);
                if (currVal != -1.0) {
                    return currVal * node.getValue();
                }
            }
        }
        return -1.0;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        // source, <end,val>
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int i = 0;
        for (List<String> equation : equations) {
            String sourceNode = equation.get(0); // "a"
            String targetNode = equation.get(1); // "b"
            double val = values[i];
            i++;
            // first direction
            graph.putIfAbsent(sourceNode, new HashMap<>());
            graph.get(sourceNode).put(targetNode, val);

            // second direction
            graph.putIfAbsent(targetNode, new HashMap<>());
            graph.get(targetNode).put(sourceNode, (1 / val));
        }
        return graph;
    }

}
// @lc code=end
