package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private final T data;
    private boolean visited = false;
    private List<Node<T>> neighbors = new ArrayList<>();

    Node(T data) {
        this.data = data;
    }

    /**
     * @return boolean return the visited
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * @return boolean return the visited
     */
    public T getData() {
        return this.data;
    }

    public String toString() {
        return this.data.toString();
    }

    /**
     * @param visited the visited to set
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * @return List<Node<T>> return the neighbors
     */
    public List<Node<T>> getNeighbors() {
        return neighbors;
    }

    /**
     * @param neighbors the neighbors to set
     */
    public void setNeighbors(List<Node<T>> neighbors) {
        this.neighbors = neighbors;
    }

}
