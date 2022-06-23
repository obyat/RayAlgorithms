package Chapter3;
import java.util.EmptyStackException;

import Generic.TESTSUIT;

// Cost of O(1) insertions. Amortized cost of O(n)/O(n) = O(1) removal. Worst case cost of O(n) removal.
public class MyQueue<T>{

    /*
    Chapter: 3, Question: 4. 
        Implement a MyQueue class which implements a queue using two stacks.

    Hints:
    */
    private DataStructures.Stack<T> insertionStack = new DataStructures.Stack<T>();
    private DataStructures.Stack<T> removalStack = new DataStructures.Stack<T>(); //removal is reversed

    public void add(T data){
        insertionStack.push(data);
    }

    public T remove(){
        if(this.isEmpty()) throw new EmptyStackException();
        QueueLoad();
        System.out.println(removalStack.peek());
        return removalStack.pop();
    }

    private void QueueLoad() {
        if(removalStack.isEmpty()){
            while(!insertionStack.isEmpty() ){
                removalStack.push(insertionStack.pop());
            }
        }
    }

    public int size(){
        return insertionStack.size() + removalStack.size();
    }

    public T peek(){
        if(this.isEmpty()) throw new EmptyStackException();
        return removalStack.peek();
    }

    public boolean isEmpty(){
        return insertionStack.isEmpty() && removalStack.isEmpty();
    }


    public static void main(String[] args){ 
        MyQueue<Character> queue = new MyQueue<Character>();
        queue.add('a');
        queue.add('b');
        queue.add('c');
        queue.add('a');
        queue.add('b');
        queue.add('c');
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        
        
    }
}
    /*
    Questions:
        1.

    Ideas:
        1.

    Edge Cases:
        1. empty queue/stack?
    
    Pros vs. Cons in solutons:
        1.
    
    Learned: Different solution, ideas:
        1.method name differences for queue vs stacks
    
    Mistakes:
        1. Could not come up with reverse second stack as an effective pop -> push idea for a solution
    */