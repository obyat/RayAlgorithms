/*
 * @lc app=leetcode id=965 lang=java
 *
 * [965] Univalued Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int val; 
    public boolean isUnivalTree(TreeNode root) {
        if(root == null ) return true;
        val = root.val;
        return isUniversalNodes(root);
    }

    public boolean isUniversalNodes(TreeNode root){
        if(root == null) return true;
        return root.val == val && isUniversalNodes(root.left) 
                                && isUniversalNodes(root.right);
    }
    
}
// @lc code=end

