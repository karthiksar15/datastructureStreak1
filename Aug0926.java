import java.util.Arrays;
import java.util.PriorityQueue;

public class Aug0926 {

    public static void main(String[] args) {
        Aug0926 aug = new Aug0926();
        int n = 2;
        int[][] meetings = { { 1, 10 }, { 2, 10 }, { 3, 10 }, { 4, 10 } };
        System.out.println("most booked--->" + aug.mostBooked(n, meetings));
    }

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])));
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { 0, i });
        }
        int[] count = new int[n];
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            while (!pq.isEmpty() && pq.peek()[0] < start) {
                int[] earliest = pq.poll();
                pq.offer(new int[] { start, earliest[1] });
            }
            int[] room = pq.poll();
            int endTime = room[0] + (end - start);
            pq.offer(new int[] { endTime, room[1] });
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
