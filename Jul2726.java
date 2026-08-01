import java.util.Arrays;

public class Jul2726 {

    public static void main(String[] args) {
        Jul2726 jul = new Jul2726();
        int[][] intervals = { { 1, 2 }, { 2, 4 }, { 1, 4 } };
        System.out.println("erase--->" + jul.eraseOverlapIntervals(intervals));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int res = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start < prevEnd) {
                res++;
            } else {
                prevEnd = end;
            }
        }
        return res;
    }

}
