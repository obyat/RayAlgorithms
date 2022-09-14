package DataStructures.Graphs.CycleDetection;

import java.util.List;

public class CycleDetection<T> {
    public boolean hasCycle(Vertex<T> source) {

        source.setVisiting(true);

        for (Vertex<T> neighbor : source.getNeighbors()) {
            if (neighbor.isVisiting() || !neighbor.isVisited() && hasCycle(neighbor))
                return true;
        }

        source.setVisiting(false);
        source.setVisited(true);

        return false;
    }

    public boolean hasCycle(List<Vertex<T>> vertices) {
        for (Vertex v : vertices) {
            if (!v.isVisited() && hasCycle(v))
                return true;
        }
        return false;
    }

    public boolean hasCycleUndirected(List<Vertex<T>> vertices) {
        for (Vertex v : vertices) {
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
