
// @lc code=start
class Solution {
    public int reverse(int x) {
        int reversedInt = 0;
        while (x != 0) {

            if ((reversedInt > Integer.MAX_VALUE / 10) ||
                    reversedInt == Integer.MAX_VALUE / 10 && (x % 10) > 7)
                return 0;

            if ((reversedInt < Integer.MIN_VALUE / 10) ||
                    reversedInt == Integer.MIN_VALUE / 10 && (x % 10) < -8)
                return 0;

            reversedInt = (reversedInt * 10) + (x % 10);
            x = x / 10;
        }
        return reversedInt;
    }
}
// @lc code=end
