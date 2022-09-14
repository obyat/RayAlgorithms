package DataStructures.Graphs.Kruskal;

public class Edge<T> implements Comparable<Edge<T>> {
    private final Vertex<T> source;
    private final Vertex<T> destination;
    private final int weight;

    public Edge(Vertex<T> source, Vertex<T> destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex<T> getSource() {
        return source;
    }

    public Vertex<T> getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge<T> edge) {
        return Integer.compare(weight, edge.getWeight()); // min spanning tree
    }

    // @Override
    // public int compareTo(Edge<T> edge) {
    // return Integer.compare(edge.getWeight(), weight); // max spanning tree
    // }

}
