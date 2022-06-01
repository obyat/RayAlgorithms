package Chapter2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import Chapter2.LinkedLists.DoublyLinkedList ;
import Chapter2.LinkedLists.DllNode;
public class LLRemoveDups{

    /*
    Chapter: 2, Question: 1. 
        write Code to remove duplicates from an unsorted linkedlist

    Hints: 9, 40
    */

    //Runtime: O(n) time, O(n) space
    public static DoublyLinkedList RemoveDups(DoublyLinkedList list){
        HashSet<Integer> hs = new HashSet<Integer>();
        DllNode curr = list.head;
        // DoublyLinkedList list2 = new DoublyLinkedList(curr);
        // if(curr != null) hs.add(curr.data);
        //  while(curr.next != null){
        //     if(hs.contains(curr.data)) {
        //             curr.prev = curr.next;
        //             curr.next.prev = curr.prev;
        //     } else {
        //         hs.add(curr.data);
        //     }
        //     curr = curr.next;
        // }
        DoublyLinkedList previous = null;
        while(curr != null){
            if(hs.contains(curr.data)){
                previous.head.next = curr.next;
            } else {
                hs.add(curr.data);
                previous = list;
            }
            curr = curr.next;
        }
        return previous;
    }

    public static DoublyLinkedList  createLL(Integer[] arr){
        DllNode node = new DllNode(arr[0]);
        DoublyLinkedList  list = new DoublyLinkedList (node);
        for (int i = 1; i < arr.length; i++) list.addToEnd(arr[i]);
        return list;
    }

    public static void main(String[] args){ 

        DoublyLinkedList l1 = createLL(new Integer[] {0,1,1,2,3});
        DoublyLinkedList l1Copy = createLL(new Integer[] {0,1,1,2,3});
        DoublyLinkedList l1Sol = createLL(new Integer[] {0,1,2,3});

        DoublyLinkedList l2 = createLL(new Integer[] {1,2,2,3});
        DoublyLinkedList l2Copy = createLL(new Integer[] {1,2,2,3});
        DoublyLinkedList l2Sol = createLL(new Integer[] {1,2,3});

        DoublyLinkedList l3 = createLL(new Integer[] {0,0,2,2,3});
        DoublyLinkedList l3Sol = createLL(new Integer[] {0,2,3});

        assertTest(RemoveDups(l1), l1Copy, l1Sol);
        assertTest(RemoveDups(l2), l2Copy, l2Sol);

        // l1.head.printLinkedList();

    }

    /*
    Questions:
        1.

    Ideas:
        1. Sort the list and check if head and head.next are the same and make head.next = head.next.next
        2. Keep an array/table of items in the list and check if it is unique
        3. O(n^2) solution where each head is compared with the rest of the list

    Edge Cases:
        1. Range of items? What if range is too large to store in another data structure?
        2. Free up stored space after removing duplicates?
    
    Pros vs. Cons in solutons:
        1. Can either have O(n^2) time cost or O(n) space cost.
    
    Learned: Different solution, ideas:
        1.
    
    Mistakes:
        1. 
    */

    //use Arrays.toString(array)
    public static void assertTest(Object input, Object args, Object expected){
        if(!input.equals(expected)) {
            System.out.println("[Failed] expected: " + expected + ", received:" + input +  ", for: " + args);
        } else {
            System.out.println("[Worked] " + args);
        }
        System.out.println();
    }

    //requires all methods to return wrapper classes
    public static <T> void assertArray2DTest(T[][] input, Object args, T[][] expected){
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[0].length; col++) {
                if(input[row][col] != expected[row][col]){
                    System.out.println("[MY Array Failed] " + args);
                    return;
                }
            }
        }
            System.out.println("[Array Worked] " + args);
    }
}