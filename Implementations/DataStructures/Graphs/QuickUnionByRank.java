package DataStructures.Graphs;

public class QuickUnionByRank {
    private int[] root;
    private int[] rank;

    public QuickUnionByRank(int size) {
        root = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    // returns the element of the root of the graph
    // O(n) time
    public int find(int x) {
        while (root[x] != x) {
            x = root[x];
        }
        return x;
    }

    // O(n) time
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

    // O(n) time
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void print(Object object) {
        System.out.println(object.toString());
    }

    public static void main(String[] args) {
        QuickUnionByRank unionfind = new QuickUnionByRank(10);
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