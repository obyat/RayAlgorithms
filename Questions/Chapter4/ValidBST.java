package Chapter4;
/*
*leetcode 98. Validate Binary Search Tree
*https://leetcode.com/problems/validate-binary-search-tree/
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

class ValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validBST(TreeNode root, long left, long right) {
        if (root == null)
            return true;
        if (root != null && root.val <= left)
            return false;
        if (root != null && root.val >= right)
            return false;
        return validBST(root.left, left, root.val) && validBST(root.right, root.val, right);
    }
}
// @lc code=end
