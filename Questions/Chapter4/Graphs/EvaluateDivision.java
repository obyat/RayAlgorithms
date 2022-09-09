package Chapter4.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
* @lc app=leetcode id=399 lang=java
*
* [399] Evaluate Division
*/

// @lc code=start
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] ansArray = new double[queries.size()];
        int i = 0;

        for (List<String> query : queries) {
            Set<String> visited = new HashSet<>();
            if (query.get(0).equals(query.get(1))) {
                if (graph.containsKey(query.get(0)))
                    ansArray[i++] = 1.0; // if the query is "a"/"a" and graph contains that
                // variable then put 1;
                else
                    ansArray[i++] = -1.0; // if the query is "a"/"a" and graph does not contain
                // that variable then put
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

    public static void main(String[] args) {
        double[] values = new double[] { 2.0, 3.0 };
        List<String> eq = new ArrayList<String>();
        List<List<String>> equations = new ArrayList<List<String>>();
        List<String> eqList1 = new ArrayList<String>();
        List<String> eqList2 = new ArrayList<String>();

        eqList1.add("a");
        eqList1.add("b");

        eqList2.add("b");
        eqList2.add("c");
        equations.add(eqList1);
        equations.add(eqList2);

        List<List<String>> queries = new ArrayList<List<String>>();
        List<String> qList1 = new ArrayList<String>();
        List<String> qList2 = new ArrayList<String>();
        List<String> qList3 = new ArrayList<String>();
        List<String> qList4 = new ArrayList<String>();
        List<String> qList5 = new ArrayList<String>();

        qList1.add("a");
        qList1.add("c");

        qList2.add("b");
        qList2.add("a");

        qList3.add("a");
        qList3.add("e");

        qList4.add("a");
        qList4.add("a");

        qList5.add("x");
        qList5.add("x");

        queries.add(qList1);
        queries.add(qList2);
        queries.add(qList3);
        queries.add(qList4);
        queries.add(qList5);
        EvaluateDivision solution = new EvaluateDivision();
        double[] ansArray = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(ansArray));
    }
}
// @lc code=end
