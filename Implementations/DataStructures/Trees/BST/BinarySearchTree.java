package DataStructures.Trees.BST;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

import javax.naming.NameNotFoundException;

public class BinarySearchTree<T extends Comparable <T>> 
    implements Tree<T>{

    public Node<T> root;

    @Override
    public Tree<T> insert(T data) {
        insert(data, root);
        return this;
    }

    public Node<T> insert(T data, Node<T> node) {
        if(node == null ) return new Node<T>(data);
        
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
        }

        return node;
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
        return node;
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