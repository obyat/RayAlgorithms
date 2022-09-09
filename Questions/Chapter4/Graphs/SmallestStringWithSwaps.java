package Chapter4.Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import java.util.ArrayList;
import java.util.Queue;

/*
* @lc app=leetcode id=1202 lang=java
*
* [1202] Smallest String With Swaps
*/

// @lc code=start
class SmallestStringWithSwaps {
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
        for (int i = 0; i < s.length(); i++) {
            System.out.println("i: " + i);
            System.out.println("find(i): " + uf.find(i));
            System.out.println("unionChars.get(find(i): " + unionChars.get(uf.find(i)));
            System.out.println("unionChars.get(find(i).peek(): " + unionChars.get(uf.find(i)).peek());

            sortedStr.append(unionChars.get(uf.find(i)).poll());
            System.out.println("append: " + sortedStr.toString());
        }
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

    public static void main(String[] args) {
        SmallestStringWithSwaps ssws = new SmallestStringWithSwaps();
        List<List<Integer>> list = (List<List<Integer>>) new ArrayList<List<Integer>>();
        List<Integer> a1 = (List<Integer>) new ArrayList<Integer>();
        List<Integer> a2 = (List<Integer>) new ArrayList<Integer>();
        a1.add(0);
        a1.add(3);
        a2.add(1);
        a2.add(2);

        list.add(a1);
        list.add(a2);

        ssws.smallestStringWithSwaps("dacb", list);

    }

}
// @lc code=end
