package Chapter5;

import Generic.TESTSUIT;

// import Chapter2.LinkedLists.DllNode;
// import Chapter2.LinkedLists.DoublyLinkedList ;

public class Debugger {

    /*
     * Chapter: 5, Question: 5.
     * Explain what the following code does: ((n & (n - 1)) == 0)
     * Hints: 151, 202, 302, 346, 372, 383, 398
     * Answer: (n & (n - 1)) == 0 checks if n is a power of 2
     */

    // Runtime:
    public static void debugger(String bX, String bY) {
        int x = BinaryToDecimal(bX);
        int y = BinaryToDecimal(bY);
        print("                      checking number: " + x);
        print("bX is: " + bX);
        print("x is: " + x);

        print("bY is: " + bY);
        print("y is: " + y);
        print("x & y: " + decimalToBinary(x & y));
        print("result: " + BinaryToDecimal(decimalToBinary(x & y)));

        print("");
        print("x: " + decimalToBinary(x));
        print("x - 1: " + decimalToBinary(x - 1));
        print("x & (x - 1): " + decimalToBinary(x & (x - 1)));
        print("                      x & (x - 1) == 0: " + ((x & (x - 1)) == 0));
        print("------------------------------------------------------------");
        print("");
    }

    public static String decimalToBinary(int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = 13; i >= 0; i--) {
            // if (i == 6)
            // sb.append(", ");
            if (((1 << i) & x) != 0)
                sb.append("1");
            else
                sb.append("0");
        }
        return sb.toString();
    }

    public static int BinaryToDecimal(String x) {
        if (x.length() <= 0)
            return 0;
        int a = 0;
        int inc = 1;
        for (int i = x.length() - 1; i >= 0; i--) {
            if (x.charAt(i) == '1')
                a = a + Integer.valueOf(inc);
            inc *= 2;
        }
        return a;
    }

    public static void main(String[] args) {
        debugger("1010", "10");
        debugger("0000", "11");
        debugger("0001", "11");
        debugger("0010", "11");
        debugger("0011", "11");
        debugger("0100", "11");
        debugger("0101", "11");
        debugger("0110", "11");
        debugger("0111", "11");
        debugger("1000", "11");
        debugger("1111", "11");

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
 * 1.
 * 
 * Mistakes:
 * 1.
 */
