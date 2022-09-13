package DataStructures.Graphs.DisjointSets;

public class Unionfind {
    private int[] root;

    public Unionfind(int size) {
        root = new int[size];

        // each elemenet is its own root node initially in the graph
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }

    }

    // returns the elemenet of the root of the graph
    // O(1) time
    public int find(int x) {
        return root[x];
    }

    // O(n) time
    public void union(int x, int y) {
        int rootNodeX = root[x];
        int rootNodeY = root[y];

        if (rootNodeX != rootNodeY) {
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootNodeY) { // search for all nodes with Y as parent and change them to x
                    root[i] = rootNodeX;
                }
            }
        }
    }

    // O(1) time
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void print(Object object) {
        System.out.println(object.toString());
    }

    public static void main(String[] args) {
        Unionfind unionfind = new Unionfind(10);
        unionfind.union(1, 2);
        unionfind.union(2, 5);
        unionfind.union(5, 6);
        unionfind.union(6, 7);
        unionfind.union(3, 8);
        unionfind.union(8, 9);

        print(unionfind.connected(1, 5)); // t
        print(unionfind.connected(5, 7)); // t
        print(unionfind.connected(4, 9)); // f
        unionfind.union(9, 4); // 1-2-5-6-7 3-8-9-4
        print(unionfind.connected(4, 9)); // t

    }

}
