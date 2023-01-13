/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int bestSoFar = 0;
        int min = Integer.MAX_VALUE;
        int i = 0;

        while (i < prices.length) {
            if (prices[i] < min)
                min = prices[i];
            if (prices[i] - min > bestSoFar) {
                bestSoFar = prices[i] - min;
            }
            i++;
        }

        return bestSoFar;
    }
}
// @lc code=end
