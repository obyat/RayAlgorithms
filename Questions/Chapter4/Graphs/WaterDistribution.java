package Chapter4.Graphs;

import Generic.TESTSUIT;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

import DataStructures.Graphs.DisjointSets.Unionfind;

public class WaterDistribution {

    /*
     * leetcode 1168 optimize water distribution in a village
     * There are n houses in a viallage. We want to supply water for all the houses
     * by building wells and laying pipes. For eacrh house i, we can either build a
     * well inside it directly with cost wells[i], or pipe in water from a nother
     * well to it. The costs to lay pipes between houses are given by the array
     * pipes, wehre each pipes[i] = [house1, house2, cost] represents the cost to
     * connect house1 and house2 together using a pipe. Connections are
     * bidirectional. Find the minimum total cost to asupply water to all houes.
     * 
     */

    // Runtime:
    public static int minCost(int n, int[] wells, int[][] pipes) {
        Unionfind uf = new Unionfind(n + 1); // each house is its own parent

        HashMap<Integer, Integer> cost = new HashMap<>();
        // each house is initialized with its own cost of building a well
        for (int i = 1; i <= wells.length; i++) {
            cost.put(i, wells[i - 1]);
        }
        Arrays.sort(pipes, Comparator.comparingInt((int[] a) -> a[2]));

        int totalCost = 0;
        for (int[] pipe : pipes) {
            int houseA = pipe[0];
            int houseB = pipe[1];
            int buildingCost = pipe[2];

            if (!uf.connected(houseA, houseB)) {
                // take the miminum path from either house to source
                int minWellCost = Math.min(uf.find(houseA), cost.get(uf.find(houseB)));
                int costOfSeparateWell = cost.get(uf.find(houseA)) + cost.get(uf.find(houseB));

                if (costOfSeparateWell > (minWellCost + buildingCost)) {
                    uf.union(houseA, houseB);
                    cost.put(uf.find(houseA), minWellCost);
                    totalCost += buildingCost;
                }
            }

        }

        HashSet<Integer> visited = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (!visited.contains(uf.find(i))) {
                visited.add(i);
                totalCost += cost.get(uf.find(i));
            }
        }

        return totalCost;

    }

    public static void main(String[] args) {
        TESTSUIT.assertTest(minCost(3, new int[] { 1, 2, 2 }, new int[][] { { 1, 2, 1 }, { 2, 3, 1 } }), "3 houses", 3);

    }

    public static void print(Object o) {
        System.out.println(o.toString());
    }
}
/*
 * Questions:
 * 1.
 * 
 * Ideas:
 * 1.
 * 
 * Edge Cases:
 * 1.
 * 
 * Pros vs. Cons in solutons:
 * 1.
 * 
 * Learned: Different solution, ideas:
 * 1.
 * 
 * Mistakes:
 * 1.
 */
