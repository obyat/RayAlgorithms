package Chapter4;

import Generic.TESTSUIT;

import DataStructures.Trees.BST.BinarySearchTree;
import DataStructures.Trees.BST.Node;

public class Successor<T extends Comparable<T>> {

    /*
     * Chapter: 4, Question: 6.
     * Write an algorithm to find the "next" node (i.e., in-order successor) of a
     * given node in a binary search tree.
     * You may assume that each node has a link to tis parent.
     * 
     * Hints: 79 91
     */

    // Runtime:
    public Node<T> successor(Node<T> node) {
        if (node == null)
            return node;
        if (node.getRightChild() != null) {
            return getLeftMostChild(node.getRightChild());
        } else {
            Node<T> currNode = node;
            Node<T> parentNode = currNode.getParent();
            while (parentNode != null && parentNode.getLeftChild() != currNode) {
                currNode = parentNode;
                parentNode = parentNode.getParent();
            }
            return parentNode;
        }
    }

    public Node<T> getLeftMostChild(Node<T> node) {
        if (node == null)
            return node;
        while (node.getLeftChild() != null)
            node = node.getLeftChild();
        return node;
    }

    public static void main(String[] args) {
        Successor<Integer> s1 = new Successor<>();
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.insertAll(new Integer[] { 7, 2, 9, 1, 5, 14 });
        Node<Integer> node9 = bst.search(bst.root, 9);
        Node<Integer> node5 = bst.search(bst.root, 5);
        Node<Integer> node1 = bst.search(bst.root, 1);
        Node<Integer> node14 = bst.search(bst.root, 14);

        TESTSUIT.assertTest(s1.successor(node9).getData(), "node 9", 14);
        TESTSUIT.assertTest(s1.successor(node5).getData(), "node 5", 7);
        TESTSUIT.assertTest(s1.successor(node1).getData(), "node 1", 2);
        TESTSUIT.assertTest(s1.successor(node14), "node 14", null); // null

        BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();

        bst2.insertAll(new Integer[] { 9, 4, 17, 3, 6, 5, 7, 17, 22, 20 });
        Node<Integer> node7 = bst2.search(bst2.root, 7);
        Node<Integer> node20 = bst2.search(bst2.root, 20);
        Node<Integer> node3 = bst2.search(bst2.root, 3);
        Node<Integer> node22 = bst2.search(bst2.root, 22);

        TESTSUIT.assertTest(s1.successor(node7).getData(), "node 7", 9);
        TESTSUIT.assertTest(s1.successor(node20).getData(), "node 20", 22);
        TESTSUIT.assertTest(s1.successor(node3).getData(), "node 3", 4);
        TESTSUIT.assertTest(s1.successor(node22), "node 22", null); // null

    }

    public static void print(String s) {
        System.out.println(s);
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
