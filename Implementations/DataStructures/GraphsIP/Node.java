package DataStructures.GraphsIP;

public class Node<T, Z> {
    public T name;

    public Z data;
    public boolean visited = false;
    public boolean marked = false;
    public Node<T, Z>[] children;

    Node(T name, Z data) {
        this.name = name;
        this.data = data;
    }

    public T getName() {
        return this.name;
    }

    public Z getData() {
        return this.data;
    }
}
