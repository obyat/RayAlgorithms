package Chapter5;

import Generic.TESTSUIT;
import Utility.BitwiseUtil;

public class PairwiseSwap {

    /*
     * Chapter: 5, Question: 6.
     * Write a program to swap odd and even bits in an integer with as few
     * instructions as possible. E.g. bit 0 and 1 are swapped, bit 2 and bit 3 are
     * swapped, and so on.
     * Hints: 145, 248, 328, 355.
     */

    // Runtime: O(b) runtime, O(1) stackspace, O(1) space where b = number of bits
    public static String pairwiseSwap(String str) {
        int x = BitwiseUtil.binaryToDecimal(str);
        if (x < 1)
            return BitwiseUtil.decimalToBinary(x);

        int xCopy = x;
        int i = 0;
        while (x != 0) {
            if ((x & 1) != ((x >> 1) & 1)) {
                xCopy = ((x & 1) << (i + 1)) | (xCopy & ~(1 << (i + 1)));
                xCopy = (((x >> 1) & 1) << i) | (xCopy & ~(1 << i));
            }
            i += 2;
            x >>= 2;
        }
        return BitwiseUtil.decimalToBinary(xCopy);
    }

    public static String pairwiseSwapImproved(String str) {
        int x = BitwiseUtil.binaryToDecimal(str);

        x = (((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1));

        return BitwiseUtil.decimalToBinary(x);
    }

    public static void test(int x) {
        print("                     testing int: " + x);
        print("binary x: " + BitwiseUtil.decimalToBinary(x));
        print("");

        print("Create mask for getting odd bits:");
        print("0xa:       " + BitwiseUtil.decimalToBinary(0xaaaaaaaa));
        print("Create mask for getting even bits:");
        print("0x5:       " + BitwiseUtil.decimalToBinary(Integer.decode("0x55555555")));
        print("");

        print("After getting the even and odd bits, shift them so they would be in reverse positions");
        print("0xa >>> 1: " + BitwiseUtil.decimalToBinary((0xaaaaaaaa >>> 1)));
        print("0x5 << 1:  " + BitwiseUtil.decimalToBinary((0x55555555 << 1)));
        print("");

        print("x & 0xa: " + BitwiseUtil.decimalToBinary((x & 0xaaaaaaaa)));
        print("x & 0x5: " + BitwiseUtil.decimalToBinary((x & 0x55555555)));
        print("");

        print("Apply both masks:");
        print("x & 0xa >>> 1: " + BitwiseUtil.decimalToBinary((x & 0xaaaaaaaa) >>> 1)); // fill in 0 in msb
        print("x & 0x5 << 1:  " + BitwiseUtil.decimalToBinary((x & 0x55555555) << 1));
        print("");

        print("Use | to combine the result of both masks:");
        print("x & 0xa | x & 0x5: " + BitwiseUtil.decimalToBinary((x & 0xaaaaaaaa) >>> 1 | (x & 0x55555555) << 1));
        print("--------------------------------------------------------------\n");

    }

    public static void main(String[] args) {
        TESTSUIT.assertTest(pairwiseSwap("1111"), "0000 0000 1111", "0000 0000 1111");
        TESTSUIT.assertTest(pairwiseSwap("1010"), "0000 0000 1010", "0000 0000 0101");
        TESTSUIT.assertTest(pairwiseSwap("0000"), "0000 0000 0000", "0000 0000 0000");
        TESTSUIT.assertTest(pairwiseSwap("0011"), "0000 0000 0011", "0000 0000 0011");
        print("Improved: \n");
        TESTSUIT.assertTest(pairwiseSwapImproved("1111"), "0000 0000 1111", "0000 0000 1111");
        TESTSUIT.assertTest(pairwiseSwapImproved("1010"), "0000 0000 1010", "0000 0000 0101");
        TESTSUIT.assertTest(pairwiseSwapImproved("0000"), "0000 0000 0000", "0000 0000 0000");
        TESTSUIT.assertTest(pairwiseSwapImproved("0011"), "0000 0000 0011", "0000 0000 0011");
        print("--------------------------------------------------------------\n");

        test(10);
        test(15);
        test(5);

    }

    public static void print(Object o) {
        System.out.println(o.toString());
    }
}

/*
 * Questions:
 * 1. uneven number of elements? such that an odd cannot be swapped with an even
 * number
 * 
 * Ideas:
 * 1. while x != 1 right shift it twice and use getBit() to if they are
 * different they are swapped
 * using not gate
 * 
 * Edge Cases:
 * * 2. empty input or negative number
 * 3. MaxInt?
 * 4. what about 0 and 1? 0 is even, 1 is odd.
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
