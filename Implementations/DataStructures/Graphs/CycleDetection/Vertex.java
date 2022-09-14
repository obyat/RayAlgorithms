package DataStructures.Graphs.CycleDetection;

import java.util.HashSet;
import java.util.Set;

public class Vertex<T> {
    private final T data;
    private boolean visited;
    private boolean visiting;

    Vertex(T data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisiting() {
        return visiting;
    }

    public void setVisiting(boolean visiting) {
        this.visiting = visiting;
    }

    private Set<Vertex<T>> neighbors = new HashSet<>();

    public void addNeighbor(Vertex<T> vertex) {
        neighbors.add(vertex);
    }

    public Set<Vertex<T>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Set<Vertex<T>> neighbors) {
        this.neighbors = neighbors;
    }

}
