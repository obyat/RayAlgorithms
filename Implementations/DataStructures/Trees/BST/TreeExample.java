package DataStructures.Trees.BST;

public class TreeExample {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        // bst.insertAll(new Integer[] { 10, 15, 6, 4, 9, 12, 20 });
        bst.insertAll(new Integer[] { 7, 2, 9, 1, 5, 14 });
        System.out.println("Max is: " + bst.getMax());
        System.out.println("Min is: " + bst.getMin());
        System.out.println("Traversing tree...");
        bst.traverse();
        bst.delete(20);
        System.out.println("Traversing tree...");
        bst.traverse();
        // bst.delete(8);
        bst.delete(0);
        System.out.println("Traversing tree...");
        bst.traverse();
        System.out.println();
        System.out.println("Searching for 14 in tree...");
        System.out.println(bst.search(bst.root, 14).getData());
        System.out.println();
        System.out.println("Checking parents");
        System.out.println("The parent of 14 is: " + bst.search(bst.root, 9).getParent());
        System.out.println("The parent of 7 is: " + bst.search(bst.root, 7).getParent());
        System.out.println("The parent of 9 is: " + bst.search(bst.root, 9).getParent());
        System.out.println("The parent of 1 is: " + bst.search(bst.root, 1).getParent());
        System.out.println("The parent of 5 is: " + bst.search(bst.root, 5).getParent());

    }
}
