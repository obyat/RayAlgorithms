import java.lang.Math;

public class BitOperations {

    public static void binaryNumbers() {
        System.out.println("binary Numbers:\n");
        // 2^5 2^4 2^3 2^2 2^1 2^0
        // 32 16 8 4 2 1
        System.out.println("3 in binary is " + binary(3)); // 0 0000 0011
        System.out.println("27 in binary is " + binary(27)); // 0 0001 1011
        System.out.println("-3 in binary is " + binary(-3)); // 1 0000 0011
        System.out.println("binary 7 is: " + binary(7));
        System.out.println("binary -15 is: " + binary((byte) -15));

        /*
         * byte data type: uses an 8 bits
         * short data type: uses an 16 bits
         * int data type: uses an 32 bits
         */
        byte n = 2;
        System.out.println("byte n=2 is: " + n);
        System.out.println("byte n=2 in binary is: " + binary(n));

        System.out.println("18 in binary is " + binary(18));

    }

    public static void bitOps() {
        System.out.println("bitOps:\n");

        // AND &
        System.out.println("5&6 is: " + (5 & 6)); // 0101 &
                                                  // 0110
                                                  // = 0100 = 4

        // OR |
        System.out.println("7|2 is: " + (7 | 2)); // 0111
                                                  // 0010
                                                  // = 0111 = 7

        // XOR (each must have exactly a single T value to be T)
        System.out.println("5^3 is: " + (5 ^ 3)); // 0101
                                                  // 0011
                                                  // = 0110 = 6

    }
    // SHIFT
    // MASKING
    // TURNING ON A BIT/TURNING OFF ETC.
    // 2 programs

    public static String binary(int i) {
        return Integer.toBinaryString(i);
    }

    public static void negativePositiveBinaryNums() {
        System.out.println("Positive vs. Negative:\n");
        // 8 bits: 0000 0000
        // 8th bit represents sign. 0 = positive, 1 = negative

        // READING NEGATIVE NUMBER = 1 0100
        // -16 4 = -12
        // Note: 1 + 1 = 10

        // Storing positive and negative 4 in binary bits
        // 4 =  0000 0100 = 4
        // ones~4 =  1111 1011 = -16 + 8 + 2 + 1 = -16 + 11 = -5 (invert all numbers)
        // twos~4 =  1111 1011 + 1 = 1 1111 1100 = -16 + 12 = -4 (add 1 to inverted
        // numbers)
        // ones~4 = -5 = ~4
        // twos~4 = -4 = ~3
        System.out.println("ones compliment of ~4 should be -5: " + ~4);
        System.out.println("two's compliment of 4 should -4 : " + ((~4) + 1));
        System.out.println();

        // Storing positive and negative 5 in binary bits
        // 5 = 0 0000 0101
        // ones~5 =  1111 1010 = 10 = -16 + 8 + 2 = -6
        // twos~5 =  1111 1010 + 1 = 1 1111 1011 = -16 + 8 + 2 + 1= -16 + 11 = -5
        // ones~5 = -6 = ~5
        // twos~5 = -5 = ~4
        System.out.println("ones compliment of ~5 should be -6: " + ~5);
        System.out.println("two's compliment of 5 should -5: " + ((~5) + 1));
        System.out.println();
    }

    public static void bitShifts() {
        System.out.println("Bit Shifting:\n");

        //23 =  10111
        System.out.println("binary of 23 is: " + binary((short) 23));
        
        // 23 << left shift = 46 (23 * 2)
        //23 =  0010 1110 = 32 + 2 + 4 + 8 = 46
        System.out.println("binary of 23<<1 should be 0010 1110 which is 46: " + binary((short) (23<<1)) + " = " +  (short) (23<<1));

        // 23 >> right shift = 12 (23 / 2)
        //23 =  0010 1110 = 32 + 2 + 4 + 8 = 46
        System.out.println("binary of 23<<1 should be 0010 1110 which is 46: " + binary((short) (23<<1)) + " = " +  (short) (23<<1));
    }
    public static void main(String[] args) {
        binaryNumbers();
        System.out.println();
        bitOps();
        System.out.println();
        negativePositiveBinaryNums();
        System.out.println();
        bitShifts();
    }
}