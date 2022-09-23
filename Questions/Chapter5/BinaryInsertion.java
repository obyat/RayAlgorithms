package Chapter5;

import java.util.ArrayList;

import Generic.TESTSUIT;

// import Chapter2.LinkedLists.DllNode;
// import Chapter2.LinkedLists.DoublyLinkedList ;

public class BinaryInsertion {

    /*
     * Chapter: 5, Question: 1.
     * You are given tw 32 bit numbers N and M and two bit poisitons, i and j. Write
     * a method to insert M into N such that M starts at bit j and ends at bit i.
     * You can assume that the bits j through i have enough space to fit all of M.
     * Example: N = 110000000000 M 10011, i = 2, j = 6. Output: N = 110001001100
     * Hints:
     */

    // Runtime:
    public static int binaryInsertion(int N, int M, int j, int i) {
        M = (M << i);
        for (; i <= j; i++)
            N = (N & (~(1 << i)));
        return Integer.valueOf(binaryRepresentation(M | N));

    }

    public static int binaryInsertionInproved(int N, int M, int j, int i) {
        int allOnes = ~0;
        int left = allOnes << (j + 1); // moves 1's into correct place
        int right = ((1 << i) - 1); // ones after i
        int mask = left | right;
        N = N & mask;
        M = M << i;
        return Integer.valueOf(binaryRepresentation(M | N));

    }

    // // (x & (~(1 << i)))
    // public static long clearithBitVal(int x, int i) {
    // return (x & (~(1 << i))); // turn 1000 into 0111 then & to make it ith bit
    // zero
    // }

    static String binaryRepresentation(int x) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> binary = new ArrayList<>();

        while (x != 0) {
            binary.add(x % 2);
            x /= 2;
        }

        for (int j = binary.size() - 1; j >= 0; j--) {
            sb.append(binary.get(j));
        }
        return sb.toString();
    }
    //

    static int binaryToDecimal(int binary) {
        String b = String.valueOf(binary);
        int v = 1;
        int sum = 0;
        for (int i = b.length() - 1; i >= 0; i--) {
            if (b.charAt(i) == '1')
                sum += v;
            v *= 2;
        }
        return sum;
    }

    public static void main(String[] args) {

        TESTSUIT.assertTest(binaryInsertion(binaryToDecimal(100000000), binaryToDecimal(10011), 6, 2), "101001100",
                101001100);

        TESTSUIT.assertTest(binaryInsertionInproved(binaryToDecimal(100000000), binaryToDecimal(10011), 6, 2),
                "101001100",
                101001100);
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
 * 1. clear the bits in given range.
 * 2. use | to set the necessary bit
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
 * 1. Forgot that numbers sent in as ints are not binary and require conversion
 * 2. overlooked i incremented after for loop and shifting by i was incremented
 */
