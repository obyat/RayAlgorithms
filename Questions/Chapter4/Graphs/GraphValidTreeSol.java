package Chapter4.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphValidTreeSol {
    private List<List<Integer>> adjList = new ArrayList<>();
    private Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        if (n == 0)
            return true;
        if (edges.length != n - 1)
            return false;

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        return dfs(0) && visited.size() == n;
    }

    public boolean dfs(int node) {
        if (visited.contains(node))
            return false;
        visited.add(node);
        for (int a : adjList.get(node))
            dfs(a);

        return true;
    }

    public static void main(String[] args) {
        GraphValidTreeSol graphValidTreeSol = new GraphValidTreeSol();
        boolean a = graphValidTreeSol.validTree(5, new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } });
        System.out.println(a);
    }
}
