package Chapter3;

import Generic.TESTSUIT;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

import Chapter2.LinkedLists.DllNode;
import Chapter2.LinkedLists.DoublyLinkedList;

public class StackOfPlates<T> {
    private static int index = 0;
    /*
     * Chapter: 3, Question: 3.
     * Imageine a lieteral stack pf plates. If the stack gets too high, it might
     * topple. Therefore, in real life, we would likely start
     * a new stack when the previous stack exceeds some threshold. Implment a data
     * structure SetOfStacks that mimics this. SetOfStacks
     * should be compsed of several stacks and should create a new stack once the
     * previous one exceeds capacity. setOfStack.push() and SetOfStacks.pop()
     * should behave identically to a single stack. That is pop() should return the
     * same values as it would if there were just a sinlge stack.
     * Then Implement a function popAt(int index) which performs a pop operation of
     * a specific substack.
     * 
     * Hints: 64 81
     */

    private ArrayList<DataStructures.Stack<T>> stackList = new ArrayList<DataStructures.Stack<T>>();
    
    public static class StackListClass<T>{
        public int counter = 0;
        public DataStructures.Stack<T> stack = new DataStructures.Stack<T>();

    }
    private StackListClass<T> top = new StackListClass<T>();

    private StackOfPlates(){
        stackList.add(top.stack);
    }

    public void push(T item){
        if(top.counter > 2){
            CreateNewStack(item);
        } else {
            top.counter++;
            top.stack.push(item);
        }
    }
    
    //Runtime O(n*2) for ArrayList + O(n) for stacks
    private void CreateNewStack(T item){
        top = new StackListClass<T>();
        stackList.add(top.stack);
        index++;
        top.counter++;
        stackList.get(index).push(item);
        // System.out.println("counter is: " + top.counter + ", index is: " + index);
        // System.out.println("pushed item: " + stackList.get(index).peek());


    }
    
    public T popAt(int index){
        return stackList.get(index).pop();
    }

    public T pop(){
        if(top.counter < 1){
            index--;
            top.counter = 2;
        } else{
            top.counter--;
        }

        return stackList.get(index).pop();
    }

    public T peek(){
        return stackList.get(index).peek();
    }
    public int index(){

        return index;
    }

public static void main(String[] args) {
        StackOfPlates<Integer> intStack = new StackOfPlates<Integer>();
        
        System.out.println("push:");
        intStack.push(1);
        System.out.println(intStack.index()); // 0
        intStack.push(2);
        System.out.println(intStack.index()); // 0
        intStack.push(3);
        System.out.println(intStack.index()); // 0
        intStack.push(4);               // new stack
        intStack.push(5);
        System.out.println(intStack.index()); // 1
        intStack.push(6);
        System.out.println(intStack.index()); // 1 
        intStack.push(7);
        System.out.println(intStack.index()); // 2 new stack

        System.out.println("pop:");
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.popAt(0));
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        
    }
}
/*
 * Questions:
 * 1.
 * 
 * Ideas:
 * 1. ArrayList of stacks in which index refers to the current stack index.
 * Accessing pop operation on specific stack given index.
 * 2. create another class with index field and instantiate it for each stack exceeding capacity and returns it 
 *    (need refresher on OOP to create a link between classes and interfaces)
 * 
 * Edge Cases:
 * 1. empty list
 * 2. initial arraylist size
 * 3. retaining a counter for each list
 * 
 * Pros vs. Cons in solutons:
 * 1.
 * 
 * Learned: Different solution, ideas:
 * 1. static classes
 * 2. 
 * 
 * Mistakes:
 * 1. made one universal counter which does not account for specific removal of items from stacks. Some stacks are not full but counter wouldnt account for it
 */
