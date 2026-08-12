import java.util.Arrays;
import java.util.PriorityQueue;

class Aug1126 {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 3 }, { 3, 7 }, { 6, 6 } };
        int[] queries = { 2, 3, 1, 7, 6, 8 };
        Aug1126 aug = new Aug1126();
        System.out.println("min---->" + Arrays.toString(aug.minInterval(intervals, queries)));
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] res = new int[queries.length];
        int j = 0;
        for (int q : queries) {
            int i = 0;
            while (i < intervals.length && intervals[i][0] <= q) {
                pq.offer(new int[] { intervals[i][1] - intervals[i][0] + 1, intervals[i][1] });
                i++;
            }
            while (!pq.isEmpty() && q > pq.peek()[1]) {
                pq.poll();
            }
            if (pq.isEmpty()) {
                res[j] = -1;
            } else {
                res[j] = pq.poll()[0];
            }
            j++;
        }
        return res;
    }
}