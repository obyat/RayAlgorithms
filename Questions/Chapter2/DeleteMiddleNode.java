package Chapter2;
import Chapter2.LinkedLists.DllNode;
import Chapter2.LinkedLists.DoublyLinkedList ;
public class DeleteMiddleNode{

    /*
    Chapter: 2, Question: 3. 
        Implement an algorithm to delete a any middle node of a LinkedList, given only access to that node
        but not the first or last node

    Hints:
    */
    //Runtime: O(1) time, O(1) space
    public static DoublyLinkedList deleteMiddleNode(DllNode node, DoublyLinkedList list){
        if(node != null && node.next != null && node.prev != null){
            node.prev.next = node.next;
            node.next.prev = node.prev; //only correct if the list is doublylinked. The question did not specify the type of linkedlist
        }
        return list;
    }

    public static DoublyLinkedList deleteMiddleNodeImproved(DllNode node, DoublyLinkedList list){
        if(node != null && node.next != null && node.prev != null){
            node.next = node.next.next;
        }
        return list;
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
        DllNode l0Node = l0.head; // no removal
        DoublyLinkedList l0Sol = createLL(new Integer[] {0});

        DoublyLinkedList l1 = createLL(new Integer[] {0,1,2,3});
        DllNode l1Node = l1.head; // remove 1
        DoublyLinkedList l1Sol = createLL(new Integer[] {0,1,2,3});;

        DoublyLinkedList l2 = createLL(new Integer[] {0,1,2,3,4,5,6});
        DllNode l2Node = l2.head.next.next.next.next; // remove 4
        DoublyLinkedList l2Sol = createLL(new Integer[] {0,1,2,3,5,6});

        DoublyLinkedList l3 = createLL(new Integer[] {0,1,2,3,4,5,6});
        DllNode l3Node = l3.head.next.next.next; //remove 3
        DoublyLinkedList l3Sol = createLL(new Integer[] {0,1,2,4,5,6});

        DoublyLinkedList l4 = createLL(new Integer[] {0,1,2,3,4,5,6});
        DllNode l4Node = l4.head.next.next.next.next.next; // remove 5
        DoublyLinkedList l4Sol = createLL(new Integer[] {0,1,2,3,4,6});


        DoublyLinkedList l5 = createLL(new Integer[] {0,1,2,3,4,5,6});
        DllNode l5Node = l5.head.next.next.next.next.next.next; //no removal
        DoublyLinkedList l5Sol = createLL(new Integer[] {0,1,2,3,4,5,6});

        assertTest(deleteMiddleNode(l0Node, l0).toString(), "l0", l0Sol.toString());
        assertTest(deleteMiddleNode(l1Node, l1).toString(), "l1", l1Sol.toString());
        assertTest(deleteMiddleNode(l2Node, l2).toString(), "l2", l2Sol.toString());
        assertTest(deleteMiddleNode(l3Node, l3).toString(), "l3", l3Sol.toString());
        assertTest(deleteMiddleNode(l4Node, l4).toString(), "l4", l4Sol.toString());
        assertTest(deleteMiddleNode(l5Node, l5).toString(), "l5", l5Sol.toString());
        System.out.println("\nImproved:\n");
        assertTest(deleteMiddleNodeImproved(l0Node, l0).toString(), "l0", l0Sol.toString());
        assertTest(deleteMiddleNodeImproved(l1Node, l1).toString(), "l1", l1Sol.toString());
        assertTest(deleteMiddleNodeImproved(l2Node, l2).toString(), "l2", l2Sol.toString());
        assertTest(deleteMiddleNodeImproved(l3Node, l3).toString(), "l3", l3Sol.toString());
        assertTest(deleteMiddleNodeImproved(l4Node, l4).toString(), "l4", l4Sol.toString());
        assertTest(deleteMiddleNodeImproved(l5Node, l5).toString(), "l5", l5Sol.toString());
    }

    /*
    []-[a]-[z]
    Questions:
        1. Do we need to return anything?


    Ideas:
        1.

    Edge Cases:
        1. Empty node
    
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
            System.out.println("[Array Passed] " + args);
    }
}