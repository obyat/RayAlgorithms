/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 * 
 * Plan:
 * 1. Have boolean that is flipped off and on depending on branch
 * 2. presist sum
 * 3. return sum
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumLeftLeaves(root, false, 0);
    }

    public int sumLeftLeaves(TreeNode node, boolean isLeftBranch, int leftLeavesSum) {
        if (node == null)
            return 0;

        if (isLeftBranch && node.left == null && node.right == null)
            leftLeavesSum += node.val;

        // adding sum to itself regardless of true/false
        int a = sumLeftLeaves(node.left, true, leftLeavesSum);
        int b = sumLeftLeaves(node.right, false, leftLeavesSum);

        // will be 0 + leftleave + 0 + leftLave etc.
        return leftLeavesSum + a + b;
    }
}
// @lc code=end
