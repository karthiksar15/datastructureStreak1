import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Jul2326 {

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 3 }, { 3, 7 }, { 6, 6 } };
        int[] queries = { 2, 3, 1, 7, 6, 8 };
        Jul2326 jul = new Jul2326();
        System.out.println("minIntervals--->" + Arrays.toString(jul.minInterval(intervals, queries)));
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt((a) -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> res = new HashMap<>();
        int i = 0;
        for (int q : Arrays.stream(queries).sorted().toArray()) {
            while (i < intervals.length && intervals[i][0] <= q) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                pq.offer(new int[] { r - l + 1, r });
                i++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < q) {
                pq.poll();
            }
            res.put(q, pq.isEmpty() ? -1 : pq.peek()[0]);
        }
        int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = res.get(queries[j]);
        }
        return result;

    }

}
