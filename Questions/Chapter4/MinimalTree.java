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
        if (arr.length <= 0)
            return null;
        Node root = new Node(arr[0]);
        root.left = new Node(10);
        root.right = new Node(arr[2]);
        return root;
        // return constructMinimalTree(arr, root, 1);
    }

    private static Node constructMinimalTree(int[] arr, Node root, int index) {
        if (index >= arr.length - 1 || root == null)
            return null;

        if (arr[index] < root.val) {
            root.left = new Node(arr[index]);
            return constructMinimalTree(arr, root.left, index + 1);
        }

        root.right = new Node(arr[index]);
        return constructMinimalTree(arr, root.right, index + 1);
    }

    public static void main(String[] args) {
        int[] t0 = {};
        Node t0a = null;

        int[] t1 = { 1, 2, 3 };
        Node t1a = new Node(1);
        t1a.left = new Node(2);
        t1a.right = new Node(3);

        int[] t2 = { 1, 2, 3, 4, 5 };

        TESTSUIT.assertTest(minimalTree(t0), Arrays.toString(t0), t0a);
        TESTSUIT.assertTest(minimalTree(t1), Arrays.toString(t1), t1a);
        // TESTSUIT.assertArray2DTest(matrix1Rotated, "matrix10", matrix1Rotated);
        // System.out.println();

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
