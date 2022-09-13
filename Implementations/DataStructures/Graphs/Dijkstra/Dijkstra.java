package DataStructures.Graphs.Dijkstra;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class Dijkstra<T> {

    public void calculateShortestPath(Node source) {
        source.setDistance(0);
        Set<Node> visited = new HashSet<Node>();
        Queue<Node> unvisitedNodes = new PriorityQueue<>(Collections.singleton(source));

        while (!unvisitedNodes.isEmpty()) {
            Node currentNode = unvisitedNodes.poll();
            currentNode.getAdjacentNodes().entrySet()
                    .stream().filter(entry -> !visited.contains(
                            entry.getKey()))
                    .forEach(entry -> {
                        evaluateDistanceAndPath(entry.getKey(), entry.getValue(), currentNode);
                        // System.out.println("visited " + entry.getKey().getName() + ", distance: "
                        // + entry.getKey().getDistance() + ", value: " + entry.getValue());
                        unvisitedNodes.add(entry.getKey()); // if candidates for unvisited adjacentNodes exist add them
                                                            // to queue
                    });
            visited.add(currentNode);
        }
    }

    private void evaluateDistanceAndPath(Node adjacentNode, Integer edgeWeight, Node sourceNode) {
        Integer newDistance = sourceNode.getDistance() + edgeWeight;
        if (newDistance < adjacentNode.getDistance()) {
            adjacentNode.setDistance(newDistance);
            adjacentNode.setShortestPath(
                    (List<Node>) Stream.concat(sourceNode.getShortestPath().stream(), Stream.of(sourceNode))
                            .collect(Collectors.toList()));
        }
    }

    private void printPaths(List<Node> nodes) {
        nodes.forEach(node -> {
            String path = node.getShortestPath().stream().map(Node::getName).collect(Collectors.joining(" -> "));
            System.out.println((path.isBlank() ? "%s : %s".formatted(node.getName(), node.getDistance())
                    : "%s -> %s : %s".formatted(path, node.getName(), node.getDistance())));
        });
    }

    public static void main(String[] args) {
        Dijkstra<Integer> dijkstra = new Dijkstra<Integer>();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addAdjacent(nodeB, 2);
        nodeA.addAdjacent(nodeC, 4);

        nodeB.addAdjacent(nodeC, 3);
        nodeB.addAdjacent(nodeD, 1);
        nodeB.addAdjacent(nodeE, 5);

        nodeC.addAdjacent(nodeD, 2);

        nodeD.addAdjacent(nodeE, 1);
        nodeD.addAdjacent(nodeF, 4);

        nodeE.addAdjacent(nodeF, 2);

        dijkstra.calculateShortestPath(nodeA);
        dijkstra.printPaths(Arrays.asList(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF));

    }

}
