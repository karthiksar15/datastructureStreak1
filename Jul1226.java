import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jul1226 {

    public static void main(String[] args) {
        Jul1226 jul = new Jul1226();
        int[][] intervals = { { 1, 3 }, { 4, 6 } };
        int[] newInterval = { 2, 5 };
        System.out.println("insert--->" + Arrays.deepToString(jul.insert(intervals, newInterval)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0;
        List<int[]> res = new ArrayList<>();
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        while (i < n) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }

}
