package Chapter2;
import Generic.TESTSUIT;

import Chapter2.LinkedLists.DllNode;
import Chapter2.LinkedLists.DoublyLinkedList ;


public class Partition{

    /*
    Chapter: 2, Question: 4. 
        Write coed to partition a linkedlist around a value x, such that all th enodes less than x come before all nodes
        greater than or equal to x. If x is contained within the elements again, the values of x only need to be after the elements less than x.
        The partition element x can appear anywhere in the right partition; it does not need to appear between the left and right partitions.

    Hints: 3, 24
    */

    //Runtime: 
    public static DoublyLinkedList partition(DoublyLinkedList list, int x){
        if(list == null) return list;
        
        DoublyLinkedList leftList = new DoublyLinkedList(new DllNode(-1));
        DoublyLinkedList rightList = new DoublyLinkedList(new DllNode(-1));
        DllNode originalLeftHead = leftList.head;
        DllNode originalRightHead = rightList.head;
        

        while(list.head != null){
            if(list.head.data < x){
                leftList.head.next = list.head;
                leftList.head = leftList.head.next;
            } else {
                rightList.head.next = list.head;
                rightList.head = rightList.head.next;   
            }
            list.head = list.head.next;
        }
        rightList.head = originalRightHead.next;
        leftList.head.next = rightList.head;
        leftList.head = originalLeftHead.next;
        
        return leftList;
    }




    public static void main(String[] args){ 
        DoublyLinkedList le = TESTSUIT.createLinkedList(new int[] {});
        DoublyLinkedList l1 = TESTSUIT.createLinkedList(new int[] {1, 3, 10, 4, 2, 7, 5, 7, 6});
        DoublyLinkedList l1Sol = TESTSUIT.createLinkedList(new int[] {1, 3, 4, 2, 5, 10, 7, 7, 6});
        DoublyLinkedList l2 = TESTSUIT.createLinkedList(new int[] {1, 3, 4, 2, 5, 6});
        DoublyLinkedList l2Sol = TESTSUIT.createLinkedList(new int[] {1, 2, 3, 4, 5, 6});
        
        TESTSUIT.assertTest(partition(le, 8), "le", null);
        TESTSUIT.assertTest(partition(l1, 6).toString(), "l1", l1Sol.toString());
        TESTSUIT.assertTest(partition(l2, 3).toString(), "l2", l2Sol.toString());
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
        1.
    
    Mistakes:
        1. 
    */
