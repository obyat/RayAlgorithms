package Sorting.Graphs;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class TopologicalSort {
    private int VertexCount;
    private ArrayList<ArrayList<Integer>> adjList;
    private List<Integer> res;

    private TopologicalSort(int vertexCount) {
        this.VertexCount = vertexCount;
        adjList = new ArrayList<ArrayList<Integer>>(vertexCount);
        res = new ArrayList<>(vertexCount);
        for (int i = 0; i < vertexCount; i++)
            adjList.add(new ArrayList<Integer>());
    }

    public void addEdge(int vertex, int weight) {
        adjList.get(vertex).add(weight);
    }

    public void sort(int vertex, boolean visited[], Stack<Integer> stack) {
        visited[vertex] = true;

        for (int currentVertex : adjList.get(vertex)) {
            if (!visited[currentVertex])
                sort(currentVertex, visited, stack);
        }
        stack.push(vertex);
    }

    public List<Integer> sort() {
        Stack<Integer> stack = new Stack<Integer>();
        boolean visited[] = new boolean[VertexCount];

        for (int i = 0; i < VertexCount; i++) {
            if (!visited[i])
                sort(i, visited, stack);
        }

        while (!stack.isEmpty())
            res.add(stack.pop());

        return res;
    }

    public static void main(String[] args) {
        TopologicalSort topSort = new TopologicalSort(6);
        topSort.addEdge(5, 2);
        topSort.addEdge(5, 0);
        topSort.addEdge(4, 0);
        topSort.addEdge(4, 1);
        topSort.addEdge(2, 3);
        topSort.addEdge(3, 1);

        System.out.println("TopologicalSort: ");
        System.out.println(topSort.sort().toString());

    }
}