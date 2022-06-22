package Chapter3;
import java.util.EmptyStackException;

public class StackMin<T>{

    /*
    Chapter: 3, Question: 2. 
        Design a stack which, in addition to push pop, has a function min which returns the minimum element? 
        Push, pop, and min should all operate in O(1) time.

    Hints: 27 59 78
    */

    private static class StackMinNode<T>{
        private T data;
        private StackMinNode<T> next;
        private int min = Integer.MAX_VALUE;
        private StackMinNode(T data){
            this.data = data;
        }
        public int getValue() {
            return new Integer((int) data);
        }
    }
    
    private StackMinNode<T> top;
    
    public T pop(){
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek(){
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public int getMin(){
        if(top == null) throw new EmptyStackException();
        return top.min;
    }

    public void push(T item){
        StackMinNode<T> t = new StackMinNode<T>(item);
        t.next = top;
        top = t;
        if(t.next == null){
            t.min = t.getValue() < top.min? t.getValue() : top.min;
        } else if(this.top != null && t.next != null)
            t.min = t.getValue() < t.next.min? t.getValue() : t.next.min;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public static void main(String[] args){ 
        StackMin<Integer> intStack = new StackMin<Integer>();

        intStack.push(8);
        System.out.println(intStack.getMin());
        intStack.push(10);
        intStack.push(3);
        intStack.push(2);
        System.out.println(intStack.getMin());
        intStack.push(0);
        System.out.println(intStack.getMin());
        intStack.push(2);
        intStack.push(3);
        intStack.push(3);
        intStack.push(3);
        System.out.println(intStack.getMin());
        intStack.push(-500);
        intStack.push(3);
        System.out.println(intStack.getMin());

        System.out.println();
        System.out.println("After popping items: ");
        intStack.pop();
        System.out.println(intStack.getMin()); // -500
        intStack.pop();
        System.out.println(intStack.getMin()); // 0
        intStack.pop();
        intStack.pop();
        intStack.pop();
        intStack.pop();
        intStack.pop();
        System.out.println(intStack.getMin()); // 2
        intStack.pop();
        System.out.println(intStack.getMin()); // 3
        intStack.pop();
        intStack.pop();
        System.out.println(intStack.getMin()); // 8
        
        
    }
}
    /*
    Questions:
        1.

    Ideas:
        1.

    Edge Cases:
        1. Null input, Max Int
    
    Pros vs. Cons in solutons:
        1.
    
    Learned: Different solution, ideas:
        1. Instead of casting can have an integer constructor
        public int getValue() {
            return new Integer((int) data);
        }
    
    Mistakes:
        1. Tried to alter the problem to have int type instead of only returning int type for ints
    */
