import java.util.Arrays;

class Aug0526 {
    public static void main(String[] args) {
        Aug0526 aug = new Aug0526();
        int[][] intervals = { { 1, 3 }, { 1, 5 }, { 6, 7 } };
        System.out.println("merge--->" + Arrays.deepToString(aug.merge(intervals)));
    }

    public int[][] merge(int[][] intervals) {
        int max = 0;
        for (int[] interval : intervals) {
            max = Math.max(max, interval[0]);
        }
        int[] mp = new int[max + 1];
        for (int[] interval : intervals) {
            mp[interval[0]] = Math.max(mp[interval[0]], interval[1]);
        }
        int r = 0;
        int have = -1;
        int intervalStart = -1;

        for (int i = 0; i < mp.length; i++) {
            if (mp[i] != 0) {
                if (intervalStart == -1) {
                    intervalStart = i;
                }
                have = mp[i];
            }
            if (have == i) {
                intervals[r++] = new int[] { intervalStart, have };
                intervalStart = -1;
                have = -1;
            }

        }
        if (intervalStart != -1) {
            intervals[r++] = new int[] { intervalStart, have };
        }
        if (intervals.length == r) {
            return intervals;
        }
        int[][] res = new int[r][];
        for (int i = 0; i < res.length; i++) {
            res[i] = intervals[i];
        }
        return res;
    }
}