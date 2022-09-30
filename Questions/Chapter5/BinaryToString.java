package Chapter5;

import Generic.TESTSUIT;

// import Chapter2.LinkedLists.DllNode;
// import Chapter2.LinkedLists.DoublyLinkedList ;

public class BinaryToString {

    /*
     * Chapter: 5, Question: 2.
     * Given a real number between O and 1 (e.g., 0.72) that is passed in as a
     * double, print
     * the binary representation. If the number cannot be represented accurately in
     * binary with at most 32
     * characters, print "ERROR:
     * 
     * Example: 0.5 = 1/2 = 0.1000
     * Hints:
     */

    // Runtime:
    public static String stringRepresentation(Double x) {
        if (x >= 1 || x <= 0)
            return "ERROR";

        StringBuilder sb = new StringBuilder();
        sb.append("0.");

        while (x > 0) {
            if (sb.length() > 31)
                return "ERROR";

            double r = x * 2;

            if (r >= 1) {
                sb.append(1);
                x = r - 1;
            } else {
                sb.append(0);
                x = r;
            }
        }
        return sb.toString();
    }

    public static String stringRepresentationEasier(Double x) {
        if (x >= 1 || x <= 0)
            return "ERROR";

        StringBuilder sb = new StringBuilder();
        sb.append("0.");

        double fraction = 0.5;
        while (x > 0) {
            print("x is: " + x);
            print("fraction is: " + fraction);

            if (x >= fraction) {
                print("x >= fraction, subtracting (x - fraction) : " + (x - fraction) + ", then appending 1");
                sb.append(1);
                x = x - fraction;
            } else {
                print("x < fraction, appneding 0");
                sb.append(0);
            }
            print(" fraction = fraction / 2  = " + fraction + "/" + "2 = " + (fraction / 2));

            fraction = fraction / 2; // essentially shifts into next right bit
            if (sb.length() > 31)
                return "ERROR";
        }
        return sb.toString();
    }

    // Function to convert binary fractional to
    // decimal
    static double binaryToDecimal(String binary, int len) {

        // Fetch the radix point
        int point = binary.indexOf('.');

        // Update point if not found
        if (point == -1)
            point = len;

        double intDecimal = 0, fracDecimal = 0, twos = 1;

        // Convert integral part of binary to decimal
        // equivalent
        for (int i = point - 1; i >= 0; i--) {
            intDecimal += (binary.charAt(i) - '0') * twos;
            twos = twos * 2;
        }

        // Convert fractional part of binary to
        // decimal equivalent
        twos = 2;
        for (int i = point + 1; i < len; i++) {
            fracDecimal += (binary.charAt(i) - '0') / twos;
            twos *= 2.0;
        }

        // Add both integral and fractional part
        return intDecimal + fracDecimal;
    }

    public static void main(String[] args) {
        TESTSUIT.assertTest(stringRepresentation(0.25), "0.25", "0.01");
        TESTSUIT.assertTest(stringRepresentation(0.5), "0.5", "0.1");
        TESTSUIT.assertTest(stringRepresentation(0.75), "0.75", "0.11");
        TESTSUIT.assertTest(stringRepresentationEasier(0.25), "0.25", "0.01");
        TESTSUIT.assertTest(stringRepresentationEasier(0.5), "0.5", "0.1");
        TESTSUIT.assertTest(stringRepresentationEasier(0.75), "0.75", "0.11");

        // print(1 / 0.75);
        String n = "110.101";
        System.out.println(binaryToDecimal(n, n.length()));
        n = "101.1101";
        System.out.println(binaryToDecimal(n, n.length()));

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
