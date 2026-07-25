import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jul1626 {

    public static void main(String[] args) {
        Jul1626 jul = new Jul1626();
        int[][] intervals = { { 1, 3 }, { 1, 5 }, { 6, 7 } };
        System.out.println("merge--->" + Arrays.deepToString(jul.merge(intervals)));
    }

    public int[][] merge(int[][] intervals) {
        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            max = Math.max(intervals[i][0], max);
        }
        int[] mp = new int[max + 1];
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            mp[start] = Math.max(end + 1, mp[start]);
        }
        int r = 0;
        int have = -1;
        int intervalStart = -1;
        for (int i = 0; i < mp.length; i++) {
            if (mp[i] != 0) {
                if (intervalStart == -1) {
                    intervalStart = i;
                }
                have = Math.max(mp[i] - 1, have);
            }
            if (have == i) {
                intervals[r++] = new int[] { intervalStart, have };
                have = -1;
                intervalStart = -1;
            }
        }

        if (intervalStart != -1) {
            intervals[r++] = new int[] { intervalStart, have };
        }
        if (intervals.length == r) {
            return intervals;
        }
        int[][] res = new int[r][];
        for (int i = 0; i < r; i++) {
            res[i] = intervals[i];
        }
        return res;
        // List<int[]> res = new ArrayList<>();
        // int prevEnd = intervals[0][1];
        // int prevSt = intervals[0][0];
        // if (intervals.length == 1)
        // return intervals;
        // for (int i = 1; i < intervals.length; i++) {
        // if (prevEnd >= intervals[i][0]) {
        // res.clear();
        // res.add(new int[] { prevSt, intervals[i][1] });
        // prevEnd = intervals[i][1];
        // } else if (prevEnd < intervals[i][0] && prevEnd < intervals[i][1]) {
        // res.clear();
        // res.add(new int[] { prevSt, prevEnd });
        // res.add(new int[] { intervals[i][0], intervals[i][1] });
        // prevEnd = intervals[i][1];
        // } else {
        // res.add(new int[] { intervals[i][0], intervals[i][1] });
        // prevSt = intervals[i][0];
        // prevEnd = intervals[i][1];
        // }

        // }
        // return res.toArray(new int[0][]);
    }

}
