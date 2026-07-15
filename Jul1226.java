import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jul1226 {

    public static void main(String[] args) {
        Jul1226 jul = new Jul1226();
        int[][] intervals = { { 1, 3 }, { 4, 6 } };
        int[] newInterval = { 2, 5 };
        System.out.println(Arrays.toString(jul.insert(intervals, newInterval)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {

        }
    }

}
