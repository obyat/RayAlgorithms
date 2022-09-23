package Chapter5;

public class BitOps {

    // index starts at zero
    public static boolean getithBitVal(int x, int i) {
        return (0 != (x & (1 << i)));
    }

    // index starts at zero
    public static int setithBitVal(int x, int i) {
        return (x | (1 << i));
    }

    // index starts at zero
    public static int clearithBitVal(int x, int i) {
        return (x & (~(1 << i))); // turn 1000 into 0111 then & to make it ith bit zero
    }

    // to clear all bits from MSB through i, create a mask with 1 at the ith bit
    // with (1 << i) then subtract 1 from it giving us 0's followed by i 1s then AND
    // with x to leave the last i bits unchanged
    // clear from MSB to i
    public static int clearBitsStartingFromMSBThroughi(int x, int i) {
        return x & ((1 << i) - 1);
    }

    // clear from i to 0
    // -1 is 11111111111
    // shift it to left by i creating trailing 0's from i
    // & to only change trailing digitits to the right of i
    public static int clearBitsiThroughZero(int x, int i) {
        return x & (-1 << (i + 1)); // shift 11111 to left by i + 1 bits
    }

    // change 10 to 8
    // make 1 which is 0010 then ~ to become 1101
    // & with x to flip bit at x location
    /*
     * example
     * 1010
     * &
     * 1101
     * ----
     * 1000
     * or with the val to change it to 1 if 0, or change it to 0 from 1
     * 1000
     * |
     * 0000
     * ----
     * 1000
     * = 8
     */

    public static int updateBit(int x, int i, int bitVal) {
        return (bitVal << i) | (x & ~(1 << i));

    }

    public static void main(String[] args) {
        print(getithBitVal(8, 3)); // 1000
        print(setithBitVal(0, 0)); // turn on 0th bit for 0000 will become 0001 = 1
        print(setithBitVal(0, 2)); // turn on 2nd bit for 0000 will become 0100 = 4
        print(clearithBitVal(8, 3)); // becomes 0
        print(clearBitsStartingFromMSBThroughi(1, 1)); // clear all bits excep the ith bit which is 1 returns 1
        print(clearBitsStartingFromMSBThroughi(1, 0)); // clear all bits including 0th bit returns 0
        print(clearBitsStartingFromMSBThroughi(8, 0)); // clear all bits including 0th bit returns 0
        print(clearBitsiThroughZero(8, 2)); // clearing all 0's behind 8 doesnt change its value
        print(clearBitsiThroughZero(15, 1)); // clearing all 0's behind 2nd index subtracts 3 from x
        print(updateBit(10, 1, 0)); // 1000 + 0001 = 8 + 1 = 9
           print(updateBit(10, 1, 0)); // 1000 + 0001 = 8 + 1 = 9

    }

    public static void print(Object o) {
        System.out.println(o.toString());
    }
}
