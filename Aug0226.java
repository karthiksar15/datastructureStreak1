import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Aug0226 {

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 3 }, { 3, 7 }, { 6, 6 } };
        int[] queries = { 2, 3, 1, 7, 6, 8 };
        Aug0226 aug = new Aug0226();
        System.out.println("minInterval--->" + aug.minInterval(intervals, queries));
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int i = 0;
        while (i < intervals.length && intervals[i][0] <= q) {
            pq.offer(queries);
        }
    }

}
