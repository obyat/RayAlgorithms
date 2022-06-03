package Chapter2;

import Chapter2.LinkedLists.DllNode;
import Chapter2.LinkedLists.DoublyLinkedList;

public class ReturnKthToLast{

    /*
    Chapter: 2, Question: 2.
        Implement an algorithm to find the kth to last element of a singly linked list 

    Hints: 8, 25, 41, 67, 126
    */

    //Runtime: O(n) time, O(1) space.
    public static int returnKthToLast(DoublyLinkedList list, int k){
        DllNode curr = list.head;
        DllNode kth = curr;
        int count = 0;
        
        while(curr != null){
            curr = curr.next;
            if(count > k) 
                kth = kth.next;
            count++;
        }

        return kth.data;
    }

    //Runtime: O(n/2) = O(n) time, O(n) space in stack memory where each call adds a block of O(1) block in stack until O(n) is reached in worst case.
    public static int returnKthToLastRecursive(DllNode list, int k){
        if(list == null) return -1;
        int index = returnKthToLastRecursive(list.next, k) + 1;
        if(index == k)
            System.out.println("returnKthToLastRecursive, kth item is: " + list.data + "\n");
       return index;
    }

    class Index {
        public int value = -1;
    }
    
    static DllNode kthtoLast(DllNode head, int k){
        // OuterClass myOuter = new OuterClass();
        // OuterClass.InnerClass myInner = myOuter.new InnerClass();
    
        ReturnKthToLast outer = new ReturnKthToLast();
        ReturnKthToLast.Index idx = outer.new Index();
        return kthToLast(head, k, idx);
    }
    
    static DllNode kthToLast(DllNode head, int k, ReturnKthToLast.Index idx){
        if(head == null) return null;
    
        DllNode node = kthToLast(head.next, k, idx);
        idx.value = idx.value + 1;
        if(idx.value == k){
            return head;
        } 
    
        return node;
    }

    public static DoublyLinkedList createLL(Integer[] arr){
        if(arr.length <= 0) return null;
        DllNode node = new DllNode(arr[0]);
        DoublyLinkedList  list = new DoublyLinkedList (node);
        for (int i = 1; i < arr.length; i++) list.addToEnd(arr[i]);
        return list;
    }


    public static void main(String[] args){ 
        DoublyLinkedList l0 = createLL(new Integer[] {0});
        DoublyLinkedList l0Copy = createLL(new Integer[] {0});
        int l0Sol = 0;

        DoublyLinkedList l1 = createLL(new Integer[] {0,1,2,3});
        DoublyLinkedList l1Copy = createLL(new Integer[] {0,1,2,3});
        int l1Sol = 1;

        DoublyLinkedList l2 = createLL(new Integer[] {0,2,3,4,5,6});
        DoublyLinkedList l2Copy = createLL(new Integer[] {0,2,3,4,5,6});
        int l2Sol = 5;

        DoublyLinkedList l3 = createLL(new Integer[] {0,2,3,4,5,6});
        DoublyLinkedList l3Copy = createLL(new Integer[] {0,2,3,4,5,6});
        int l3Sol = 0;

        DoublyLinkedList l4 = createLL(new Integer[] {0,2,3,4,5,6});
        DoublyLinkedList l4Copy = createLL(new Integer[] {0,2,3,4,5,6});
        int l4Sol = 6;

        
        assertTest(returnKthToLast(l0, 2), l0Copy, l0Sol);
        assertTest(returnKthToLast(l1, 2), l1Copy, l1Sol);
        assertTest(returnKthToLast(l2, 1), l2Copy, l2Sol);
        assertTest(returnKthToLast(l3, 6), l3Copy, l3Sol);
        assertTest(returnKthToLast(l4, 0), l4Copy, l4Sol);
        returnKthToLastRecursive(l1.head, 2);
        // assertTest(kthtoLast(l0.head, 2).data, l0Copy, l0Sol);
        assertTest(kthtoLast(l1.head, 2).data, l1Copy, l1Sol);
        assertTest(kthtoLast(l2.head, 1).data, l2Copy, l2Sol);
        // assertTest(kthtoLast(l3.head, 6).data, l3Copy, l3Sol);
        assertTest(kthtoLast(l4.head, 0).data, l4Copy, l4Sol);
    }

    /*
    Questions:
        1. Do we count from 0 or 1? Javadocs for linkedlist start from 0

    Ideas:
        1. Double pointer, returns exception, unless the length of linkedlist is sufficent for the problem and the first pointer is ahead of second pointer by k items, 
            when head reaches end, returns item at kth position.
        2. Iterate from opposite end of linkedlist using descendingIterator() from java.util

    Edge Cases:
        1. kth item is less than the length of linkedlist
        2. empty list
    
    Pros vs. Cons in solutons:
        1.
    
    Learned: Different solution, ideas:
        1.
    
    Mistakes:
        1. 
    */

    //use Arrays.toString(array)
    public static void assertTest(Object input, Object args, Object expected){
        if(!input.equals(expected)) {
            System.out.println("[Failed] expected: " + expected + ", received: " + input +  ", for: " + args);
        } else {
            System.out.println("[Passed] " + args);
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

