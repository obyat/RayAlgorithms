package Chapter2;
import java.util.LinkedList;

import Chapter2.LinkedLists.DllNode;
import Chapter2.LinkedLists.DoublyLinkedList ;
import Generic.TESTSUIT;

public class LLPalindrome{

    /*
    Chapter: 2, Question: 6. 
        Implement a function to check if a linkedlist is a palindrome
    Hints: 5,13,29,61,101
    
    Examples:
        
    */

    //Runtime: 
    public static boolean Name(String str){
        return true;
    }


    public static void main(String[] args){ 
        // TESTSUIT.assertTest(isUniqueChars("abc"), "abc", true);
        // TESTSUIT.assertArray2DTest(matrix1Rotated, "matrix10", matrix1Rotated);
        // System.out.println();

    }
}
    /*
    Questions:
        1. Acess to size?

    Ideas:
        1. If the length is known, then recurse with with odd/even solutions ready until midpoint is reached

    Edge Cases:
        1. 
    
    Pros vs. Cons in solutons:
        1.
    
    Learned: Different solution, ideas:
        1. midpoint = firstIndex + (lastIndex-firstIndex)/2
            1 2 3 4 5
            1 + 5-1 /2 = 3

            1 2 3 4 5 6 

            1 + 6/2 = 4

    Mistakes:
        1. 
    */

