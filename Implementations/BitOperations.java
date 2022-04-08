import java.lang.Math;

public class BitOperations {

    public static void binaryNumbers() {
        System.out.println("binary Numbers:\n");
        // 2^5 2^4 2^3 2^2 2^1 2^0
        // 32  16   8   4   2   1
        System.out.println("3 in binary is " + binary(3)); // 0 0000 0011
        System.out.println("27 in binary is " + binary(27)); // 0 0001 1011
        System.out.println("-3 in binary is " + binary(-3)); // 1 0000 0011
        System.out.println("binary 7 is: " + binary(7));
        System.out.println("-1 in binary is " + binary(-1)); // 1 0000 0011
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
        System.out.println();
    }

    public static void bitOps() {
        System.out.println("bitOps:\n");

        // AND &
        System.out.println("5&6 is: " + (5 & 6)); //   0101 &
                                                  //   0110
                                                  // = 0100 = 4

        // OR |
        System.out.println("7|2 is: " + (7 | 2)); //   0111 |
                                                  //   0010
                                                  // = 0111 = 7

        // XOR (each must have exactly a single T value to be T)
        System.out.println("5^3 is: " + (5 ^ 3)); //   0101 ^
                                                  //   0011
                                                  // = 0110 = 6
        System.out.println();
    }

    // MASKING
    // TURNING ON A BIT/TURNING OFF ETC.
    // 3 programs

    public static String binary(int i) {
        return Integer.toString((short) i, 2);
    }

    public static void negativePositiveBinaryNums() {
        System.out.println("Positive vs. Negative:\n");
        // 8 bits: 0000 0000
        // 8th bit represents sign. 0 = positive, 1 = negative

        // READING NEGATIVE NUMBER = 1 0100
        // -16 4 = -12
        // Note: 1 + 1 = 10

        // Storing positive and negative 4 in binary bits
        // 4 = 0000 0100 = 4
        // ones~4 = 1111 1011 = -16 + 8 + 2 + 1 = -16 + 11 = -5 (invert all numbers)
        // twos~4 = 1111 1011 + 1 = 1 1111 1100 = -16 + 12 = -4 (add 1 to inverted
        // numbers)
        // ones~4 = -5 = ~4
        // twos~4 = -4 = ~3
        System.out.println("ones compliment of ~4 should be -5: " + ~4);
        System.out.println("two's compliment of 4 should be -4 : " + ((~4) + 1));
        System.out.println();

        // Storing positive and negative 5 in binary bits
        // 5 = 0 0000 0101
        // ones~5 = 1111 1010 = 10 = -16 + 8 + 2 = -6
        // twos~5 = 1111 1010 + 1 = 1 1111 1011 = -16 + 8 + 2 + 1= -16 + 11 = -5
        // ones~5 = -6 = ~5
        // twos~5 = -5 = ~4
        System.out.println("ones compliment of ~5 should be -6: " + ~5);
        System.out.println("two's compliment of 5 should be -5: " + ((~5) + 1));
        System.out.println();
    }

    public static void bitShifts() {
        System.out.println("Bit Shifting:\n");

        // 23 = 0001 0111
        System.out.println("binary of 23 is: " + binary((short) 23));

        // 23 << left shift = 46 (23 * 2)
        // 23 = 0010 1110 = 32 + 2 + 4 + 8 = 46
        System.out.println("binary of 23<<1 should be 0010 1110 which is 46: " + binary((short) (23 << 1)) + " = "
                + (short) (23 << 1));

        // 23 >> right shift = 11 (23 / 2)
        // 23 = 0000 1011 = 8 + 2 + 1 = 11
        System.out.println("binary of 23>>1 should be 0000 1011 which is 11: " + binary((short) (23 >> 1)) + " = "
                + (short) (23 >> 1));

        // -23 = 1001 0111 = 1110 1001 = -128 + 64 + 32 + 8 + 1 = -23
        System.out.println("binary of -23 is: " + Integer.toBinaryString((short) -23));

        // Normal/Arithmetic right shift >>
        // 1110 1001 >> 1 = 1111 0100 = -128 + 64 + 32 + 16 + 4 = (23/2) = -12
        System.out.println("-23>>1 should be -12: " + (-23 >> 1));

        // Logical right shift >>> (fills in 0 in msb)
        // 0000 0101 >>> 1 = 0000 0010 =  2
        System.out.println("logical shift: 5>>>1 should be 2: " +  (5 >>> 1));
        System.out.println();
    }

