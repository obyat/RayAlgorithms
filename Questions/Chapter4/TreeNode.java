package Chapter4;

public class TreeNode {
    public int val;
    public Node left;
    public Node right;

    public TreeNode() {
    }

    public TreeNode(int _val) {
        val = _val;
    }

    public TreeNode(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    public boolean isEmpty() {
        return this == null;
    }

    public static void main(String[] args) {

    }
}