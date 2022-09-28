package Chapter5;

import Generic.TESTSUIT;

// import Chapter2.LinkedLists.DllNode;
// import Chapter2.LinkedLists.DoublyLinkedList ;

public class Conversion {

    /*
     * Chapter: 5, Question: 6.
     * Write a function to determine the number of bits you would need to flip to
     * convert inter A to integer B.
     * Hints:336, 369
     */

    // Runtime:
    public static int converstion(int x, int y) {
        int z = 0;
        int numSwaps = 0;

        if (x > y)
            z = x;
        else {
            z = y;
            y = x;
        }

        print(decimalToBinary(x));
        print(decimalToBinary(y));
        print(decimalToBinary(x ^ y));

        while (z != 0) {
            if (((z & 1) != (y & 1)))
                numSwaps++;
            z >>= 1;
            y >>= 1;
        }

        while (y != 0) {
            numSwaps++;
            y >>= 1;
        }
        return numSwaps;
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

    public static int bitSwapRequired(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c >>= 1) {
            count += c & 1;
        }
        return count;
    }

    public static void main(String[] args) {
        TESTSUIT.assertTest(converstion(29, 15), "29, 15", 2);
        TESTSUIT.assertTest(converstion(15, 29), "15, 29", 2);

        TESTSUIT.assertTest(bitSwapRequired(29, 15), "29, 15", 2);
        TESTSUIT.assertTest(bitSwapRequired(15, 29), "15, 29", 2);
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
