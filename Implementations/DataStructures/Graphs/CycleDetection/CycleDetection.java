package DataStructures.Graphs.CycleDetection;

import java.util.List;

public class CycleDetection<T> {
    public boolean hasCycle(Vertex<T> vertices) {

        vertices.setVisiting(true);

        for (Vertex<T> neighbor : vertices.getNeighbors()) {
            if (neighbor.isVisiting() || !neighbor.isVisited() && hasCycle(neighbor))
                return true;
        }

        vertices.setVisiting(false);
        vertices.setVisited(true);

        return false;
    }

    public boolean hasCycle(List<Vertex<T>> vertices) {
        for (Vertex<T> v : vertices) {
            if (!v.isVisited() && hasCycle(v))
                return true;
        }
        return false;
    }

    public boolean hasCycleUndirected(List<Vertex<T>> vertices) {
        for (Vertex<T> v : vertices) {
            if (!v.isVisited() && hasCycle(null, v))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Vertex<T> caller, Vertex<T> current) {
        current.setVisited(true);
        for (Vertex<T> neighbor : current.getNeighbors()) {
            if (!neighbor.equals(caller) && neighbor.isVisited()
                    || !neighbor.isVisited() && hasCycle(current, neighbor))
                return true;
        }
        return false;
    }
}
