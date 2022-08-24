package Chapter4;

/*
 * leetcode 572. Subtree of Another Tree
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
/**
 * Definition for a binary tree node.
 * public class Node {
 * int val;
 * Node left;
 * Node right;
 * Node() {}
 * Node(int val) { this.val = val; }
 * Node(int val, Node left, Node right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class CheckSubtree {
    public boolean isSubtree(Node root, Node subRoot) {
        return foundNode(root, subRoot);
    }

    public boolean foundNode(Node p, Node q) {
        boolean sameSubTree = false;
        if (p == null)
            return false;
        if (p.val == q.val)
            if (isSameTree(p, q))
                sameSubTree = true;
        return sameSubTree || foundNode(p.left, q) || foundNode(p.right, q);
    }

    public boolean isSameTree(Node p, Node q) {
        if (p == null && q == null)
            return true;
        if (p == null && q != null)
            return false;
        if (p != null && q == null)
            return false;
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}