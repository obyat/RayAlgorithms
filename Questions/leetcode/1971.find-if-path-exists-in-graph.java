
/*
 * @lc app=leetcode id=1971 lang=java
 *
 * [1971] Find if Path Exists in Graph
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// @lc code=start
class Solution {
    // bi-directional bfs
    private List<List<Integer>> adjList = new ArrayList<>();
    private Set<Integer> sVisited = new HashSet<>();
    private Set<Integer> dVisited = new HashSet<>();

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0)
            return true;
        if (edges.length == 1)
            return true;

        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        // System.out.println(Arrays.deepToString(adjList.toArray()));
        return findPath(adjList, source, destination);
    }

    public boolean findPath(List<List<Integer>> adjList, int source, int destination) {
        Queue<Integer> destQueue = new LinkedList<Integer>();
        Queue<Integer> sourceQueue = new LinkedList<Integer>();

        sVisited.add(source);
        dVisited.add(destination);
        sourceQueue.add(source);
        destQueue.add(destination);

        for (int i : adjList.get(source))
            if (!sVisited.contains(i)) {

                sourceQueue.add(i);
                sVisited.add(i);
            }
        // Arrays.deepToString(sourceQueue.toArray()));

        for (int j : adjList.get(destination))
            if (!dVisited.contains(j)) {
                destQueue.add(j);
                dVisited.add(j);
            }
        sourceQueue.remove();
        destQueue.remove();

        while (!sourceQueue.isEmpty() && !destQueue.isEmpty()) {
            if (dVisited.contains(sourceQueue.peek()) || sVisited.contains(destQueue.peek()))
                return true;
            // System.out.println("s.r:" + sourceQueueremove());
            for (int i : adjList.get(sourceQueue.poll()))
                if (!sVisited.contains(i)) {
                    sourceQueue.add(i);
                    sVisited.add(i);
                }
            // Arrays.deepToString(sourceQueue.toArray()));

            // System.out.println("full sQ: " + Arrays.deepToString(sourceQueue.toArray()));
            for (int j : adjList.get(destQueue.poll()))
                if (!dVisited.contains(j)) {
                    destQueue.add(j);
                    dVisited.add(j);
                }

        }

        return false;
    }
}
// @lc code=end
