package DataStructures.Graphs.Kruskal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Vertex<T> {
    private final T data;
    private boolean visited;
    private Set<Vertex<T>> neighbors = new HashSet<Vertex<T>>();

    public Set<Vertex<T>> getNeighbors() {
        return neighbors;
    }

    public void addNeighbors(List<Vertex<T>> vertices) {
        for (Vertex<T> vertex : vertices)
            neighbors.add(vertex);
    }

    public void addNeighbor(Vertex<T> vertex) {
        neighbors.add(vertex);
    }

    public void setNeighbors(Set<Vertex<T>> neighbors) {
        this.neighbors = neighbors;
    }

    public Vertex(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

}
