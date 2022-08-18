package DataStructures.Trees.BinaryTree;

public class TreeExample {

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<Integer>();
        // bt.insertAll(new Integer[] { 10, 15, 6, 4, 9, 12, 20 });
        bt.insertAll(new Integer[] { 7, 2, 9, 1, 5, 14 });
        System.out.println("Max is: " + bt.getMax());
        System.out.println("Min is: " + bt.getMin());
        System.out.println("Traversing tree...");
        bt.traverse();
        System.out.println("Traversing tree...");
        bt.traverse();
        // bt.delete(8);
        System.out.println("Traversing tree...");
        bt.traverse();
        System.out.println();
        System.out.println("Searching for 14 in tree...");
        System.out.println(bt.search(bt.root, 14).getData());
        System.out.println();
        System.out.println("Checking parents");
        System.out.println("searching for 9: " + bt.search(bt.root, 9).getData());
        System.out.println("searching for  7: " + bt.search(bt.root, 7).getData());
        System.out.println("The parent of 9 is: " + bt.search(bt.root, 9).getParent());
        System.out.println("The parent of 1 is: " + bt.search(bt.root, 1).getParent());
        System.out.println("The parent of 5 is: " + bt.search(bt.root, 5).getParent());

    }
}
