package DataStructures.Trees.BinaryTree;

public class Node<T extends Comparable<T>> {
    private T data;
    public Node<T> leftChild;
    public Node<T> rightChild;
    public Node<T> parent;

    public Node(T data) {
        this.data = data;
        if (data == null)
            throw new NullPointerException("Data cannot be null");
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getParent() {
        return this.parent;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return this.rightChild;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public String toString() {
        return data.toString();
    }

}
