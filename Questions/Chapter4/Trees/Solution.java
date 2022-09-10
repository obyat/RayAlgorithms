package Chapter4.Trees;

import java.lang.StringBuilder;

class Solution {

   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

   }
   
    int result;
    StringBuilder a = new StringBuilder();
    public int sumNumbers(TreeNode root) {
        sumNumbers(root, "", a);
        return result;
    }
    
    public void sumNumbers(TreeNode root, String strSum, StringBuilder sb){
        if(root == null) return;
        
        strSum += Integer.toString(root.val);
        System.out.println("strSum:" + strSum);

        sb.append(root.val);
        System.out.println("sb:" + sb.toString());
        
        
        if(root.left == null && root.right == null)
                result += Integer.parseInt(strSum);
        
        
        sumNumbers(root.left, strSum, sb);
        sumNumbers(root.right, strSum, sb);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tree = s.new TreeNode(1);
        tree.left = s.new TreeNode(2);
        tree.right = s.new TreeNode(3);
        s.sumNumbers(tree);
    }

    
}
