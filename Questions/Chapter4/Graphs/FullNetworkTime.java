package Chapter4.Graphs;

import DataStructures.Graphs.Unionfind;
import java.util.Comparator;
import Generic.TESTSUIT;
import java.util.Arrays;

public class FullNetworkTime extends Unionfind {

    /*
     * Chapter: 5, Question: Leetcode 1101 The earliest Moment when everyone become
     * friends.
     * In a social group, there are N people, with unique integer ids from 0 to N-1.
     * 
     * We have a list of logs, where each logs[i] = [timestamp, id_A, id_B] contains
     * a non-negative integer timestamp, and the ids of two different people.
     * 
     * Each log represents the time in which two different people became friends.
     * Friendship is symmetric: if A is friends with B, then B is friends with A.
     * 
     * Let's say that person A is acquainted with person B if A is friends with B,
     * or A is a friend of someone acquainted with B.
     * 
     * Return the earliest time for which every person became acquainted with every
     * other person. Return -1 if there is no such earliest time.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: logs =
     * [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[
     * 20190301,0,3],[20190312,1,2],[20190322,4,5]], N = 6
     * Output: 20190301
     * Explanation:
     * The first event occurs at timestamp = 20190101 and after 0 and 1 become
     * friends we have the following friendship groups [0,1], [2], [3], [4], [5].
     * The second event occurs at timestamp = 20190104 and after 3 and 4 become
     * friends we have the following friendship groups [0,1], [2], [3,4], [5].
     * The third event occurs at timestamp = 20190107 and after 2 and 3 become
     * friends we have the following friendship groups [0,1], [2,3,4], [5].
     * The fourth event occurs at timestamp = 20190211 and after 1 and 5 become
     * friends we have the following friendship groups [0,1,5], [2,3,4].
     * The fifth event occurs at timestamp = 20190224 and as 2 and 4 are already
     * friend anything happens.
     * The sixth event occurs at timestamp = 20190301 and after 0 and 3 become
     * friends we have that all become friends.
     */

    public FullNetworkTime() {
        super(0);
    }

    // runtime
    public int fullNetworkTime(int[][] logs, int N) {
        Unionfind gs = new Unionfind(N + 1);

        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));

        if (N == 0)
            return 0;

        int connectCount = -1;

        for (int[] log : logs) {

            if (!gs.connected(log[1], log[2])) {
                gs.union(log[1], log[2]);
                connectCount++;
            }

            if (connectCount == N - 1) {
                return log[0];
            }
        }

        return connectCount;
    }

    public static void main(String[] args) {
        FullNetworkTime graph = new FullNetworkTime();
        int[][] log1 = { { 20190101, 0, 1 }, { 20190104, 3, 4 }, { 20190107, 2, 3 }, { 20190211, 1, 5 },
                { 20190224, 2, 4 }, { 20190301, 0, 3 }, { 20190312, 1, 2 }, { 20190322, 4, 5 } };

        TESTSUIT.assertTest(graph.fullNetworkTime(log1, 5), "log1", 20190301);

    }

    public static void print(Object o) {
        System.out.println(o.toString());
    }
}

/*
 * Questions:
 * 1.
 * 
 * Ideas:
 * 1.
 * 
 * Edge Cases:
 * 1.
 * 
 * Pros vs. Cons in solutons:
 * 1.
 * 
 * Learned: Different solution, ideas:
 * 1.
 * 
 * Mistakes:
 * 1.
 */
