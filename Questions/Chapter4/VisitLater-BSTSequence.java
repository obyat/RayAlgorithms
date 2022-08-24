package Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequence {

    /*
     * Chapter: 4, Question: 9.
     * A binary search tree was created by traversing through an array from left to
     * right and inserting each element. Given a binary search tree with distinct
     * element, print all possible arrays that could have led to this tree.
     * 
     * Tree: (1)<-(2)->(3) = Arrays: {2,1,3}, {2,3,1}
     * Hints:
     */

    // A Binary Tree Node
    static class Node {
        int val;
        Node left;
        Node right;

        // constructor
        Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    // Runtime:
    public static ArrayList<LinkedList<Integer>> allSequences(Node node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
        if (node == null) {
            result.add(new LinkedList<Integer>());
            String resultInitialString = result.toString();
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(node.val); // adding node val as prefix
        String prefixString = prefix.toString();

        // Recurse on left and right subtrees
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        // weave together each list from the left and right sides
        // O(n^2) runtime
        for (LinkedList<Integer> leftLinkedList : leftSeq) {
            for (LinkedList<Integer> rightLinkedList : rightSeq) {
                String left = leftSeq.toString();
                String right = rightSeq.toString();
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
                weaveLists(leftLinkedList, rightLinkedList, weaved, prefix);
                String weaveString = weaved.toString();
                result.addAll(weaved);
                String resulLooptString = result.toString();
                String check = "";
            }
        }

        String resultReturnString = result.toString();
        return result;
    }

    // weave lists together in all possible ways. This removes the head from a one
    // of the lists, recursing, and then doing the same with the other list.
    public static void weaveLists(LinkedList<Integer> firstList, LinkedList<Integer> secondList,
            ArrayList<LinkedList<Integer>> weaved, LinkedList<Integer> prefix) {

        // if one of lists is empty, add remaining list to a cloned prefix and store
        // results
        if (firstList.size() == 0 || secondList.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            String resultPrefixClone = result.toString();

            result.addAll(firstList);
            String resultFirst = result.toString();

            result.addAll(secondList);
            String resultSecond = result.toString();

            weaved.add(result);
            String weavedAll = weaved.toString();

            return;
        }

        // recurse with head of first added to the prefix. Restore head to its original
        // location after
        int headFirst = firstList.removeFirst();
        prefix.addLast(headFirst);
        String prefixHead = prefix.toString();
        String weaveCall = firstList.toString() + ", " + secondList.toString() + ", " + weaved.toString() + ", "
                + prefix.toString();
        weaveLists(firstList, secondList, weaved, prefix);
        prefix.removeLast();
        String prefixRemoveLast = prefix.toString();

        firstList.addFirst(headFirst);
        String firstListString = firstList.toString();

        // recurse with head of second added to the prefix. Restore head to its original
        // location after
        int headSecond = secondList.removeFirst();
        prefix.addLast(headSecond);
        prefixHead = prefix.toString();
        weaveCall = firstList.toString() + ", " + secondList.toString() + ", " + weaved.toString() + ", "
        + prefix.toString();
        weaveLists(firstList, secondList, weaved, prefix);

        secondList.addFirst(headSecond);
        String secondListString = secondList.toString();
    }

    public static void main(String[] args) {
        // Let us create binary tree shown in above diagram
        /*
         * 4
         * / \
         * 3 5
         * / \ \
         * 1 2 6
         */

        Node tree = new Node(4);
        tree.left = new Node(3);
        tree.right = new Node(5);
        tree.left.left = new Node(1);
        tree.left.right = new Node(2);
        tree.right.right = new Node(6);


        ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
        LinkedList<Integer> leftLinkedList = new LinkedList<>();
        LinkedList<Integer> rightLinkedList = new LinkedList<>();
        LinkedList<Integer> prefix = new LinkedList<>();
        leftLinkedList.add(1);
        leftLinkedList.add(2);
        rightLinkedList.add(4);
        rightLinkedList.add(5);
        prefix.add(3);

        weaveLists(leftLinkedList, rightLinkedList, weaved, prefix);

        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
        // result = allSequences(tree);
        print("printing arrays that generate the above tree: \n");

        // for (LinkedList<Integer> list : result)
        //     print(list.toString());

        // print(allSequences(tree).toString());
    }

    public static void print(Object o) {
        System.out.println(o.toString());
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
 * 1. foreach = (Type var such as i : the actual reference) =
 * (ArrayList<Integer> i: Counter)
 * 
 * Mistakes:
 * 1.
 * 
 * Stack vizualizer:
 * https://tinyurl.com/4xu6724w
 */


