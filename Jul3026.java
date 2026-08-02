import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Jul3026 {

    class Interval {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Jul3026 jul = new Jul3026();
        int n = 3;
        int[][] meetings = { { 1, 20 }, { 2, 10 }, { 3, 5 }, { 6, 8 }, { 4, 9 } };
        System.out.println("minMeeting--->" + jul.mostBooked(n, meetings));
    }

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { 0, i });
        }
        int[] count = new int[n];
        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            while (!pq.isEmpty() && pq.peek()[0] < start) {
                int[] earliest = pq.poll();
                pq.offer(new int[] { start, earliest[1] });
            }
            int[] room = pq.poll();
            int endTime = room[0] + (end - start);
            pq.offer(new int[] { endTime, room[1] });
            count[room[1]]++;
        }
        int maxRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[1] > count[maxRoom])
                maxRoom = i;
        }
        return maxRoom;
    }

}
