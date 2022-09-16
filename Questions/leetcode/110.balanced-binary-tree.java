/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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
 */
class Solution {
    boolean answer;

    public boolean isBalanced(TreeNode root) {
        answer = true;
        if (root == null)
            return true;
        if (Math.abs(checkBalanced(root.left) - checkBalanced(root.right)) > 1 || answer == false)
            return false;
        return true;
    }

    public int checkBalanced(TreeNode n) {
        if (n == null)
            return 0;
        int lh = checkBalanced(n.left) + 1;
        int rh = checkBalanced(n.right) + 1;
        if (Math.abs(lh - rh) > 1)
            answer = false;
        return Math.max(lh, rh);
    }

}

// @lc code=end
