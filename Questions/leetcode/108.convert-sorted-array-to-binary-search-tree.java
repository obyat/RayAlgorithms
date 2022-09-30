import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Numsay to Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree treenode.
 * public class TreeTreeNode {
 * int val;
 * TreeTreeNode left;
 * TreeTreeNode right;
 * TreeTreeNode() {}
 * TreeTreeNode(int val) { this.val = val; }
 * TreeTreeNode(int val, TreeTreeNode left, TreeTreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return constructMinimalTree(nums);
    }

    public static TreeNode constructMinimalTree(int[] arr) {
        if (arr.length == 0)
            return null;
        TreeNode root = new TreeNode(arr[arr.length / 2]);
        if (arr.length > 1) {
            root.left = constructMinimalTree(Arrays.copyOfRange(arr, 0, arr.length / 2));
            root.right = constructMinimalTree(Arrays.copyOfRange(arr, ((arr.length / 2)+1), arr.length));
        }
        return root;
    }
}

// @lc code=end
