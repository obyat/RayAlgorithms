package Utility;

public final class BitwiseUtil {
    private BitwiseUtil() {
    }

    public static String decimalToBinary(int x) {
        StringBuilder sb = new StringBuilder();
        int gap = 0;
        for (int i = 11; i >= 0; i--) {
            gap++;
            if (((1 << i) & x) != 0)
                sb.append("1");
            else
                sb.append("0");
            if (i != 0 && gap == 4) {
                gap = 0;
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static int binaryToDecimal(String x) {
        if (x.length() <= 0)
            return 0;
        int a = 0;
        int inc = 1;
        for (int i = x.length() - 1; i >= 0; i--) {
            if (x.charAt(i) == '1')
                a = a + Integer.valueOf(inc);
            if (x.charAt(i) != ' ')
                inc *= 2;
        }
        return a;
    }
}
