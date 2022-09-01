package Chapter4.Trees;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class GetRandomNode {
    /*
     * Chapter: 4, Question: 11.
     * You are implementing a binary tree class from scratch which, in addition to
     * insert,find and delete, has a method getRandomNode() which return a random
     * node from the tree. All nodes should be equally likely to be chosen. Design
     * and implement and algorithm for getRandomNode, and explain how you would
     * implement the rest of the methods.
     * 
     * Hints: 42, 54, 62, 75, 89, 99, 112, 119
     */

    class TreeNode {
        private int data;
        public TreeNode left;
        public TreeNode right;
        private int size = 0;

        public TreeNode(int d) {
            data = d;
            size = 1;
        }

        public int size() {
            return this.size;
        }

        public int data() {
            return this.data;
        }

        public TreeNode getRandomNode() {

            if (left != null) {
                print("on node: " + this.data());
                print("left is node: " + left.data());
                print("size of left: " + left.size());
                print("total size of tree is " + size);
                print("");
            }
            int leftSize = left == null ? 0 : left.size();
            Random random = new Random();
            int index = random.nextInt(size);
            if (index < leftSize)
                return left.getRandomNode();
            else if (index == leftSize) {
                print("Random node: ");
                return this;
            } else
                return right.getRandomNode();
        }

        public void insertInOrder(int d) {
            if (d <= data) {
                if (left == null)
                    left = new TreeNode(d);
                else
                    left.insertInOrder(d);
            } else {
                if (right == null)
                    right = new TreeNode(d);
                else
                    right.insertInOrder(d);
            }
            // since we traverse on left.insertInOrder(int) => data/size refer to left's
            // instance which gets incremented
            size++;
        }

        public void insertAll(Integer[] array) {
            Iterator<Integer> it = Arrays.asList(array).iterator();
            while (it.hasNext()) {
                insertInOrder((int) it.next());

            }
        }

        public TreeNode find(int d) {
            if (d == data) {
                return this;
            } else if (d <= data) {
                return left == null ? null : left.find(d);
            } else if (d > data) {
                return right == null ? null : right.find(d);
            }
            return null;
        }

        public void inOrderTraversla(TreeNode node) {
            if (node == null)
                return;
            inOrderTraversla(node.left);
            print(node.data());
            inOrderTraversla(node.right);
        }

    }

    public static void main(String[] args) {
        TreeNode bt = new GetRandomNode().new TreeNode(10);
        bt.insertAll(new Integer[] { 15, 6, 4, 7, 9, 12, 20, 18, 23, 78 });
        // bt.insertAll(new Integer[] { 2, 18 });

        print("Traversing tree...");
        bt.inOrderTraversla(bt);
        print("");

        print(bt.getRandomNode().data());
        print(bt.getRandomNode().data());
        print(bt.getRandomNode().data());
        print(bt.getRandomNode().data());
        print(bt.getRandomNode().data());
        print(bt.getRandomNode().data());
        print(bt.getRandomNode().data());
        print(bt.getRandomNode().data());
        print(bt.getRandomNode().data());
        print(bt.getRandomNode().data());
        print(bt.getRandomNode().data());
        print(bt.getRandomNode().data());
        print(bt.getRandomNode().data());
        print(bt.getRandomNode().data());
        print(bt.getRandomNode().data());
    }

    public static void print(Object o) {
        System.out.println(o.toString());
    }
}
/*
 * Questions:
 * 1. Are we okay with exapnding storage space by O(n) + O(2) for storing an
 * additional variable named index for current index of node and one singular
 * variable length in the Node class to get Math.Random(0, length). Index is
 * maintained according to InOrder traversal and obtained as such in O(logn)
 * search according to wehther it is less than, equal, or greater than current
 * index until given index is found.
 * 
 * Ideas:
 * 1. Add index variable and choose between them
 * 
 * Edge Cases:
 * 1.length == 0 for root?
 * 
 * Pros vs. Cons in solutons:
 * 1. Storing additional O(n) for each variable vs a solution to iterate the
 * entire tree and find a random index in O(n)
 * 
 * Learned: Different solution, ideas:
 * 1. The implementation relies on picking a random number within the range of
 * nodes or root.size/length of tree, then if the seclected range is greater
 * than the length of left subtree, it picks another random number number within
 * the range of the *rightsubtree and same for left. If range picked equals the
 * side of the leftsubtree then the current node/root is returned
 * 
 * 2. Inserting with size as given above allows each node to increment its size
 * when a new node traverses it to be inserted as its child. for example,
 * inserting a node into root increments root.size = 2, and new node's size to
 * 1. Then inserting another child to that would incrmenet both. Root.size = 3,
 * parent.size = 2, new child.size = 1. In this implementation every parent
 * knows the size of its children.
 * 
 * 3. Practiced Breakpoints and debugging
 * 
 * Mistakes:
 * 1. Came up with easy solution that was slow ==> needed to improve it
 */
