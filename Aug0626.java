import java.util.Arrays;
import java.util.PriorityQueue;

class Aug0626 {
    public static void main(String[] args) {
        Aug0626 aug = new Aug0626();
        int[][] intervals = { { 1, 2 }, { 2, 4 }, { 1, 4 } };
        System.out.println("erasee--->" + aug.eraseOverlapIntervals(intervals));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int res = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                res++;
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return res;
    }
}
