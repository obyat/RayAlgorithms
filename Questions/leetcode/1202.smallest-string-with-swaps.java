import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=1202 lang=java
 *
 * [1202] Smallest String With Swaps
 */

// @lc code=start
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        if (s.length() == 0 || pairs.size() == 0)
            return s;

        Unionfind uf = new Unionfind(s.length());
        Map<Integer, Queue<Character>> unionChars = new HashMap<>();

        for (List<Integer> list : pairs)
            uf.union(list.get(0), list.get(1));

        for (int i = 0; i < s.length(); i++) {
            unionChars.putIfAbsent(uf.find(i), new PriorityQueue<>());
            unionChars.get(uf.find(i)).add(s.charAt(i));
        }

        System.out.println(unionChars.toString());
        StringBuilder sortedStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            sortedStr.append(unionChars.get(uf.find(i)).poll());
        return sortedStr.toString();
    }

    private class Unionfind {
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
            if (root[x] != x)
                root[x] = find(root[x]);
            return root[x];
        }

        // O(n) time
        public void union(int x, int y) {
            root[find(x)] = root[find(y)];
        }
    }

}
// @lc code=end
