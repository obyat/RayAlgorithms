package DataStructures.Graphs.FordFulkerson;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Comparator;

public class FordFulkerson<T> {
    private final List<List<Vertex<T>>> paths = new ArrayList<>();

    public int run(Vertex<T> source, Vertex<T> destination) {

        findAllPaths(source, destination, singleton(source));
        AtomicInteger maxFlow = new AtomicInteger();
        paths.stream().sorted(Comparator.comparingInt(this::getMinFlowInpath).reversed())
                .forEach(path -> {
                    Integer min = getMinFlowInpath(path);
                    IntStream.range(0, path.size() - 1)
                            .forEach(vertexId -> removeMinFlowFromPath(path, min, vertexId));
                    maxFlow.addAndGet(min);
                });
        return maxFlow.get();

    }

    private void removeMinFlowFromPath(List<Vertex<T>> path, Integer min, int vertexId) {
        path.get(vertexId).getNeighbors().put(path.get(vertexId + 1), getNeighborEdgeWeight(path, vertexId) - min);
    }

    private void findAllPaths(Vertex<T> current, Vertex<T> destination, List<Vertex<T>> currentPath) {
        if (current.equals(destination)) {
            paths.add(new ArrayList<>(currentPath));
            return;
        }
        current.setVisited(true);
        current.getNeighbors().keySet().stream().filter(neighbor -> !neighbor.isVisited()).forEach(neighbor -> {
            currentPath.add(neighbor);
            findAllPaths(neighbor, destination, currentPath); // current deep recursion for each unvisited neighbor
            currentPath.remove(neighbor); // remove current neighbor from traversal tree (in order to backtrack recurse
                                          // neighbors of last visited neighbor)
        });
        current.setVisited(false); // after visiting all neighbors of current node, set it to unvisited so other
                                   // nodes can traverse through it
    }

    private List<Vertex<T>> singleton(Vertex<T> source) {
        Vertex<T> s = ((Vertex<T>) source).getData() == null ? new Vertex<T>(source.getData()) : source;
        List<Vertex<T>> list = new ArrayList<>();
        list.add(source);
        return list;
    }

    private Integer getMinFlowInpath(List<Vertex<T>> path) {
        return IntStream.range(0, path.size() - 1).mapToObj(vertexId -> getNeighborEdgeWeight(path, vertexId))
                .min(Integer::compareTo).orElse(0);
    }

    private Integer getNeighborEdgeWeight(List<Vertex<T>> path, int vertexId) {
        return path.get(vertexId).getNeighbors().get(path.get(vertexId + 1));
    }

}
