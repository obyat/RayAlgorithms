package Chapter3;
import java.util.EmptyStackException;

import Generic.TESTSUIT;
public class ThreeInOne{

    /*
    Chapter: 3, Question: 1.
        Describe how you could use a single array to implement three stacks. 

    Hints: 2 12 38 58
    */

    private int numOfStack = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    //Runtime: 
    // user can push/pop/peek to any stack as needed
    public ThreeInOne(int stackSize){ // individual stack size
        stackCapacity = stackSize;
        values = new int[stackSize * numOfStack];
        sizes = new int[numOfStack];

    }
    
    // push values onto stack
    public void push(int stackNum, int value) throws EmptyStackException {
        if(isFull(stackNum)){
            System.out.println("FullStackException:");
            return;
        }

        /* increment stack pointer and then update top value */
        sizes[stackNum]++;
        // System.out.println("numOfStack"+numOfStack);
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum){
        if (isEmpty(stackNum))
            throw new EmptyStackException();

        int topIndex = indexOfTop(stackNum); // Get top
        int value = values[topIndex]; // Clear
        // System.out.println(values[topIndex]);

        sizes[stackNum]--; // Shrink
        
        return value;
    }

    // return top element
    public int peek(int stackNum){
        if(isEmpty(stackNum))
            throw new EmptyStackException();
        
        return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
    }

    public boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapacity;
    }

    private int indexOfTop(int stackNum){
        // System.out.println("sizes[stackNum]"+stackNum);
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    public static void main(String[] args){ 
        ThreeInOne tio = new ThreeInOne(10);

        tio.push(0, 1);
        System.out.println(tio.peek(0));
        tio.pop(0);

        tio.push(1, 1);
        System.out.println(tio.peek(1));
        tio.pop(1);

        tio.push(2, 2);
        System.out.println(tio.pop(2));

    }

}
    /*
    Questions:
        1. 

    Ideas:
        1.

    Edge Cases:
        1. 
    
    Pros vs. Cons in solutons:
        1.
    
    Learned: Different solution, ideas:
        1. sizes[stackNum]++;
    
    Mistakes:
        1. 
    */
