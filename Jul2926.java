import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Jul2926 {

    class Interval {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Jul2926 jul = new Jul2926();
        List<Interval> intervals = new ArrayList<>(
                List.of(jul.new Interval(0, 40), jul.new Interval(5, 10), jul.new Interval(15, 20)));
        System.out.println("minMeeting--->" + jul.minMeetingRooms(intervals));
    }

    public int minMeetingRooms(List<Interval> intervals) {

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Interval itr : intervals) {
            if (!pq.isEmpty() && pq.peek() < itr.start) {
                pq.poll();
            }
            pq.offer(itr.end);
        }
        return pq.size();

    }

}
