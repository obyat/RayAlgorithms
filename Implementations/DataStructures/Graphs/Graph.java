package DataStructures.Graphs;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Graph<T> {

    private Node<T> startNode;

    public Graph() {
    }

    public Graph(Node<T> startNode) {
        this.startNode = startNode;
    }

    public void SearchBFS() {
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.add(startNode);
        while (!queue.isEmpty()) { // wait until all nodes are isVisited()
            Node<T> node = queue.poll();
            if (!node.isVisited()) {
                node.setVisited(true);
                visit(node);
                queue.addAll(node.getNeighbors());
            }
        }
    }

    public Node<T> find(Node<T> node) {
        return node;
    }

    public Boolean isConnectedNodes(Node<T> node1, Node<T> node2) {
        return find(node1) == find(node2);
    } 

    public void SearchDFSIteratively(Node<T> startVertex) {
        Deque<Node<T>> stack = new LinkedList<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            Node<T> current = stack.pop();
            if (!current.isVisited()) {
                visit(current);
                current.setVisited(true);
                current.getNeighbors().forEach(stack::push);
            }
        }
    }

    // DFS better for visiting every node
    public void SearchDFS(Node<T> node) {
        if (node == null)
            return;
        if (!node.isVisited()) {
            visit(node);
            node.setVisited(true);
            for (Node<T> n : node.getNeighbors()) {
                SearchDFS(n);
            }
        }
    }

    private void visit(Node<T> node) {
        print(node);
    }

    public static void print(Object o) {
        System.out.println(o.toString());
    }

    public static void main(String[] args) {
        Node<Integer> v0 = new Node<>(0);
        Node<Integer> v1 = new Node<>(1);
        Node<Integer> v2 = new Node<>(2);
        Node<Integer> v3 = new Node<>(3);
        Node<Integer> v4 = new Node<>(4);
        Node<Integer> v5 = new Node<>(5);
        Node<Integer> v6 = new Node<>(6);

        v0.setNeighbors(Arrays.asList(v1, v5, v6));
        v1.setNeighbors(Arrays.asList(v3, v4, v5));
        v4.setNeighbors(Arrays.asList(v2, v6));
        v6.setNeighbors(Arrays.asList(v0));

        Graph<Integer> GraphDfs = new Graph<Integer>();
        print("DFS using inserted order");
        GraphDfs.SearchDFS(v0);


        print("");
        v0 = new Node<>(0);
        v1 = new Node<>(1);
        v2 = new Node<>(2);
        v3 = new Node<>(3);
        v4 = new Node<>(4);
        v5 = new Node<>(5);
        v6 = new Node<>(6);

        v0.setNeighbors(Arrays.asList(v1, v5, v6));
        v1.setNeighbors(Arrays.asList(v3, v4, v5));
        v4.setNeighbors(Arrays.asList(v2, v6));
        v6.setNeighbors(Arrays.asList(v0));

        print("DFS in reverse order");
        GraphDfs.SearchDFSIteratively(v0);

        print("");
        v0 = new Node<>(0);
        v1 = new Node<>(1);
        v2 = new Node<>(2);
        v3 = new Node<>(3);
        v4 = new Node<>(4);
        v5 = new Node<>(5);
        v6 = new Node<>(6);

        v0.setNeighbors(Arrays.asList(v1, v5, v6));
        v1.setNeighbors(Arrays.asList(v3, v4, v5));
        v4.setNeighbors(Arrays.asList(v2, v6));
        v6.setNeighbors(Arrays.asList(v0));

        print("BFS search:");
        Graph<Integer> GraphBFS = new Graph<Integer>(v0);
        GraphBFS.SearchBFS();

    }
}
