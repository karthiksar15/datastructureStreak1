import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Jul2126
 */
public class Jul2126 {
    public static void main(String[] args) {
        int n = 3;
        int[][] meetings = { { 1, 20 }, { 2, 10 }, { 3, 5 }, { 6, 8 }, { 4, 9 } };
        Jul2126 jul = new Jul2126();
        System.out.println("mostBooked--->" + jul.mostBooked(n, meetings));
    }

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
        for (int i = 0; i < n; i++) {
            pq.offer(new long[] { 0, i });
        }
        int[] count = new int[n];
        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            while (!pq.isEmpty() && pq.peek()[0] < start) {
                long[] earliest = pq.poll();
                pq.offer(new long[] { start, earliest[1] });
            }
            long[] room = pq.poll();
            long endTime = room[0] + (end - start);
            pq.offer(new long[] { endTime, room[1] });
            count[(int) room[1]]++;
        }

        int maxRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[maxRoom]) {
                maxRoom = i;
            }
        }
        return maxRoom;
    }
}
