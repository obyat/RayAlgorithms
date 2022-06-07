package Chapter2;
import Chapter2.LinkedLists.DllNode;
import Chapter2.LinkedLists.DoublyLinkedList ;
import Generic.TESTSUIT;

public class SumLists{

    /*
    Chapter: 2, Question: 5. 
        You have two numbers represented by a linked list, where each node contains a single digit.
        The digits are stored in reverse order, such that the 1's digit is at the head of the list.
        Write a function that adds the two numbers and returns the sum as a linkedlist.

    Hints: 7, 30, 71, 95, 109
    */

    //Runtime: O(S1)+O(s2) time + O(S1)+O(s2) space.
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

    // O(l1.size() + l2.size() / 2) runtime, O(4 Bytes = 32 Bits = 1 int = 1 Constant) space.
    // can be O(result.size()) space instead O(1) if implemented to return linkedlist. this is better solution for returning int
    public static int sumListsForwardPartiallyImproved(DoublyLinkedList l1, DoublyLinkedList l2){
        if(l1 == null || l2 == null ) return -1;
        int i1 = 0;
        int i2 = 0;

        if(l1 != null) {
            i1 += l1.head.data;
            System.out.println(i1);
        }

        if(l2 != null) i2 += l2.head.data;

        while(l1.head.next != null) {
            i1 *= 10;
            System.out.println(i1);
            i1 += l1.head.next.data;
            System.out.println(i1);
            l1.head = l1.head.next;
        }

        while(l2.head.next != null) {
            i2 *= 10;
            i2 += l2.head.next.data;
            l2.head = l2.head.next;
        }

        return i1+i2;
    }


    //runtime O(l1.size() + l2.size()) time + l1.size() stack space + result.size() space
    public static DoublyLinkedList addListsImproved(DoublyLinkedList l1, DoublyLinkedList l2, int carry){
        if(l1.head == null && l2.head == null & carry == 0) return null;
        DoublyLinkedList result = new DoublyLinkedList(new DllNode(1));
        int currentSumVal = carry;

        if(l1.head != null) currentSumVal += l1.head.data;
        if(l2.head != null) currentSumVal += l2.head.data;
        result.head.data = currentSumVal % 10; //if the current sum val > 10 then 12 % 10 = 2. Otherwise 9 % 10 = 9 

        if(l1 != null || l2 != null){
            l1.head = (l1.head == null) ? null : l1.head.next;
            l2.head = (l2.head == null) ? null : l2.head.next;
            DoublyLinkedList more = addListsImproved(l1, l2, currentSumVal >= 10 ? 1 : 0); //if currentSumVal > 10, we have a carry of 1
                                                                                          //otherwise filler is 0 incase one list is shorter than other  
            
            if (more != null) result.head.next = more.head; //append the value from the stack into the current result list
        }
        return result;
    }

    public static int testInt(){
        // Forward accumulation 
            // 1 + 2 + 3 = 123
            // 1 + 2 * 10 + 3 * 100

            // 6 + 4 + 5 = 645
            // 6 * 1 + 4 * 10 + 6 * 100

        // Backwards accumulation 
            // 3 + 2 + 7 =  723
            // 3 % 10 + 2 * 10 % 100 + 7 * 100 % 1000
            
            //5 + 3 + 9 = 935
            //5 % 10 + 3 * 10 % 100 + 9 * 100 % 1000
            
            //5 + 3 + 9 = 539

            // 1 + 2 + 3 = 123 

            // 3 + 2 + 1 = 321
        return  (3 + 2 * 10 + 1 * 100) % 100 ;
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

        DoublyLinkedList l3A = TESTSUIT.createLinkedList(new int [] {7,1,6});
        DoublyLinkedList l3B = TESTSUIT.createLinkedList(new int [] {5,9,2});
        DoublyLinkedList l3S = TESTSUIT.createLinkedList(new int [] {2,1,9});

        DoublyLinkedList l4A = TESTSUIT.createLinkedList(new int [] {1,2,3});
        DoublyLinkedList l4B = TESTSUIT.createLinkedList(new int [] {0});

        // TESTSUIT.assertTest(sumListsForward(leA, leB), "e", -1);
        // TESTSUIT.assertTest(sumListsForward(l0A, l0B), "4 + 6", 6);
        // TESTSUIT.assertTest(sumListsForward(l1A, l1B), "100 + 200", 300);
        // TESTSUIT.assertTest(sumListsForward(l2A, l2B), "617 + 295", 912);



        // TESTSUIT.assertTest(sumListsForwardPartiallyImproved(l2A, l2B), "617 + 295", 912);
        // TESTSUIT.assertTest(sumListsForwardPartiallyImproved(l4A, l4B), "123 + 0", 123);
        System.out.println("");

        TESTSUIT.assertTest(addListsImproved(l3A, l3B, 0).toString(), "716 + 592", l3S.toString());
    }

    /*
    Questions:
        1. Will we exceed MaxInt? Do we need to use long?

    Ideas:
        1. Accumulate and multiply by 10

    Edge Cases:
        1. MaxInt, empty List, non-ints.
    
    Pros vs. Cons in solutons:
        1.
    
    Learned: Different solution, ideas:
        1. Carry, recursion, accumulating integers
    
    Mistakes:
        1. 
    */


}