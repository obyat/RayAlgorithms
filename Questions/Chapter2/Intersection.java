package Chapter2;

import java.util.Stack;

import Chapter2.LinkedLists.DllNode;
import Chapter2.LinkedLists.DoublyLinkedList;
import Generic.TESTSUIT;

public class Intersection {

    /*
     * Chapter: 2, Question: 7.
     * Given two (singly) linked lists, determine if the two lists intersect. return
     * the intersecting node.
     * Note theat the intersection is defined based on reference (memory address)
     * and not value. that is the kth node of the first linked list is the exact
     * same
     * node (by reference/memory address) as the jth node of the second linked list,
     * then they are intersecting.
     * 
     * Hints: 20 45 55 65 76 93 111 120 129
     */

    // Runtime: O(l1.size() + l2.size()) + O(min(l1.size(), l2.size())) runtime, +
    // O(1) space + O(1) stack space
    public static DllNode intersection(DoublyLinkedList l1, DoublyLinkedList l2) {
        if (l1 == null || l2 == null)
            return null;

        Node l1LastNode = getLastNode(l1);
        Node l2LastNode = getLastNode(l2);

        if (l1LastNode.node != l2LastNode.node)
            return null;

        DoublyLinkedList temp;
        int lenDifference = l1LastNode.length - l2LastNode.length;

        if (l1LastNode.length < l2LastNode.length) {
            temp = l1;
            l2 = l1;
            l1 = temp;
            lenDifference = -lenDifference;
        }

        l1.head = getNextNode(l1.head, lenDifference);

        while (l1.head != null && l2.head != null) {
            if (l1.head != l2.head) {
                l1.head = l1.head.next;
                l2.head = l2.head.next;
            } else {
                return l1.head;
            }
        }

        return null;

    }

    public static DllNode getNextNode(DllNode head, int lenDifference) {
        while (lenDifference > 0) {
            head = head.next;
            lenDifference--;
        }

        return head;
    }

    class Node {
        public int length;
        public DllNode node;

        public Node(DllNode node, int length) {
            this.length = length;
            this.node = node;
        }
    }

    public static Node getLastNode(DoublyLinkedList list) {
        int length = 1;
        DllNode head = list.head;
        while (head != null) {
            head = head.next;
            length++;
        }
        return new Intersection().new Node(head, length);
    }

    public static boolean isSameNode(DllNode n1, DllNode n2) {
        return Integer.valueOf(n1.hashCode()).equals(Integer.valueOf(n2.hashCode()));
    }

    public static void main(String[] args) {
        DoublyLinkedList le = TESTSUIT.createLinkedList(new int[] {});
        DoublyLinkedList l3 = TESTSUIT.createLinkedList(new int[] { 7, 1, 6 });
        DoublyLinkedList l4 = TESTSUIT.createLinkedList(new int[] { 1, 2, 3 });
        DoublyLinkedList l5 = TESTSUIT.createLinkedList(new int[] { 1, 2, 3, 4 });
        DoublyLinkedList l6 = TESTSUIT.createLinkedList(new int[] { 5, 4, 9, 1, 6 });

        l3.head.next = l4.head.next;
        l5.head.next.next.next = l6.head.next;

        TESTSUIT.assertTest(intersection(le, l4), "l3.head.next", null);
        TESTSUIT.assertTest(intersection(l3, l4), "l3.head.next", l3.head);
        TESTSUIT.assertTest(intersection(l5, l6), "l5.head.next", l5.head);
        TESTSUIT.assertTest(intersection(l4, l6), "l5.head.next", null);
        print("AT");
        // System.out.println(isSameNode(n1, n));
    }

    public static void print(String s) {
        System.out.println(s);
    }
}
/*
 * Questions:
 * 1. Do we value code readability, runtime, or space more with tradeoffs?
 * 
 * Ideas:
 * 1. HasSet, iterate through both linkedlists and when an address repeats,
 * return the node O(L1 + L2)
 * 2. If DoublyLinkedLists, iterate through both linkedLists and check in
 * reverse order O(L1 + L2)
 * 3. Traverse both linkedlist and compare the last node then use the difference
 * to check both and return first same address of node
 * 
 * Edge Cases:
 * 1. empty node(s)
 * 2. no intersection
 * 3. DoublyLinkedLists (faster implementation)
 * 4.
 * 
 * Pros vs. Cons in solutons:
 * 1.
 * 
 * Learned: Different solution, ideas:
 * 1. equals()
 * 2. return new Intersection().new Node(list.head, 1);
 * 
 * Mistakes:
 * 1. writing middle portion of code first, then left, then right. Should start
 * from left.
 */
