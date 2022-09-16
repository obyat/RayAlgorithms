/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
import java.lang.StringBuilder;
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
             return "";
        } else if(strs[0].length() == 0) 
            return "";

        StringBuilder longestCommonPrefix = new StringBuilder();;
        int index = 0;

        for(int wordlength = 0; wordlength < strs[0].length(); wordlength++){
            
            longestCommonPrefix.append(strs[0].charAt(index));
            for(int i = 1; i < strs.length; i++){
                if((index >= strs[i].length()) || (strs[i].charAt(index) != longestCommonPrefix.toString().charAt(index)))
                     return longestCommonPrefix.toString().substring(0, index);
            }
        index++;
    }
        return longestCommonPrefix.toString();
    }
}
// @lc code=end

