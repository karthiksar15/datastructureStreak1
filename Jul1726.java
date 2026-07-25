import java.util.Arrays;

class Jul1726 {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 2, 4 }, { 1, 4 } };
        Jul1726 jul = new Jul1726();
        System.out.println("overlap--->" + jul.eraseOverlapIntervals(intervals));
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
