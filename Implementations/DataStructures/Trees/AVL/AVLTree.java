package DataStructures.Trees.AVL;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

public class AVLTree<T extends Comparable <T>> 
    implements Tree<T>{

    public Node<T> root;

    @Override
    public Tree<T> insert(T data) {
        if(isEmpty()) root = new Node<T>(data);
       else {
        insert(data, root);
       }
       return this;
    }

    public Node<T> insert(T data, Node<T> node) {
        if(data.compareTo(node.getData()) < 0){
            if(node.getLeftChild() == null){
                Node<T> n = new Node<>(data);
                node.setLeftChild(n);
            }
            insert(data, node.getLeftChild());
        } else if (data.compareTo(node.getData()) > 0){
            if(node.getRightChild() == null){
                Node<T> n = new Node<T>(data);
                node.setRightChild(n);
            }
            insert(data, node.getRightChild());
        } else {
            return node;
        }

        updateHeight(node);
        return applyRotation(node);
    }

    private void updateHeight(Node<T> node) {
        int maxHeight = 
        Math.max(findHeight(node.getLeftChild()), findHeight(node.getRightChild()));
        node.setHeight(maxHeight + 1);
    }

    private int findHeight(Node<T> node){
        return node != null? node.getHeight() : 0;
    }

    private Node<T> applyRotation(Node<T> node) {
        int balance = findBalance(node);
        if(balance > 1){
            if(findBalance(node.getLeftChild()) < 0)
                node.setLeftChild(rotateLeft(node.getLeftChild()));
            return rotateRight(node);

        }
        if (balance < -1){
            if(findBalance(node.getRightChild()) > 0)
                node.setRightChild(rotateRight(node.getRightChild()));
            return rotateLeft(node);

        }

        return node;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> rightNode = node.getRightChild();
        Node<T> centerNode = rightNode.getLeftChild();

        rightNode.setLeftChild(node);
        node.setRightChild(centerNode);

        updateHeight(node);
        updateHeight(centerNode);

        return rightNode; //new root
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> leftNode = node.getLeftChild();
        Node<T> centerNode = leftNode.getRightChild();
        
        leftNode.setRightChild(node);
        node.setLeftChild(centerNode);

        updateHeight(node);
        updateHeight(leftNode);

        return leftNode; //leftNode is now root node
    }

    private int findBalance(Node<T> node){
        return node != null 
                ? findHeight(node.getLeftChild()) - findHeight(node.getRightChild())
                : 0;
    }

    public void insertAll(T[] array){
        Iterator<T> it = Arrays.asList(array).iterator();
                while(it.hasNext()){
                    insert(it.next());
        }
    }

    @Override
    public void delete(T data) {
        root = delete(data, root);
    }

    public Node<T> delete(T data, Node<T> node){
        if(node == null) {
            return null;
        }

        if(data.compareTo(node.getData()) < 0){
            node.setLeftChild(delete(data, node.getLeftChild()));
        } else if(data.compareTo(node.getData()) > 0){
            node.setRightChild(delete(data, node.getRightChild()));
        } else{
            //one child -- leaf node/one child case
            if(node.getLeftChild() == null ){
                return node.getRightChild();
            } else if(node.getLeftChild() == null ){
                return node.getRightChild();
            }

            // two children
            node.setData(getMax(node.getLeftChild()));
            node.setLeftChild(delete(node.getData(), node.getLeftChild()));


        }

        updateHeight(node);
        return applyRotation(node);
    }
    @Override
    public void traverse() {
        traverseInOrder(root);
        
    }

    private void traverseInOrder(Node<T> node) {
        if(node != null) {
            traverseInOrder(node.getLeftChild());
            System.out.println(node);
            traverseInOrder(node.getRightChild());
        }
    }

    @Override
    public T getMax(){
        if(isEmpty()) return null;
        return getMax(root);
    }

    public T getMax(Node<T> node) {
        while(node.getRightChild() != null) {
            node = node.getRightChild();
        }
        return node.getData();
    }

    @Override
    public T getMin() {
        if(isEmpty()) return null;
        return getMin(root);
    }

    public T getMin(Node<T> node) {
        while(node.getLeftChild() != null){
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
        if(node == null) throw new EmptyStackException();
        T val = node.getData();
        System.out.println(val +", is current node being checked");
        if(val.compareTo(data) == 0){
            System.out.println("reached here");
            return node;
        } else if(val.compareTo(data) < 0){
            search(node.getRightChild(), data);
        } else {
            search(node.getLeftChild(), data);
        }
        return node;
    }
    
}
