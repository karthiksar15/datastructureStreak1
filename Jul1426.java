import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jul1426 {

    public static void main(String[] args) {
        Jul1426 jul = new Jul1426();
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };
        System.out.println("insert--->" + Arrays.deepToString(jul.insert(intervals, newInterval)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][] { newInterval };
        int n = intervals.length;
        int target = newInterval[0];
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (intervals[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < left; i++) {
            result.add(intervals[i]);
        }
        result.add(newInterval);
        for (int i = left; i < n; i++) {
            result.add(intervals[i]);
        }
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : result) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[0][]);
    }

}
