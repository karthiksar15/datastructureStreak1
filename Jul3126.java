import java.util.Arrays;

public class Jul3126 {

    public static void main(String[] args) {
        Jul3126 jul = new Jul3126();
        int[][] intervals = { { 1, 3 }, { 2, 3 }, { 3, 7 }, { 6, 6 } };
        int[] queries = { 2, 3, 1, 7, 6, 8 };
        System.out.println("minInterval--->" + Arrays.toString(jul.minInterval(intervals, queries)));
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] results = new int[queries.length];
        Arrays.fill(results, Integer.MAX_VALUE);
        int i = 0;
        for (int q : queries) {
            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];
                if (start <= q && q <= end) {
                    results[i] = Math.min((end - start) + 1, results[i]);
                }
            }
            if (results[i] == Integer.MAX_VALUE)
                results[i] = -1;
            i++;
        }
        return results;
    }

}
