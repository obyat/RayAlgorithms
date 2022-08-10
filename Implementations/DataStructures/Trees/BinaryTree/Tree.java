package DataStructures.Trees.BinaryTree;

public interface Tree<T> {

    Tree<T> insert(T data);

    void insertAll(T[] array);

    void traverse();

    T getMax();

    T getMin();

    Node<T> search(Node<T> node, T data);

    boolean isEmpty();
}
