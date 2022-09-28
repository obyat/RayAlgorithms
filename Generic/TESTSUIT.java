package Generic;

import Chapter2.LinkedLists.DoublyLinkedList;
import Chapter4.Trees.Node;

import java.util.ArrayList;

import Chapter2.LinkedLists.DllNode;
import DataStructures.Stack;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class TESTSUIT {
    // use Arrays.toString(array)
    public static <T> void assertTest(Object input, Object args, Object expected) {
        if (input != null) {
            String inputStr = "";
            String expectedStr = "";    

            // stack
            if (input instanceof Stack) {
                if (((Stack) input).isEmpty() && ((Stack) expected).isEmpty()) {
                    System.out.println("[Passed] " + args);
                    return;
                } else if (((Stack) input).isEmpty()) {
                    System.out.println("[Failed] returned: Empty Stack, for: " + args);
                    return;
                }
                while (!((Stack) input).isEmpty()) {
                    inputStr += String.valueOf(((Stack) input).peek()) + ", ";
                    expectedStr += String.valueOf(((Stack) expected).peek()) + ", ";
                    if (!String.valueOf(((Stack) input).pop()).equals(String.valueOf(((Stack) expected).pop()))) {
                        System.out.println(
                                "[Failed] expected: [" + expectedStr + "], returned: [" + inputStr + "], for: " + args);
                        return;
                    }
                }
                System.out.println("[Passed] " + args);
            }

            // Node
            if (input instanceof Node) {

                if (((Node) input).isEmpty() && ((Node) input).isEmpty()) {
                    System.out.println("[Passed] " + args);
                    return;
                } else if (((Node) input).isEmpty()) {
                    System.out.println("[Failed] returned: Empty Node, for: " + args);
                    return;
                } else if (!(((Node) input).isEmpty()) && !(compareNodes((Node) input, (Node) expected))) {
                    System.out.println(
                            "[Failed] expected: " + nodeToList((Node) expected, new ArrayList()) +
                                    ", returned: " + nodeToList((Node) expected, new ArrayList()) + ", for: "
                                    + args);
                    return;
                }

                System.out.println("[Passed] " + args);
            }

            else if (!input.equals(expected)) {
                System.out.println("[Failed] expected: " + expected + ", returned: " + input + ", for: " + args);
            } else {
                System.out.println("[Passed] " + args);
            }
        } else {
            if (expected == null) {
                System.out.println("[Passed] " + args);
            } else {
                System.out.println("[Failed] expected: " + expected + ", returned: null" + ", for: " + args);
            }
        }

        System.out.println();
    }

    private static String nodeToList(Node node, ArrayList list) {
        if (node == null)
            return list.toString();
        list.add(node.val);
        nodeToList(node.left, list);
        nodeToList(node.right, list);
        return list.toString();
    }

    public static boolean compareNodes(Node input, Node expected) {
        if (input == null && expected == null) {
            return true;
        } else if ((input == null && expected != null) || (input != null && expected == null)) {
            return false;
        }
        return (input.val == expected.val) && compareNodes(input.left, expected.left)
                && compareNodes(input.right, expected.right);
    }

    // requires all methods to return wrapper classes
    public static <T> void assertArray2DTest(T[][] input, Object args, T[][] expected) {
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[0].length; col++) {
                if (input[row][col] != expected[row][col]) {
                    System.out.println("[MY Array Failed] " + args);
                    return;
                }
            }
        }
        System.out.println("[Array Passed] " + args);
    }

    public static void assertTreeTest(Object input, Object args, Object expected) {

    }

    public static DoublyLinkedList createLinkedList(int[] js) {
        if (js.length <= 0)
            return null;
        DllNode node = new DllNode(js[0]);
        DoublyLinkedList list = new DoublyLinkedList(node);
        for (int i = 1; i < js.length; i++)
            list.addToEnd(js[i]);
        return list;
    }
}
