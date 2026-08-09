import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Aug0426 {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 1, 5 }, { 6, 7 } };
        Aug0426 aug = new Aug0426();
        System.out.println("merge--->" + Arrays.deepToString(aug.merge(intervals)));
    }

    public int[][] merge(int[][] intervals) {
        int max = 0;
        for (int[] interval : intervals) {
            max = Math.max(max, interval[0]);
        }
        int[] dp = new int[max + 1];
        for (int[] interval : intervals) {
            dp[interval[0]] = Math.max(dp[interval[0]], interval[1] + 1);
        }
        int r = 0;
        int have = -1;
        int intervalStart = -1;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] != 0) {
                if (intervalStart == -1) {
                    intervalStart = i;
                }
                have = Math.max(have, dp[i] - 1);
            }
            if (have == i) {
                intervals[r++] = new int[] { intervalStart, have };
                have = -1;
                intervalStart = -1;
            }
        }
        if (intervalStart != -1)
            intervals[r++] = new int[] { intervalStart, have };
        if (intervals.length == r)
            return intervals;
        int[][] res = new int[r][];
        for (int i = 0; i < r; i++) {
            res[i] = intervals[i];
        }
        return res;
    }
}
