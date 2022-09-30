package Chapter5;

import java.util.Arrays;

import Generic.TESTSUIT;

// import Chapter2.LinkedLists.DllNode;
// import Chapter2.LinkedLists.DoublyLinkedList ;

public class NextNumber {

    /*
     * Chapter: 5, Question: 4.
     * Given a positive integer, print the next smallest and the next largest number
     * that have the same number of 1 bits in their binary representation.
     * Hints: 147, 175, 242, 312, 339, 358, 375, 390.
     *
     * 6: 0110
     * 5: 0101
     * 3: 0011
     * 
     * 19: 0001 0011
     * 14: 0000 1110
     * 13: 0000 1101
     * 
     * 11: 0000 1010
     * 9: 0000 1001 -> flip right most -> 1011
     * 
     * 10: 0000 1010 -> flip rightmost nontrailing zero -> 1110 ->
     * 
     * flip rightmost 1 to make it smallest -> 1100 -> 12
     * 
     */

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

    public static int getNext(int n) {
        int c = n;
        int count0s = 0;
        int count1s = 0;

        while (((c & 1) == 0) && (c != 0)) {
            count0s++;
            c >>= 1;
        }

        while ((c & 1) == 1) {
            count1s++;
            c >>= 1;
        }

        if (count0s + count1s == 31 || count0s + count1s == 0)
            return -1;

        int p = count0s + count1s; // position of rightmost non-trailing zero;

        n |= (1 << p); // flip rightmost non-trailing zero which is p
        n &= ~((1 << p) - 1); // clear all bits to the right of p
        n |= (1 << (count1s - 1)) - 1; // insert (count1s - 1) ones to the right also keeping zeros in between

        return n;
    }

    // 1110
    // 1101
    public static int getPrev(int n) {
        int c = n;
        int count0s = 0;
        int count1s = 0;

        while ((c & 1) == 1) {
            count1s++;
            c >>= 1;
        }

        if (c == 0)
            return -1;

        while (((c & 1) == 0) && c != 0) {
            count0s++;
            c >>= 1;
        }

        if (count0s + count1s == 31 || count0s + count1s == 0)
            return -1;

        int p = count0s + count1s; // position of rightmost non-trailing zero;
        n &= ((~0) << (p + 1)); // clear bits 0 through p
        int makeOnes = (1 << (count1s + 1)); // 0s with 1 at poisiton p + 1
        makeOnes = makeOnes - 1; // 0s followed by count1s + 1 ones
        makeOnes = makeOnes << (count0s - 1); // shift the ones by number of zeros - 1 to compensate
        n |= makeOnes; // retain the 1 flipped to zeros and the middle 1s
        return n;
    }

    public static void testGetNext() {
        print(">>>>>>>>>>>>>>>>>>>>>>>>>GetNext<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        int num = 13948;
        int count0s = 2;
        int count1s = 5;
        int p = 7;
        int n = 13948;
        String bNum = decimalToBinary(num);

        print("original num: " + n);
        print("original bNum: " + bNum);
        print("---------------------------------------------------------------\n");

        int a = 1 << p;
        int b = a - 1;
        int mask = ~b;

        print("a: " + decimalToBinary(a));
        print("b: " + decimalToBinary(b));
        n |= a; // flip the single bit at p to on and keep everything else the same!
        print("n |= a: " + decimalToBinary(n));
        n &= mask; // turn off all right bits of p
        print("mask: " + decimalToBinary(mask));
        print("n &= mask: " + decimalToBinary(n));

        print("n &= ~((1<<p) -1) with p bit turned on, and to right of p off: " + decimalToBinary(n));

        print("---------------------------------------------------------------\n");
        a = 1 << (count1s - 1); // turn on one less number of 1s to compensate for turning on p
        b = a - 1;
        n |= b; // turn on the needed number of 1s from initial index 0
        print("a: " + decimalToBinary(a));
        print("b: " + decimalToBinary(b));
        print("final bNum: " + decimalToBinary(n));
        print("final n: " + BinaryToDecimal(decimalToBinary(n)));
        print("---------------------------------------------------------------\n");
        /*
         * Summary: Turn on first nontrailing zero, turn on ones to its right (one less
         * 1s to compensate for turning on p) and turn off everything to make zeros in
         * between. Everything to the left of p stays the same
         */

        print("");

    }

    public static void testGetPrev() {
        print(">>>>>>>>>>>>>>>>>>>>>>>>>GetPrev<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        int num = 10115;
        int count0s = 5;
        int count1s = 2;
        int p = 7;
        int n = 10155;
        String bNum = decimalToBinary(num);

        print("original num: " + n);
        print("original bNum: " + bNum);
        print("---------------------------------------------------------------\n");
        // turn off 0 through p bits
        int a = ~0; // all ones
        int b = a << (p + 1); // shift 1's 8 bits cause p is 7. Everything ot the left of p remains

        print("a: " + decimalToBinary(a));
        print("b: " + decimalToBinary(b));
        n &= b; // clear bits 0 through p
        print("clear bits 0 through p using n &= b: " + decimalToBinary(n));

        print("---------------------------------------------------------------\n");
        a = 1 << (count1s + 1); // 0s with 1 at poisiton p + 1
        b = a - 1; // 0s followed by count1s + 1 ones
        int c = b << (count0s - 1); // shift the ones to the left by number of zeros - 1 to compensate
        n |= c; // retain the 1 flipped to zeros and the middle 1s
        print("a: " + decimalToBinary(a));
        print("b: " + decimalToBinary(b));
        print("c: " + decimalToBinary(c));
        print("final bNum: " + decimalToBinary(n));
        print("final n: " + BinaryToDecimal(decimalToBinary(n)));
        print("---------------------------------------------------------------\n");
        /*
         * Summary: Flip rightmost non-trailing one to zero at position p = count1s +
         * count0s.
         * clear all bits to the right of bit p
         * make count1s + 1 ones and shift them to the right of p then | with n
         * rest will be zeros to the right
         */
    }

    public static void main(String[] args) {
        testGetNext();
        testGetPrev();
        print(getNext(8));
        print(getNext(6));
        print(getNext(14));
        print("");
        print(getPrev(16));
        print(getPrev(9));
        print(getPrev(19));
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
 * 1. Iterate from last 1 bit to the left and flip next 0 index 0 bits.
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
