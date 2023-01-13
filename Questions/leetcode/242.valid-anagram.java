
/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */
import java.util.Arrays;

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] a = new char[26];
        
        for (int i = 0; i < s.length(); i++) {
            a[(s.charAt(i) - 'a')]++;
            a[(t.charAt(i) - 'a')]--;
        }

        for (int i = 0; i < a.length; i++)
            if (a[i] != 0)
                return false;

        return true;
    }

    public boolean isAnagramSort(String s, String t) {
        // 87 85
        if (s.length() != t.length())
            return false;
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < s.length(); i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }
}
// @lc code=end
