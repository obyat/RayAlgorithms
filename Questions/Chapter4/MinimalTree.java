package Chapter4;

import Generic.TESTSUIT;

import java.util.Arrays;

import Chapter4.Node;

public class MinimalTree {

    /*
     * Chapter: 4, Question: 2.
     * Given a sorted (increasing order) array with unique
     * integer elements, write an algorithm to create a binary search
     * tree with minimal height.
     * 
     * Hints: 19 73 116
     */

    // Runtime:
    public static Node minimalTree(int[] arr) {
        if (arr.length == 0)
            return null;
        return constructMinimalTree(arr);
    }

    public static Node constructMinimalTree(int[] arr) {
        int len = arr.length;
        if (len == 0)
            return null;
        int mid = len / 2;

        Node root = new Node(arr[mid]);
        if (len > 1) {
            root.left = constructMinimalTree(Arrays.copyOfRange(arr, 0, mid));
            root.right = constructMinimalTree(Arrays.copyOfRange(arr, ++mid, len));
        }
        return root;
    }

    public static void main(String[] args) {
        int[] t0 = {};
        Node t0a = null;

        int[] t1 = { 1, 2, 3 };
        Node t1a = new Node(2);
        t1a.left = new Node(1);
        t1a.right = new Node(3);

        int[] t10 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Node t10a = new Node(5);
        t10a.left = new Node(2);
        t10a.right = new Node(8);

        t10a.left.left = new Node(1);
        t10a.left.right = new Node(4);

        t10a.left.left.left = new Node(0);
        t10a.left.right.left = new Node(3);

        t10a.right = new Node(8);
        t10a.right.left = new Node(7);
        t10a.right.right = new Node(10);

        t10a.right.left.left = new Node(6);
        t10a.right.right.left = new Node(9);

        int[] t2 = { 1, 2, 3, 4, 5 };
        System.out.println("Check: " + TESTSUIT.compareNodes(t1a, t1a));
        TESTSUIT.assertTest(minimalTree(t0), Arrays.toString(t0), t0a);
        TESTSUIT.assertTest(minimalTree(t1), Arrays.toString(t1), t1a);
        TESTSUIT.assertTest(minimalTree(t10), Arrays.toString(t10), t10a);
    }
}

/*
 * Questions:
 * 1. is this a balanced tree with height difference of <= 1?
 * 
 * Ideas:
 * 1. use midpoint as root and cut array into left and right segments and repeat
 * 
 * Edge Cases:
 * 1. even/odd arrays => using midpoint formula = start + (end – start)/2 = 0 +
 * (len - 0) / 2 = end/2
 * 
 * Pros vs. Cons in solutons:
 * 1.
 * 
 * Learned: Different solution, ideas:
 * 1. Must review how tree behaves in stack frames!
 * 
 * Mistakes:
 * 1. Stackframes!
 * 
 */
