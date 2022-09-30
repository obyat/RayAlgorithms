package Chapter4.Graphs.DirectedGrarphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Generic.TESTSUIT;

public class CourseSchedule {
    int[] result;
    List<List<Integer>> adjList;
    boolean[] visited;
    int resIndex;
    boolean[] recStack;

    public int[] findOrder(int numCourses, int[][] preReq) {
        adjList = new ArrayList<>(numCourses + 1);
        result = new int[numCourses];
        visited = new boolean[numCourses];
        recStack = new boolean[numCourses];
        resIndex = 0;

        for (int i = 0; i < numCourses; i++)
            adjList.add(new ArrayList<Integer>());

        for (int i = 0; i < preReq.length; i++)
            adjList.get(preReq[i][0]).add(preReq[i][1]);

        if (isCyclic())
            return new int[] {};

        visited = new boolean[numCourses];
        return sort(preReq, numCourses);
    }

    private boolean isCyclic() {
        for (int i = 0; i < adjList.size(); i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;
        return false;
    }

    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
        if (recStack[i])
            return true;
        if (visited[i])// reaching self node is not a cycle
            return false;
        visited[i] = recStack[i] = true;

        for (Integer index : adjList.get(i))
            if (isCyclicUtil(index, visited, recStack))
                return true;

        recStack[i] = false;
        return false;
    }

    private int[] sort(int[][] preReq, int numCourses) {
        for (int i = 0; i < numCourses; i++)
            if (!visited[i])
                sort(i, preReq);
        return result;
    }

    private void sort(int node, int[][] preReq) {
        visited[node] = true;

        for (int i : adjList.get(node))
            if (!visited[i])
                sort(i, preReq);

        result[resIndex] = node;
        resIndex++;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int[][] test1 = new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int[][] test2 = new int[][] { { 1, 0 }, { 0, 1 } };

        TESTSUIT.assertTest(Arrays.toString(cs.findOrder(4, test1)), "4", Arrays.toString(new int[] { 0, 1, 2, 3 }));
        TESTSUIT.assertTest(Arrays.toString(cs.findOrder(2, test2)), "2", Arrays.toString(new int[] {}));

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
