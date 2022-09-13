package DataStructures.Graphs.FordFulkerson;

import java.util.HashMap;
import java.util.Map;

public class Vertex<T> {
    private final T data;

    public Vertex(T data) {
        this.data = data;
    }

    private boolean visited;

    public T getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    private Map<Vertex<T>, Integer> neighbors = new HashMap<>();

    public void setNeighbors(Map<Vertex<T>, Integer> neighbors) {
        this.neighbors = neighbors;
    }

    public Map<Vertex<T>, Integer> getNeighbors() {
        return neighbors;
    }
}
