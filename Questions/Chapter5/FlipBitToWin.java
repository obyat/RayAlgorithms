package Chapter5;

import Generic.TESTSUIT;

// import Chapter2.LinkedLists.DllNode;
// import Chapter2.LinkedLists.DoublyLinkedList ;

public class FlipBitToWin {

    /*
     * Chapter: 5, Question: 3.
     * You have an integer and you can flip exactly one bit from a 0 to a 1. Find
     * the length of the longest sequence of 1s you could create.
     * Hints: 159, 226, 314, 352.
     */

    // Runtime:
    public static int flipBitToWin(String str) {
        int prevCount = 0;
        int count = 0;
        int maxlength = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            } else if (str.charAt(i) == '0') {
                prevCount = count;
                count = 0;
            }
            maxlength = (prevCount + count) >= maxlength ? prevCount + count + 1 : maxlength;
        }
        return maxlength;
    }

    public static String decimalToBinary(int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = 10; i >= 0; i--) {
            if ((x & (1 << i)) != 0)
                sb.append("1");
            else
                sb.append("0");
        }
        return sb.toString();
    }

    public static int flipBitToWinImproved(int x) {
        int prevCount = 0;
        int count = 0;
        int maxlength = 1;
        
        if ((~x) == 0)
            return Integer.BYTES * 8;
        while (x != 0) {
            if ((x & 1) == 1)
                count++;
            else if ((x & 1) == 0) {
                prevCount = (x & 2) == 0 ? 0 : count;
                count = 0;
            }
            maxlength = Math.max(prevCount + count + 1, maxlength);
            x >>>= 1;
        }
        return maxlength;

    }

    public static void main(String[] args) {
        TESTSUIT.assertTest(flipBitToWin(decimalToBinary(1775)), "11011101111", 8);
        TESTSUIT.assertTest(flipBitToWin(decimalToBinary(0)), "0", 1);
        TESTSUIT.assertTest(flipBitToWin("1001"), "1001", 2);
        TESTSUIT.assertTest(flipBitToWin("1011"), "1011", 4);
        print("Improved: \n");
        TESTSUIT.assertTest(flipBitToWinImproved(1775), "11011101111", 8);
        TESTSUIT.assertTest(flipBitToWinImproved(0), "0", 1);
        TESTSUIT.assertTest(flipBitToWinImproved(9), "1001", 2);
        TESTSUIT.assertTest(flipBitToWinImproved(11), "1011", 4);
        TESTSUIT.assertTest(flipBitToWinImproved(15), "11111", 5);
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
 * 1. String implementation: start ithFlipIndex and iterate and count the next
 * 1's until a nother zero occurs. Then update currentMax. Then use
 * LastZeroIndex to continue counting for current 1s. O(n) time O(1) space O(1)
 * stack space. (BCR!)
 * 
 * 2.
 * 
 * Edge Cases:
 * 1. all 1s, all 0s, other characters, maxlength, empty input.
 * 
 * Pros vs. Cons in solutons:
 * 1.
 * 
 * Learned: Different solution, ideas:
 * 1.
 * 
 * Mistakes:
 * 1.
 * 
 * 
 */
