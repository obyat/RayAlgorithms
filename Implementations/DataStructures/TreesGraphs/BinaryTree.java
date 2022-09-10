package DataStructures.TreesGraphs;

import javax.swing.tree.TreeNode;

// leaf node = no children
// binary tree = up to children per node
// ternary tree = up to three children per node
// binary search tree: left nodes <= root < right nodes

/*
 * 
One way to think about it is that a "balanced" tree really means something more like "not terribly imbal
anced:' It's balanced enough to ensure 0( log n) times for insert and find, but it's not necessarily as
balanced as it could be.

A complete binary tree is a binary tree in which every level of the tree is fully filled, except for perhaps the
last level. To the extent that the last level is filled, it is filled left to right.

A full binary tree is a binary tree in which every node has either zero or two children. That is, no nodes have
only one child

A perfect binary tree is one that is both full and complete. All leaf nodes will be at the same level, and this
level has the maximum number of nodes.

 */
public class BinaryTree<T> {
    private TreeNode root;

    private class TreeNode<T>{
        private TreeNode left;
        private TreeNode right;
        private T data;

        TreeNode(T data){ this.data = data; }
    }

    public void createBinaryTree(){
        TreeNode<Integer> t1 = new TreeNode<Integer>(9);
        TreeNode<Integer> t2 = new TreeNode<Integer>(2);
        TreeNode<Integer> t3 = new TreeNode<Integer>(3);
        TreeNode<Integer> t4 = new TreeNode<Integer>(4);


        root = t1;
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;

    }

    // visit Left -> current node -> right
    public void inOrderTraversal(TreeNode node){
        if(node != null){
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
    }

    // current node -> left -> right
    public void PreOrderTraversal(TreeNode node){
        if(node != null){
            visit(node);
            PreOrderTraversal(node.left);
            PreOrderTraversal(node.right);
        }
    }

    // left -> right -> current
    public void PostOrderTraversal(TreeNode node){
        if(node!=null){
            PostOrderTraversal(node.left);
            PostOrderTraversal(node.right);
            visit(node);
        }
    }

    public void visit(TreeNode node){
        System.out.print(node.data+", ");

    }

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<Integer>();
        bt.createBinaryTree();
        bt.PreOrderTraversal(bt.root);
    }

}


// How tree recursion works!
// https://leetcode.com/problems/maximum-depth-of-binary-tree/