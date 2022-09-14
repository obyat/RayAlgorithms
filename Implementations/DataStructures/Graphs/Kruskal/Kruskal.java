package DataStructures.Graphs.Kruskal;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.HashSet;
import DataStructures.Graphs.CycleDetection.CycleDetection;

public class Kruskal<T> {
    private final PriorityQueue<Edge<T>> graph;
    private final List<Vertex<T>> vertices;
    private final int vertexCount;

    public Kruskal(List<Edge<T>> graph) {
        this.graph = new PriorityQueue<>(graph);
        vertices = getVerticesInGraph(graph);
        vertexCount = vertices.size();

    }

    public void run() {
        List<Edge<T>> spanningTree = new ArrayList<>();
        Edge<T> edge = graph.poll();
        resetTree(Stream.concat(spanningTree.stream(), Stream.of(edge)).collect(Collectors.toList()));
        if (!new CycleDetection<T>().hasCycle(vertices)) {
            spanningTree.add(edge);
        }
        while (spanningTree.size() < vertexCount - 1)
            ;
        printTreeInf(spanningTree);
    }

    private void printTreeInf(List<Edge<T>> spanningTree) {
        Integer min = spanningTree.stream().map(Edge::getWeight).reduce(0, Integer::sum);
        spanningTree.forEach(a -> System.out.println(a));
        System.out.println("Min Weight: " + min);
    }

    private void resetTree(List<Edge<T>> spanningTree) {
        vertices.forEach(vertex -> {
            vertex.setVisited(false);
            vertex.setNeighbors(new HashSet<>());
        });
        spanningTree.forEach(edge -> {
            edge.getSource().addNeighbor(edge.getDestination());
            edge.getSource().addNeighbor(edge.getSource());
        });
    }

    private List<Vertex<T>> getVerticesInGraph(List<Edge<T>> edges) {
        return Stream.concat(edges.stream().map(Edge::getSource), edges.stream().map(Edge::getDestination)).distinct()
                .collect(Collectors.toList());
    }

}
