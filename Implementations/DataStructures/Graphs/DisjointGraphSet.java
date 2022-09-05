package DataStructures.Graphs;

public class DisjointGraphSet {
    private int[] root;
    private int[] rank;

    // O(n) time
    public DisjointGraphSet(int size) {
        root = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    // returns the element of the root of the graph
    // O(1) time amortized time after O(N) worst case time
    public int find(int x) {
        if (root[x] == x)
            return x;
        return root[x] = find(root[x]);
    }

    // O(1) time amortized time after O(N) worst case time
    public void union(int x, int y) {
        int rootNodeX = find(x);
        int rootNodeY = find(y);

        // root[rootNodeY] gets the parent of rootNodeY since they all have the same
        // parent
        if (rootNodeX != rootNodeY) {

            if (rank[rootNodeX] > rank[rootNodeY]) {
                root[rootNodeY] = rootNodeX;
            } else if (rank[rootNodeX] < rank[rootNodeY]) {
                root[rootNodeX] = rootNodeY;
            } else {
                root[rootNodeY] = rootNodeX;
                rank[rootNodeX] += 1;
            }

        }

    }

    // O(1) time amortized time after O(1) worst case time
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void print(Object object) {
        System.out.println(object.toString());
    }

    public static void main(String[] args) {
        DisjointGraphSet unionfind = new DisjointGraphSet(10);
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



