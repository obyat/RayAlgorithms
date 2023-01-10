package Generic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.stream.*;

public class CodeShellPrac {

    public static void main(String[] args) {
        int[][] logs = { { 20190101, 0, 1 }, { 20190104, 3, 4 }, { 20190107, 2, 3 }, { 20190211, 1, 5 },
                { 20190224, 2, 4 }, { 20190301, 0, 3 }, { 20190312, 1, 2 }, { 20190322, 4, 5 } };

        Arrays.sort(logs, Comparator.comparingInt(a -> a[1]));

        String first = "abc";

        // for (int[] log : logs)
        // print(log[1]);
        print("TEST");
        System.out.println(new int[] {}.length);
    }

    public static void print(Object o) {
        System.out.println();
    }
}