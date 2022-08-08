package Chapter4;

//4.4 Check if binary tree is balanced such that the heights differ only by 1 at most
//leetcode @ 1120 balanced binary tree
public class CheckBalanced {
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
