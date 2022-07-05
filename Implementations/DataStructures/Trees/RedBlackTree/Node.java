package DataStructures.Trees.RedBlackTree;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.RED;

public class Node<T extends Comparable<T>> {
    private T data;
    private Color color = RED;
    private Node<T> leftChild;
    private Node<T> rightChild;
    private Node<T> parent;

    public Node(T data){
        this.data = data;
        if(data == null) throw new NullPointerException("Data cannot be null");
    }

    public Node<T> getParent() {
    	return this.parent;
    }
    
    public void setParent(Node<T> parent) {
    	this.parent = parent;
    }

    public T getData() {
    	return this.data;
    }

    public void setData(T data) {
    	this.data = data;
    }

    public Color getColor() {
    	return this.color;
    }
    
    public void setColor(Color color) {
    	this.color = color;
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
    
    public void setRightChild(Node<T> rightChild) {
    	this.rightChild = rightChild;
    }

    public boolean isLeftChild(){
        return this == parent.getLeftChild();
    }

    public void flipColor(){
        setColor(color == RED? BLACK : RED);
    }

    public String toString(){
        return data.toString();
    }

}
