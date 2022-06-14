package Chapter2;
import Generic.TESTSUIT;

import Chapter2.LinkedLists.DllNode;
import Chapter2.LinkedLists.DoublyLinkedList;


public class LoopDetection{

    /*
    Chapter: 2, Question: 8. 
    Given a circular linked list, implement an algorithm that return the node at the beginning of the loop.
    Definition:
    Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.

    Example:
    Input: A -> B -> C -> D -> E -> C 
            
    Output: C
    
    Hints: 50 69 83 90


    */

    //Runtime: 
    //finds beginning of a loop
    public static DllNode loopDetection(DoublyLinkedList list){
        if(list == null) return null;
        DllNode slow = list.head;
        DllNode fast = list.head;

        //Find meeting point. This will be Loopsize - k steps into the linkedlist
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){ //collision
                break;
            }
        }

        //Error check - no meeting point, and therefore no loop
        if(fast == null || fast.next == null) {
            return null;
        }

        //Move slow to head. Kepp fast at meeting point. Each are k steps from the loop start.
        //If they move at the same pace, they must meet at loop start.

        slow = list.head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        //Both now point to the start of the loop
        return fast;
    }


    public static void main(String[] args){ 
        DoublyLinkedList le = TESTSUIT.createLinkedList(new int[] {});
        DoublyLinkedList l3 = TESTSUIT.createLinkedList(new int[] { 7, 1, 6 });
        DllNode n1 = new DllNode(1);
        DllNode n2 = new DllNode(2);
        DllNode n3 = new DllNode(3);
        DoublyLinkedList l1 = new DoublyLinkedList(n1);
        l1.head.next = n2;
        l1.head.next.next = n3;
        l1.head.next.next.next = n1;

        TESTSUIT.assertTest(loopDetection(le), "le", null);
        TESTSUIT.assertTest(loopDetection(l1), "l1", l1.head.next.next.next);
        TESTSUIT.assertTest(loopDetection(l3), "l3", null);

        // System.out.println();

    }
}
    /*
    Questions:
        1.Space vs time?
        2. 

    Ideas:
    A. The Node.next for two nodes will be the same.
        1. Store address of nodes in a HashSet and compare.
        2. for each node, loop through all nodes
        3. Runner in which 

    Edge Cases:
        1. no loop
        2. empty list
        3. more than one loop
    
    Pros vs. Cons in solutons:
        1. O(n) space vs O(n^2) time
    
    Learned: Different solution, ideas:
        1. If two pointers start at the same location and one moves two times for each one move of the other pointer,
            eventually the faster pointer will loop around the slower pointer
    
    Mistakes:
        1. 
    */
