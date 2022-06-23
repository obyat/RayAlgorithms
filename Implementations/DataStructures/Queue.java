package DataStructures;

import java.util.NoSuchElementException;

public class Queue<T>{
    private static class QueueNode<T>{
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data){
            this.data = data;
        }
    }
    
    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item){
        QueueNode<T> t = new QueueNode<T>(item);
        if( last != null) {
            last.next = t;
        }
        last = t;
        if( first == null){
            first = last;
        }
    }

    public T remove(){
        if (first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if (first == null) 
            last = null;
        return data;    
    }

    public T poll(){
        if (first == null) return null;
        T data = first.data;
        first = first.next;
        if (first == null) 
            last = null;
        return data;    
    }

    public T peek(){
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public static void main(String[] args) {
        Queue<Integer> intQueue = new Queue<Integer>();
        intQueue.add(1);
        intQueue.add(2);
        intQueue.add(3);
        System.out.println(intQueue.peek());
        System.out.println(intQueue.remove());
        System.out.println(intQueue.remove());
        intQueue.add(4);
        System.out.println(intQueue.poll());
        System.out.println(intQueue.poll());
        System.out.println(intQueue.poll());

    }
}