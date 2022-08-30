package DataStructures.GraphsIP;

import DataStructures.Queue;

public class Graph<T> {
    public Node<T>[] nodes;

    // DFS better for visiting every node
    public void SearchDFS(Node<T> node) {
        if (node == null)
            return;
        visit(node);
        node.visited = true;
        for (Node<T, Z> n : node.children) {
            if (!n.visited)
                SearchDFS(node);
        }
    }

    // BFS better for shortest path, network, etc.
    public void SearchBFS(Node<T> node) {
        Queue<Node<T, Z>> queue = new Queue<>();
        node.marked = true;
        queue.add(node);

        while (!queue.isEmpty()) {
            Node<T, Z> r = queue.poll();
            visit(r);
            for (Node<T, Z> n : node.children) {
                if (!n.marked) {
                    n.marked = true;
                    queue.add(n);
                }
            }
        }

    }

    private void visit(Node<T, Z> node) {
        System.out.println(node.name.toString());
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        Node<String, Integer> A = new Node<String, Integer>("A", 0);
        Node<String, Integer> B = new Node<String, Integer>("B", 1);
        Node<String, Integer> C = new Node<String, Integer>("C", 0);
        Node<String, Integer> D = new Node<String, Integer>("D", 0);

    }
}
