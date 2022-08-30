package Chapter4;

import Chapter2.LinkedLists.DoublyLinkedList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Generic.TESTSUIT;

// import Chapter2.LinkedLists.DllNode;
// import Chapter2.LinkedLists.DoublyLinkedList ;

public class ListOfDepths {

    /*
     * Chapter: 4, Question: 3.
     * Given a binary tree, design an algorithm which creates a linked list
     * of all the nodes at each depth (e.g. if you have a tree with depth D,
     * you'll have D linked lists where tree depth starts 1 instead of the usual 0)
     * Hints: 19 73 116
     */

    // Runtime:
    public static ArrayList<LinkedList<Node>> list = new ArrayList<>();
    public static LinkedList<Node> queue = new LinkedList<>();

    public static ArrayList<LinkedList<Node>> listOfDepths(Node root) {
        queue.add(root);
        while (!queue.isEmpty())
            Dequeue(queue);
        return list;
    }

    private static void Dequeue(LinkedList<Node> queue) {

        while (!queue.isEmpty()) {
            LinkedList<Node> depthQueue = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                depthQueue.add(node);
                visit(node, queue);
            }

            list.add(depthQueue);
        }
    }

    private static void visit(Node root, LinkedList<Node> queue) {
        if (root.left != null)
            queue.add(root.left);
        if (root.right != null)
            queue.add(root.right);
    }

    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(5);

        ArrayList<LinkedList<Node>> t1alist = new ArrayList<>();
        LinkedList<Node> ll1 = new LinkedList<>();
        ll1.add(new Node(1));
        t1alist.add(ll1);

        LinkedList<Node> ll2 = new LinkedList<>();
        ll2.add(new Node(2));
        ll2.add(new Node(3));
        t1alist.add(ll2);

        LinkedList<Node> ll3 = new LinkedList<>();
        ll3.add(new Node(5));
        t1alist.add(ll3);

        TESTSUIT.assertTest(stringify(listOfDepths(t1)), "t1", stringify(t1alist));

    }

    public static String stringify(ArrayList<LinkedList<Node>> input) {

        String str = "{ ";
        for (int i = 0; i < input.size(); i++) {
            str += "[";
            LinkedList<Node> ll = input.get(i);
            while (!ll.isEmpty()) {
                Node node = ll.poll();
                str += node.val;
                if (ll.peek() != null)
                    str += ",";
            }
            str += "] ";

        }
        return str + "}";
    }
}
/*
 * Questions:
 * 1.
 * 
 * Ideas:
 * 1.
 * 
 * Edge Cases:
 * 1.
 * 
 * Pros vs. Cons in solutons:
 * 1.
 * 
 * Learned: Different solution, ideas:
 * 1.
 * 
 * Mistakes:
 * 1.
 */
