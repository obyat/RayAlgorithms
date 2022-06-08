package Chapter2;

import java.util.LinkedList;

import Chapter2.LinkedLists.DllNode;
import Chapter2.LinkedLists.DoublyLinkedList;
import Generic.TESTSUIT;

public class LLPalindrome {

    /*
     * Chapter: 2, Question: 6.
     * Implement a function to check if a linkedlist is a palindrome
     * Hints: 5,13,29,61,101
     * 
     * Examples:
     *  1 0 1
     */

    // Runtime: O(Linkedlist.size() + midpoint(Linkedlist.size())) runtime + O(1) space + O(1) stackspace
    public static boolean palindrome(DoublyLinkedList ll) {
        
        return true;
    }

    public static void main(String[] args) {
        DoublyLinkedList le = TESTSUIT.createLinkedList(new int[] {});
        DoublyLinkedList l0 = TESTSUIT.createLinkedList(new int[] { 4 });
        DoublyLinkedList l1 = TESTSUIT.createLinkedList(new int[] { 1, 0, 1 });
        DoublyLinkedList l2 = TESTSUIT.createLinkedList(new int[] { 2, 1, 1, 2 });
        DoublyLinkedList l3 = TESTSUIT.createLinkedList(new int[] { 7, 1, 6 });
        DoublyLinkedList l4 = TESTSUIT.createLinkedList(new int[] { 1, 2, 3 });

        TESTSUIT.assertTest(palindrome(l1), l1, true);
        System.out.println(l1.size());
        System.out.println(l2.size());
    }
}

/*
 * Questions:
 * 1. Acess to size?
 * 
 * Ideas:
 * 1. If the length is known, then iterate to midpoint the check next and prev
 * are equal. O(Str + midpoint(Str)) time
 * 2. The best solution will be O(Str + midpoint(Str)) runtime. Make a clone of
 * head and Iterate from head until midpoint is reached,
 * then continue and compare with cloned head
 * 3. Recursive solution will be similar to above with an outer class to retain
 * the copy of the head clone
 * 
 * Edge Cases:
 * 1. Empty
 * 2. size is not known
 * 3. 
 * 
 * Pros vs. Cons in solutons:
 * 1.
 * 
 * Learned: Different solution, ideas:
 * 1. Midpoint = firstIndex + (lastIndex-firstIndex)/2
 * 2. LinkedList.size() is O(1) access in java.util.LinkedList
 * 3. Java sourcefiles can be viewed from directory
 * 4. Size starts with index 0 in LinkedLists similar to arrays.

 */

 /*

 Midpoints:
    Case Odd:
        [1,0,1]

    Case Even:
        [1,2,2,1]
  */