package DataStructures.Trees.RedBlackTree;

public class TreeExample {
    
    public static void main(String[] args) {
        RedBlackTree<Integer> rb = new RedBlackTree<Integer>();
        rb.insertAll(new Integer[] {10, 20, 5, 40, 50, 25, 60, 80, 85, 90, 30, 15, 75, 100, 55, 45, 0, 26});
        System.out.println(rb.getMax());
        System.out.println(rb.getMin());
        System.out.println("Traversing tree...");
        rb.traverse();
        System.out.println("Traversing tree...");
        rb.traverse();
        System.out.println("Traversing tree...");
        rb.traverse();
        System.out.println("Searching 6 in tree...");
        System.out.println(rb.search(rb.root, 5).getData());
        System.out.println(rb.search(rb.root, 5).getColor());
    }
}
