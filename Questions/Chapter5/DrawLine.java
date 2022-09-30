package Chapter5;

import java.util.Arrays;

import Generic.TESTSUIT;
import Utility.BitwiseUtil;

// import Chapter2.LinkedLists.DllNode;
// import Chapter2.LinkedLists.DoublyLinkedList ;

public class DrawLine {

    /*
     * Chapter: 5, Question: 8.
     * A monochrome screen is stored as a single array of bytes, allowing eight
     * consecutive pixels to be stored in one byte. The screen has width w, where w
     * is divisible by 8 (that is, no byte will be split across rows). The height of
     * the screen, of course, can be derived from the length of the array and the
     * width.
     * Implement a function that draws a horizontal line from (x1, y) to (x2, y).
     * Height is not needed. Y, x1, x2 are given, set pixels from x1 to x2 to on for
     * a solution.
     * Hints: 366, 381, 384, 391
     */
    // Runtime:
    public static boolean drawLine(byte[] screen, int width, int x1, int x2, int y) {
        for (byte b : screen) {
            print(b);
        }
        return true;

    }

    public static boolean drawLineImproved(byte[] screen, int width, int x1, int x2, int y) {
        int startOffSet = x1 % 8;
        int firstFullyByte = x1 / 8;

        if (startOffSet != 0)
            firstFullyByte++;

        int endOffSet = x2 % 8;
        int lastFullByte = x2 / 8;

        if (endOffSet != 7)
            lastFullByte--;

        // set full bytes
        for (int b = firstFullyByte; b <= lastFullByte; b++) {
            screen[(width / 8) * y + b] = (byte) 0xFF;
        }

        // Create masks for start and end of line
        byte startMask = (byte) (0xFF >> startOffSet);
        byte endMask = (byte) ~(0xFF >> (endOffSet + 1));

        // set start and end of line
        if ((x1 / 8) == (x2 / 8)) { // x1 and x2 are in the same byte
            byte mask = (byte) (startMask & endMask);
            screen[(width / 8) * y + (x1 / 8)] |= mask;
        } else {
            if (startOffSet != 0) {
                int byteNumber = (width / 8) * y + firstFullyByte - 1;
                screen[byteNumber] |= startMask;
            }
            if (endOffSet != 7) {
                int byteNumber = (width / 8) * y + lastFullByte + 1;
                screen[byteNumber] |= endMask;
            }
        }

        print(Arrays.toString(screen));
        return true;
    }

    public static void main(String[] args) {
        TESTSUIT.assertTest(drawLine(new byte[] { 1, 2, 3 }, 3, 1, 3, 1), "abc", true);
        TESTSUIT.assertTest(drawLineImproved(new byte[] { 3, 1, 1, 1 }, 4, 1, 3, 2), "abc", true);
        // TESTSUIT.assertArray2DTest(matrix1Rotated, "matrix10", matrix1Rotated);
        print(BitwiseUtil.binaryToDecimal("1 111 1111"));
    }

    public static void print(Object o) {
        System.out.println(o.toString());
    }
}
/*
 * Questions:
 * 1. Revisit problem later
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
 * 1. Byte is -128 to 127 stored in 8 bits: (signed bit 1) 111 1111
 * 
 * Mistakes:
 * 1.
 */
