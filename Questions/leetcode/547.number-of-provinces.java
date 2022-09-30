class GraphValidTree {
    public int findCircleNum(int n, int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        int len = isConnected.length;

        DisjointGraphSet gs = new DisjointGraphSet(len);
        // A
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (isConnected[i][j] == 1)
                    gs.union(i, j);
            }
        }

        return gs.getCount();
    }

    public static void main(String[] args) {
           findCircleNum(5, new int[][] {[0,1],[0,2],[0,3],[1,4]});
    }

    class DisjointGraphSet {
        private int[] root;
        private int[] rank;
        private int count;

        // O(n) time
        public DisjointGraphSet(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;

            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        // returns the element of the root of the graph
        // O(1) time amortized time after O(1) worst case time
        public int find(int x) {
            if (root[x] == x)
                return x;
            return root[x] = find(root[x]);
        }

        // O(1) time amortized time after O(1) worst case time
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
                count--;

            }

        }

        public int getCount() {
            return count;
        }

    }
}