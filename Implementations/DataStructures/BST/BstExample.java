package DataStructures.BST;

public class BstExample {
    
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insertAll(new Integer[] {10,15,6,4,9,12,20});
        System.out.println(bst.getMax());
        System.out.println(bst.getMin());
        System.out.println("Traversing tree...");
        bst.traverse();
        bst.delete(20);
        System.out.println("Traversing tree...");
        bst.traverse();
        bst.delete(9);
        bst.delete(0);
        System.out.println("Traversing tree...");
        bst.traverse();

    }
}
