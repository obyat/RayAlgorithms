/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 0)
            return digits;
        if (digits[len - 1] != 9)
            digits[len - 1]++;
        else if (all9s(digits))
            digits = handleNewArray(digits, len - 1);
        else
            digits = handle9s(digits, len - 1);
        return digits;
    }

    public int[] handle9s(int[] digits, int len) {
        while (digits[len] == 9 && len > 0) {
            digits[len] = 0;
            len--;
        }
        digits[len]++;

        return digits;
    }

    public int[] handleNewArray(int[] digits, int len) {
        int newLength = len + 2;
        int[] newArray = new int[newLength];
        newArray[0] = 1;
        return newArray;
    }

    private boolean all9s(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9)
                return false;
        }
        return true;
    }
}
// @lc code=end
