package Chapter2;
import Chapter2.LinkedLists.DllNode;
import Chapter2.LinkedLists.DoublyLinkedList ;
import Generic.TESTSUIT;

public class SumLists{

    /*
    Chapter: , Question: . 

    Hints:
    */

    //Runtime: 
    public static int sumListsForward(DoublyLinkedList l1, DoublyLinkedList l2){
        if(l1 == null || l2 == null ) return -1;

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        if(l1 != null) s1.append(l1.head.data);
        if(l2 != null) s2.append(l2.head.data);

        while(l1.head.next != null) {
            s1.append(l1.head.next.data);
            l1.head = l1.head.next;
        }

        while(l2.head.next != null) {
            s2.append(l2.head.next.data);
            l2.head = l2.head.next;
        }

        return Integer.parseInt(s1.toString()) + Integer.parseInt(s2.toString());
    }


    public static void main(String[] args){
        DoublyLinkedList leA = TESTSUIT.createLinkedList(new int [] {});
        DoublyLinkedList leB = TESTSUIT.createLinkedList(new int [] {});

        DoublyLinkedList l0A = TESTSUIT.createLinkedList(new int [] {4});
        DoublyLinkedList l0B = TESTSUIT.createLinkedList(new int [] {2});

        DoublyLinkedList l1A = TESTSUIT.createLinkedList(new int [] {1,0,0});
        DoublyLinkedList l1B = TESTSUIT.createLinkedList(new int [] {2,0,0});


        DoublyLinkedList l2A = TESTSUIT.createLinkedList(new int [] {6,1,7});
        DoublyLinkedList l2B = TESTSUIT.createLinkedList(new int [] {2,9,5});

        TESTSUIT.assertTest(sumListsForward(leA, leB), "e", -1);
        TESTSUIT.assertTest(sumListsForward(l0A, l0B), "4 + 6", 6);
        TESTSUIT.assertTest(sumListsForward(l1A, l1B), "100 + 200", 300);
        TESTSUIT.assertTest(sumListsForward(l2A, l2B), "617 + 295", 912);

        // System.out.println();

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


}