package Chapter2;
import java.util.Stack;

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

    // Runtime: O(Linkedlist.size()) runtime + O(1) space + O(1) stackspace
    public static boolean palindrome(DoublyLinkedList list) {
        if(list == null ) return false;
        if(list.size() == 1) return true;
        int size = list.size();
        int midpoint = size/2;
        int i = 0;
        DllNode right = list.head;
        DllNode left = list.head;

        while(right != null){
            if(i == midpoint){ 
                if(size % 2 == 0) {
                    left = right.prev;
                } else {
                    left = right.prev;
                    right = right.next;
                }
            }

            if(i >= midpoint) {
                if(right.data != left.data) 
                    return false;
                left = left.prev;
            }
            right = right.next;
            i++;
        }
        return true;
    }

    // Runtime: O(Linkedlist.size()+Linkedlist.size()) runtime + O(Linkedlist.size()) space + O(1) stackspace
    public static boolean palindromeStack(DoublyLinkedList list) {
        if(list == null) return false;

        Stack<Integer> stack = new Stack<Integer>();
        DllNode fast = list.head;
        DllNode slow = list.head; 

        while(fast != null && fast.next != null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null) slow = slow.next;

        //when the first loop completes slow would be midway through the loop
        while(slow!=null){
            int top = stack.pop().intValue();

            if(top != slow.data){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

        // The recursive method must return two values, therefore we can return an instance of an object which holds two values
        class Result {
            public DllNode node;
            public boolean result;
            public Result(DllNode node, boolean result) {
                this.node = node;
                this.result = result;
            }

        }

        public static int lengthOfList(DllNode n){
            int size = 0;
            while(n != null) {
                size++;
                n = n.next;
            }

            return size;
        }

        public static boolean palindromeRecursion(DoublyLinkedList list) {
            if(list == null ) return false;
            int length = lengthOfList(list.head);
            Result p = isPalindrome(list.head, length);
            return p.result;
        }
        // Runtime: O(Linkedlist.size()) runtime + O(1) space + O(LinkedList.size()) stackspace
        public static Result isPalindrome(DllNode head, int length) {
            LLPalindrome outer = new LLPalindrome();
            if(head == null || length <= 0) { // Even number of nodes
                return outer.new Result(head, true);
            } else if(length == 1) { // Odd number of nodes
                return outer.new Result(head.next, true);
            }
            // Recurse
            Result res = isPalindrome(head.next, length - 2);
            
            // if child calls are not true pass back up the false/faliure return
            if(!res.result || res.node == null) return res;

            // check if matches corresponding node on return
            res.result = (head.data == res.node.data);

            // return corresponding node
            res.node = res.node.next;

            return res;
        }
    
    public static void main(String[] args) {
        DoublyLinkedList le = TESTSUIT.createLinkedList(new int[] {});
        DoublyLinkedList l0 = TESTSUIT.createLinkedList(new int[] { 4 });
        DoublyLinkedList l1 = TESTSUIT.createLinkedList(new int[] { 1, 0, 1 });
        DoublyLinkedList l2 = TESTSUIT.createLinkedList(new int[] { 2, 1, 1, 2 });
        DoublyLinkedList l3 = TESTSUIT.createLinkedList(new int[] { 7, 1, 6 });
        DoublyLinkedList l4 = TESTSUIT.createLinkedList(new int[] { 1, 2, 3 });
        DoublyLinkedList l5 = TESTSUIT.createLinkedList(new int[] { 1, 2, 3, 4 });
        DoublyLinkedList l6 = TESTSUIT.createLinkedList(new int[] { 5, 4, 9, 1, 6 });
        DoublyLinkedList l7 = TESTSUIT.createLinkedList(new int[] { 1, 2, 3, 4, 5, 5, 4, 3, 2, 1 });
        DoublyLinkedList l8 = TESTSUIT.createLinkedList(new int[] { 1, 2, 3, 4, 5, 4, 4, 3, 2, 1 });

        System.out.println("---Iteration solution:---\n");

        TESTSUIT.assertTest(palindrome(le), le, false);
        TESTSUIT.assertTest(palindrome(l0), l0, true);
        TESTSUIT.assertTest(palindrome(l1), l1, true);
        TESTSUIT.assertTest(palindrome(l2), l2, true);
        TESTSUIT.assertTest(palindrome(l3), l3, false);
        TESTSUIT.assertTest(palindrome(l4), l4, false);
        TESTSUIT.assertTest(palindrome(l5), l5, false);
        TESTSUIT.assertTest(palindrome(l6), l6, false);
        TESTSUIT.assertTest(palindrome(l7), l7, true);
        TESTSUIT.assertTest(palindrome(l8), l8, false);

        System.out.println("---Stack solution:---\n");

        TESTSUIT.assertTest(palindromeStack(le), le, false);
        TESTSUIT.assertTest(palindromeStack(l0), l0, true);
        TESTSUIT.assertTest(palindromeStack(l1), l1, true);
        TESTSUIT.assertTest(palindromeStack(l2), l2, true);
        TESTSUIT.assertTest(palindromeStack(l3), l3, false);
        TESTSUIT.assertTest(palindromeStack(l4), l4, false);
        TESTSUIT.assertTest(palindromeStack(l5), l5, false);
        TESTSUIT.assertTest(palindromeStack(l6), l6, false);
        TESTSUIT.assertTest(palindromeStack(l7), l7, true);
        TESTSUIT.assertTest(palindromeStack(l8), l8, false);

        System.out.println("---Recursion solution:---\n");

        TESTSUIT.assertTest(palindromeRecursion(le), le, false);
        TESTSUIT.assertTest(palindromeRecursion(l3), l3, false);
        TESTSUIT.assertTest(palindromeRecursion(l4), l4, false);
        TESTSUIT.assertTest(palindromeRecursion(l5), l5, false);
        TESTSUIT.assertTest(palindromeRecursion(l6), l6, false);
        TESTSUIT.assertTest(palindromeRecursion(l8), l8, false);
        TESTSUIT.assertTest(palindromeRecursion(l0), l0, true);
        TESTSUIT.assertTest(palindromeRecursion(l1), l1, true);
        TESTSUIT.assertTest(palindromeRecursion(l2), l2, true);
        TESTSUIT.assertTest(palindromeRecursion(l7), l7, true);
    }
}

/*
 * Questions:
 * 1. Acess to size?
 * 2. Is empty list a palindrome or false?
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
 * 3. list containing a single item
 * 
 * Pros vs. Cons in solutons:
 * 1. time vs space of O(n/2)
 * 
 * Learned: Different solution, ideas:
 * 1. Midpoint = rightIndex + (lastIndex-rightIndex)/2
 * 2. LinkedList.size() is O(1) access in java.util.LinkedList
 * 3. Java source files can be viewed from directory
 * 4. Size starts with index 0 in LinkedLists similar to arrays.
 * 5. length is size() + 1
 * 6. If size() is not known, can have a fast runner at 2x speed 
 *    and store the slow 1x speed iterator in a linkedlist and compare the full list vs reversed linkedlist
 * 
 * Mistakes:
 * 1. Assumed palindrome is [0123 0123] instead of [0123 3210]

 Midpoints:
    Case Odd:
        [1,0,1].size() = 3
        3/2 = 1 => 0

    Case Even:
        [1,2,2,1].size() = 4
        4/2 = 2 => Second 2
    
        Better to approach as even/odd and skip moving prev/left pointer if even

  */