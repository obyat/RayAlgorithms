package Sorting.Graphs;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

//Runtime: Time: O(V+E). DFS with stack. Space: O(V).The extra space is needed for the stack. 

public class TopologicalSort {
    private int VertexCount;
    private ArrayList<ArrayList<Integer>> adjList;

    private TopologicalSort(int vertexCount) {
        this.VertexCount = vertexCount;
        adjList = new ArrayList<ArrayList<Integer>>(vertexCount);
        System.out.println("size: " + adjList.size());
        for (int i = 0; i < vertexCount; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        System.out.println("size: " + adjList.size());

    }

    public void addEdge(int vertex, int neighbor) {
        adjList.get(vertex).add(neighbor);
        System.out.println("adjList: " + adjList.toString());
    }

    public List<Integer> sort() {
        Stack<Integer> stack = new Stack<Integer>();
        boolean visited[] = new boolean[VertexCount];

        for (int i = 0; i < VertexCount; i++)
            if (!visited[i])
                sort(i, visited, stack);

        System.out.println("Vertex " + stack.peek());

        return stack;
    }

    public void sort(int vertex, boolean visited[], Stack<Integer> stack) {
        visited[vertex] = true;
        System.err.println("visiting vertex " + vertex);
        System.out.println("adjList " + adjList.get(vertex));

        for (int currentVertex : adjList.get(vertex)) {
            System.out.println("curr " + currentVertex);
            if (!visited[currentVertex])
                sort(currentVertex, visited, stack);
        }
        System.err.println("pushing vertex " + vertex);
        stack.push(vertex);
    }

    public static void main(String[] args) {
        TopologicalSort topSort = new TopologicalSort(2);
        // topSort.addEdge(5, 2);
        // topSort.addEdge(5, 6);
        // topSort.addEdge(5, 0);
        // topSort.addEdge(4, 0);
        // topSort.addEdge(4, 1);
        // topSort.addEdge(2, 3);
        // topSort.addEdge(3, 1);

        topSort.addEdge(1, 0);

        System.out.println("TopologicalSort: ");
        System.out.println(topSort.sort().toString()); // 5, 4, 2, 3, 1, 0

    }
}