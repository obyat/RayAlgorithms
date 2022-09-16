import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
// n = range of numbers to choose from
// k = numbers in a single currentList
// runtime = n C k (time) + O(n) space + O(2n) stackspace
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (k == 0)
            return new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), 1, n, k);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> currList, int start, int n, int k) {
        if (k == 0) {
            print("k is 0, done!");
            list.add(new ArrayList<Integer>(currList));
            return;
        }
        for (int i = start; i <= n; i++) {

            print("looping from " + "1 which now is " + start + ", to " + n);
            currList.add(i);
            print("added " + i + ", to " + currList.toString());

            print("recursing...");
            backtrack(list, currList, i + 1, n, k - 1);

            print("recursion ended, popping off top of stack which is recurse " + (currList.get(currList.size() - 1)));
            print("removing element at index: " + (currList.size() - 1));
            print("removing " + currList.get(currList.size() - 1));
            currList.remove(currList.size() - 1);
        }
    }

    public static void print(Object o) {
        System.out.println(o.toString());
    }
}
// @lc code=end
