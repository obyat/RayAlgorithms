/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int length = nums.length - 1;
        while (start <= length) {
            int mid = start + (length - start) / 2;
            if (target == nums[mid])
                return mid;
            if (target > nums[mid])
                start = mid + 1;
            if (target < nums[mid])
                length = mid - 1;
        }
        return start;

    }
}
// @lc code=end
