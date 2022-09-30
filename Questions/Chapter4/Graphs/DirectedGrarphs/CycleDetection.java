package Chapter4.Graphs.DirectedGrarphs;

// A Java Program to detect cycle in a graph
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CycleDetection {

    private final int V;
    private final List<List<Integer>> adj;
    boolean[] visited;
    boolean[] recStack;

    public CycleDetection(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
        visited = new boolean[V];
        recStack = new boolean[V];

    }

    private void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    /*
     * -----------------------------------------------------------------------------
     */

    private boolean isCyclic() {
        System.out.println(adj.toString());

        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;
        return false;
    }

    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
        if (recStack[i])
            return true;
        if (visited[i])// reaching yourself is not a cycle
            return false;
        visited[i] = recStack[i] = true;

        for (Integer index : adj.get(i))
            if (isCyclicUtil(index, visited, recStack))
                return true;

        recStack[i] = false;
        return false;
    }

    /*
     * -----------------------------------------------------------------------------
     */
    public static void main(String[] args) {
        CycleDetection graph = new CycleDetection(4);
        graph.addEdge(1, 0);
        graph.addEdge(2, 0);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        System.out.println("Graph contains cycle? " + graph.isCyclic() + "\n");

        graph = new CycleDetection(2);
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
        System.out.println("Graph contains cycle? " + graph.isCyclic() + "\n");

        graph = new CycleDetection(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 1);
        System.out.println("Graph contains cycle? " + graph.isCyclic() + "\n");
    }
}

// This code is contributed by Sagar Shah.
