package Chapter4.Graphs;

import java.util.HashSet;
import java.util.LinkedList;

class GraphValidTree {
    static int len = 0;

    public boolean graphValidTree(int n, int[][] edges) {
        if (n == 0 || edges.length == 0)
            return false;

        HashSet<Node> visitedNodes = new HashSet<Node>();
        Node firstNode = new Node(edges[0][0]);
        Node secondNode = new Node(edges[0][1]);
        firstNode.setNeighbor(secondNode);
        secondNode.setNeighbor(firstNode);

        for (int i = 1; i < edges.length; i++) {/*  */
            // need get node(0) from hashSet
            new Node(edges[i][0]).setNeighbor(new Node(edges[i][1]));
            new Node(edges[i][1]).setNeighbor(new Node(edges[i][0]));
        }

        // boolean noCyles = traverseDFS(roota, visitedNodes, roota);
        for (Node node : firstNode.getNeighbors()) {
            System.out.print(node.val + " ");
        }
        return true;
    }

    public Boolean traverseDFS(Node node, HashSet<Node> visitedNodes, Node prev) {
        // if (node != prev && visitedNodes.contains(node))
        // return false;
        visitedNodes.add(node);
        len++;
        print(node.val);
        for (Node n : node.getNeighbors()) {
            Node currPrev = node;
            if (n != prev)
                traverseDFS(n, visitedNodes, currPrev);
        }
        return true;
    }

    public static void main(String[] args) {
        GraphValidTree graphValidTree = new GraphValidTree();
        boolean t1 = graphValidTree.graphValidTree(5, new int[][] { { 0, 1 }, { 0, 2
        }, { 0, 3 }, { 1, 4 } });
        // boolean t2 = graphValidTree.graphValidTree(5, new int[][] { { 0, 1 }, { 1, 2
        // }, { 2, 3 }, { 1, 3 }, { 1, 4 } });
        // boolean t3 = graphValidTree.graphValidTree(3, new int[][] { { 0, 1 } });
        // boolean t4 = graphValidTree.graphValidTree(5, new int[][] { { 0, 1 }, { 1, 2
        // }, { 2, 3 }, { 1, 3 }, { 1, 4 } });
        graphValidTree.print(t1);
        // graphValidTree.print(t2);
        // graphValidTree.print(t3);
        // graphValidTree.print(t4);
    }

    public void print(Object object) {
        System.out.println(object.toString());
    }

    class Node {
        private int val;
        private LinkedList<Node> neighbors = new LinkedList<>();

        Node(int val) {
            this.val = val;
        }

        public void setNeighbor(Node neighbor) {
            neighbors.add(neighbor);

        } // add neighbor

        public LinkedList<Node> getNeighbors() {

            return neighbors;
        }

    }
}