    public static void bitMasks() {
        System.out.println("Bit Masks: \n");
        // Get ith bit using (&):
        // 5 = 0101 &
        // 2 = 0010 = 0000
        // the ith place we got was 0
        System.out.println("getting the ith bit of 5&2 which is 0th bit: "+binary((short)5&2));

        // Get ith bit:
        // 5 = 0101 &
        // 4 = 0100 = 0100
        // the ith place we got was 1
        System.out.println("5&4 should be 4: " + ((short)5&4));



        // Set ith bit/Turn on ith bit using (|):
        // 5 = 0101 |
        // 2 = 0010 = 0111
        // the ith place was set to 1
        System.out.println("setting the ith bit of 5|2 which is 0111: "+binary((short)5|2));

        // Set ith bit/Turn on ith bit:
        // 5 = 0101 |
        // 4 = 0100 = 0101
        // the ith place we set gave us the number 5
        System.out.println("5|4 should be 5: " + ((short)5|4));



        // Clear ith bit/Turn off ith bit using (&~):
        // 5 = 0101 &
        // 11 = 1011 = 0001
        // the ith place was set to 1
        System.out.println("clearing the ith bit of 5&11 which is 0001: "+binary((short)5&11));

        // Clear ith bit/Turn off ith bit using (&~):
        // 5 = 0101 &
        // 11 = 1011 = 0001
        // the ith place was set to 1
        System.out.println("5&11 should be 1: " + ((short)5&11));

        System.out.println();
    }

    public static void getith1Bit(int x) {
        // (x&(1<<i)) != 0 // get's the ith one
        for(int i = 0; i<=x; i++){
           if((x&(1<<i)) != 0){
            System.out.println("Bits start at index 0. For int: " + x +
             ", bit number: " + i +", is set to 1");
           }
        }
    }

    public static void setith1Bit(int x) {
        // (x|(1<<i)) // set's the ith one
        for(int i = 0; i<x; i++){
            System.out.println("Bits start at index 0. For int: " + x + " which is: " + binary(x) + ", in binary" +
             ", bit number: " + i +", is set to: 1 in: " + binary(x|(1<<i)));
           
        }
    }

    public static void clearith1Bit(int x) {
        // (x&(1<<i)) != 0 // get's the ith one
        for(int i = 0; i<x; i++){
           if((x&~(1<<i)) != 1){
            System.out.println("Bits start at index 0. For int: " + x +
             ", bit number: " + i +", is turned off to 0");
           }
        }
    }
    public static void getith1BitTest(){
        getith1Bit(0);
        getith1Bit(1);
        getith1Bit(2);
        getith1Bit(3);
        getith1Bit(4);
        getith1Bit(17);
        System.out.println();
    }

    public static void setithBitTest(){
        setith1Bit(0);
        setith1Bit(1);
        setith1Bit(2);
        setith1Bit(4);
        System.out.println();
    }

    public static void clearith1Bit(){
        clearith1Bit(0);
        clearith1Bit(1);
        clearith1Bit(2);
        clearith1Bit(3);
        System.out.println();
    }

    public static void main(String[] args) {
        binaryNumbers();
        bitOps();
        negativePositiveBinaryNums();
        bitShifts();
        bitMasks();
        getith1BitTest();
        setithBitTest();
        clearith1Bit();
    }
}