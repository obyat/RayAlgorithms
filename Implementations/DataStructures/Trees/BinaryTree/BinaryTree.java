package DataStructures.Trees.BinaryTree;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import javax.naming.NameNotFoundException;

public class BinaryTree<T> implements Tree<T> {

    public Node<T> root;

    @Override
    public Tree<T> insert(T data) {
        if (isEmpty())
            root = new Node<T>(data);
        else {
            insert(data, root, true);
        }
        return this;
    }

    // no specific sorting will try to balance tree
    public Node<T> insert(T data, Node<T> node, boolean goLeft) {
        if (node.getLeftChild() == null) {
            Node<T> n = new Node<>(data);
            node.setLeftChild(n);
            n.setParent(node);
        } else if (node.getRightChild() == null) {
            Node<T> n = new Node<T>(data);
            node.setRightChild(n);
            n.setParent(node);
        } else if (goLeft) {
            insert(data, node.getLeftChild(), false);
        } else {
            insert(data, node.getRightChild(), false);
        }

        return node;
    }

    public void insertAll(T[] array) {
        Iterator<T> it = Arrays.asList(array).iterator();
        while (it.hasNext()) {
            insert(it.next());
        }
    }

    @Override
    public void traverse() {
        traverseInOrder(root);

    }

    private void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.getLeftChild());
            System.out.println(node);
            traverseInOrder(node.getRightChild());
        }
    }

    @Override
    public T getMax() {
        if (isEmpty())
            return null;
        return getMax(root);
    }

    public T getMax(Node<T> node) {
        while (node.getRightChild() != null) {
            node = node.getRightChild();
        }
        return node.getData();
    }

    @Override
    public T getMin() {
        if (isEmpty())
            return null;
        return getMin(root);
    }

    public T getMin(Node<T> node) {
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }
        return node.getData();
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Node<T> search(Node<T> node, T data) {
        return search(node, data, null);
    }

    public Node<T> search(Node<T> node, T data, Node<T> foundNode) {
        if (node == null)
            return foundNode;

        else if (node.getData().equals(data)) {
            foundNode = node;
            return foundNode;
        }

        if (node.getLeftChild() != null)
            foundNode = search(node.getLeftChild(), data, foundNode);
        if (node.getRightChild() != null)
            foundNode = search(node.getRightChild(), data, foundNode);

        return foundNode;
    }

}