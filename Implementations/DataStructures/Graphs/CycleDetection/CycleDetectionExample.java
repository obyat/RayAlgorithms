package DataStructures.Graphs.CycleDetection;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CycleDetectionExample {

    public static void main(String[] args) {
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> E = new Vertex<>("E");
        Vertex<String> F = new Vertex<>("F");

        A.addNeighbor(B);
        A.addNeighbor(C);

        B.addNeighbor(C);
        B.addNeighbor(D);
        B.addNeighbor(E);

        C.addNeighbor(D);
        D.addNeighbor(E);
        E.addNeighbor(F);
        F.addNeighbor(D);

        List<Vertex<String>> graph = Arrays.asList(A, B, C, D, E, F);
        System.out.println("Directed Graph HasCycle? " + new CycleDetection<String>().hasCycle(graph));

        A = new Vertex<>("A");
        B = new Vertex<>("B");
        C = new Vertex<>("C");
        D = new Vertex<>("D");
        E = new Vertex<>("E");
        F = new Vertex<>("F");

        A.addNeighbor(B);
        A.addNeighbor(C);

        B.addNeighbor(E);
        B.addNeighbor(A);

        C.addNeighbor(D);
        C.addNeighbor(A);

        D.addNeighbor(E);
        D.addNeighbor(C);

        E.addNeighbor(F);
        E.addNeighbor(D);

        F.addNeighbor(E);

        System.out.println("Undirected Graph HasCycle? " + new CycleDetection<String>().hasCycleUndirected(graph));

    }
}
