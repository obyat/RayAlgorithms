package Chapter4.Trees;

import DataStructures.Trees.BinaryTree.BinaryTree;
import DataStructures.Trees.BinaryTree.Node;
import Generic.TESTSUIT;

public class FirstCommonAncestor {

    /*
     * Chapter: 3, Question: 8.
     * Given two nodes, design an algorithm and write code to find the first
     * common/duplicate ancestor of two nodes in a binary tree. Avoid storing
     * additional nodes in a data structure. NOTE: This is not necessarily a binary
     * search tree.
     * 
     * Hints: 26 47 60 85 125 133
     */

    // Runtime: O(n1.path + n2.path) time, O(Math.abs(n1, n2)) stack
    public static Node<Integer> firstCommonAncestor(Node<Integer> n1, Node<Integer> n2) {
        if (n1 == null && n2 == null || n1.getParent() == null && n2.getParent() == null)
            return n1;
        else if (n1.getParent() != null && n2.getParent() == null)
            return n1.getParent();
        else if (n2.getParent() != null && n1.getParent() == null)
            return n2.getParent();

        int n1Height = getNodeHeight(n1);
        int n2Height = getNodeHeight(n2);

        if (n1Height < n2Height) {
            Node<Integer> tempNode = n1;
            int tempHeight = n1Height;

            n1 = n2;
            n2 = tempNode;

            n1Height = n2Height;
            n2Height = tempHeight;
        }

        while ((n1Height - n2Height) > 0) {
            n1Height--;
            n1 = n1.getParent();
        }

        while (n1 != n2 && n1 != null && n2 != null) {
            n1 = n1.getParent();
            n2 = n2.getParent();
        }
        return n1;
    }

    public static int getNodeHeight(Node<Integer> node) {
        int height = 0;
        while (node.getParent() != null) {
            node = node.getParent();
            height++;
        }
        return height;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<Integer>();
        Node<Integer> root = new Node<Integer>(5);
        root.leftChild = new Node<Integer>(3);
        root.rightChild = new Node<Integer>(1);
        root.leftChild.parent = root;
        root.rightChild.parent = root;

        root.leftChild.leftChild = new Node<Integer>(7);
        root.leftChild.rightChild = new Node<Integer>(2);
        root.leftChild.leftChild.parent = root.leftChild;
        root.leftChild.rightChild.parent = root.leftChild;

        root.rightChild.leftChild = new Node<Integer>(9);
        root.rightChild.rightChild = new Node<Integer>(6);
        root.rightChild.leftChild.parent = root.rightChild;
        root.rightChild.rightChild.parent = root.rightChild;

        root.leftChild.leftChild.leftChild = new Node<Integer>(15);
        root.leftChild.leftChild.rightChild = new Node<Integer>(3);
        root.leftChild.leftChild.leftChild.parent = root.leftChild.leftChild;
        root.leftChild.leftChild.rightChild.parent = root.leftChild.leftChild;

        root.rightChild.rightChild.leftChild = new Node<Integer>(4);
        root.rightChild.rightChild.rightChild = new Node<Integer>(8);
        root.rightChild.rightChild.leftChild.parent = root.rightChild.rightChild;
        root.rightChild.rightChild.rightChild.parent = root.rightChild.rightChild;

        root.leftChild.rightChild = new Node<Integer>(2);
        root.leftChild.rightChild.parent = root.leftChild;
        root.leftChild.rightChild.leftChild = new Node<Integer>(14);
        root.leftChild.rightChild.leftChild.parent = root.leftChild.rightChild;

        TESTSUIT.assertTest(firstCommonAncestor(root.leftChild, root.rightChild).getData(), "bt: (3, 1)", 5);
        TESTSUIT.assertTest(firstCommonAncestor(root.leftChild, root.leftChild.rightChild.leftChild).getData(),
                "bt: (7, 14)", 3);
        TESTSUIT.assertTest(firstCommonAncestor(root.rightChild.leftChild, root.rightChild.rightChild).getData(),
                "bt: (9, 6)", 1);

        TESTSUIT.assertTest(
                firstCommonAncestor(root.leftChild.leftChild, root.rightChild.rightChild.leftChild).getData(),
                "bt: (15, 8)", 5);

    }

    public static void print(Object o) {
        System.out.println(o.toString());
    }
}
/*
 * Questions:
 * 1. Can the nodes have the same parent?
 * 2.
 * 
 * Ideas:
 * 1. Sort the tree into a binary search tree and find the first equal node when
 * inserting into a new tree
 * 2. O(n^2) each node to all ancestors of the other node
 * Start from node and count height until no parent exists. Then repeat for
 * other node (using getHeight method)
 * Take the longer node and make it its own parent using node = node.parent
 * until they height difference is 0. Then traverse both nodes up the tree until
 * the parent is the same O(1) memory O(n) time
 * 
 * Edge Cases:
 * 1. Empty tree
 * 2. tree composed of same nodes
 * 
 * Pros vs. Cons in solutons:
 * 1.
 * 
 * Learned: Different solution, ideas:
 * 1.
 * 
 * Mistakes:
 * 1. Mistook n1/n2 for n1Height/n2Height
 */
