package DataStructures.Trees.AVL;

public class TreeExample {
    
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<Integer>();
        avl.insertAll(new Integer[] {10,4,6,9});
        // System.out.println(avl.getMax());
        // System.out.println(avl.getMin());
        System.out.println("Traversing tree...");
        avl.traverse();
        // avl.delete(20);
        System.out.println("Traversing tree...");
        avl.traverse();
        // avl.delete(9);
        // avl.delete(0);
        System.out.println("Traversing tree...");
        avl.traverse();
        System.out.println(avl.search(avl.root, 4).getHeight());

    }
}
