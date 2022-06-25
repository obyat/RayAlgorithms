package Chapter3;
import DataStructures.Stack;
import Generic.TESTSUIT;

// import Chapter2.LinkedLists.DllNode;
// import Chapter2.LinkedLists.DoublyLinkedList ;


public class SortStack<T>{

    /*
    Chapter: 3, Question: 4. 
        Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary stack, 
        but you may not copy the elements into any other data structure such as an array. The stack supports the following operations: pushp, pop. peek, and is Empty.
    
    Hints: 15 32 43
    */

    //Runtime: O(n^2) runtime with O(2n) space
    public static <T> Stack<T> sort(Stack<T> stack){
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


    public static void main(String[] args){
        Stack<Integer> intStack = new Stack<Integer>();
        Stack<Integer> sortedStack = new Stack<Integer>();

        intStack.push(4);               
        intStack.push(5);
        intStack.push(1);               
        intStack.push(2);
        intStack.push(6);               
        intStack.push(3);
        intStack.push(8);               
        intStack.push(7);

        sortedStack.push(1);               
        sortedStack.push(2);
        sortedStack.push(3);               
        sortedStack.push(4);
        sortedStack.push(5);               
        sortedStack.push(6);
        sortedStack.push(7);               
        sortedStack.push(8);

        Stack<Character> charDupsStack = new Stack<Character>();
        Stack<Character> sortedDupsStack = new Stack<Character>();

        charDupsStack.push('b');               
        charDupsStack.push('a');
        charDupsStack.push('b');               
        charDupsStack.push('a');
        charDupsStack.push('b');               
        charDupsStack.push('c');
        charDupsStack.push('a');               
        charDupsStack.push('a');

        sortedDupsStack.push('a');               
        sortedDupsStack.push('a');
        sortedDupsStack.push('a');               
        sortedDupsStack.push('a');
        sortedDupsStack.push('b');               
        sortedDupsStack.push('b');
        sortedDupsStack.push('b');               
        sortedDupsStack.push('c');

        Stack<Integer> testStack = new Stack<Integer>();
        Stack<Integer> sortedTestStack = new Stack<Integer>();

        testStack.push(10);
        testStack.push(17);
        testStack.push(16);
        testStack.push(13);

        sortedTestStack.push(10);
        sortedTestStack.push(13);
        sortedTestStack.push(16);
        sortedTestStack.push(17);

        Stack<Integer> emptyStack = new Stack<Integer>();
        Stack<Integer> sortedEmptyStack = new Stack<Integer>();
        
        TESTSUIT.assertTest(sort(intStack), "intStack", sortedStack);
        TESTSUIT.assertTest(sort(charDupsStack), "charDupsStack", sortedDupsStack);
        TESTSUIT.assertTest(sort(testStack), "testStack", sortedTestStack);
        TESTSUIT.assertTest(sort(emptyStack), "emptyStack", sortedEmptyStack);
    }
}
    /*
    Questions:
        1.

    Ideas:
        1.

    Edge Cases:
        1. Empty stack
        2. Different input such as String, etc.
        3. Duplicate sorting
    
    Pros vs. Cons in solutons:
        1.
    
    Learned: Different solution, ideas:
        1. String comparison doesnt always work because it happens on character basis such as: "1" vs "29" 1 v 2 then 0 vs 9
    
    Mistakes:
        1. keep making same mistakes such as forgetting to print/uncomment
    */
