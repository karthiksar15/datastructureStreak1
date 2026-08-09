import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Aug0326 {
    public static void main(String[] args) {
        Aug0326 aug = new Aug0326();
        int[][] intervals = { { 1, 3 }, { 4, 6 } };
        int[] newInterval = { 2, 5 };
        System.out.println("insert--->" + Arrays.deepToString(aug.insert(intervals, newInterval)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0]) {
                list.add(interval);
            } else if (interval[0] > newInterval[1]) {
                list.add(newInterval);
                list.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if (newInterval != null)
            list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }

}
