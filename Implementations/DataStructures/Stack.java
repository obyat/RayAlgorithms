package DataStructures;
import java.util.EmptyStackException;

public class Stack<T> {
    private int size = 0;
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;
        public StackNode(T data){
            this.data = data;
        }
    }
    private StackNode<T> top;

    public T pop(){
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next; 
        return item;
    }

    public void push(T item){
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
        size++;
    }

    public T peek(){
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public int size(){
        return this.size;
    }

    public <T> Stack<T> sort(){
        Stack<T> stack = (Stack<T>) this;
        Stack sortedStack;
        if(stack.isEmpty()) {
            return stack;
        } else if(stack.peek() instanceof Integer){
             sortedStack = new Stack<Integer>();
            while(!stack.isEmpty()){
                int temp = (int) stack.pop();
                while(!sortedStack.isEmpty() && ((int) sortedStack.peek() > temp)){
                    stack.push((T) sortedStack.pop());
                }
                sortedStack.push(temp);
            }
        } else {
           sortedStack = new Stack<T>();
            T temp = null;
            sortedStack.push(stack.pop());
            while(!stack.isEmpty()){
                temp = stack.pop();
                if( ( (String.valueOf(temp)).compareTo( String.valueOf(sortedStack.peek()) ) ) >= 0){
                    sortedStack.push(temp);
                } else {
                    while(!sortedStack.isEmpty() && ((String.valueOf(temp)).compareTo( String.valueOf(sortedStack.peek()) ) ) < 0){
                        stack.push((T) sortedStack.pop());
                    }
                    sortedStack.push(temp);
                }
            }
        
        }

        return sortedStack;
    }


    public String toString(){
        Stack<T> copy = this;
        StringBuilder str = new StringBuilder();
        str.append("[");
        while(!copy.isEmpty()){
            str.append(copy.pop() + ", ");
        }
        str.append("]");
        return str.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<Integer>();
        intStack.push(10);
        intStack.push(13);
        intStack.push(17);
        intStack.push(16);
        intStack.push(16);
        System.out.println(intStack.pop());
        System.out.println(intStack.peek());
        System.out.println((intStack.sort()).toString());

    }
}