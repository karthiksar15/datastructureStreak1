import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Jul1926 {

    public static void main(String[] args) {
        Jul1926 jul = new Jul1926();
        List<Interval> intervals = new ArrayList<>(
                List.of(jul.new Interval(0, 40), jul.new Interval(5, 10), jul.new Interval(15, 20)));
        System.out.println("minMeetingRooms--->" + jul.minMeetingRooms(intervals));
    }

    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Interval interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                minHeap.poll();
            }
            minHeap.offer(interval.end);
        }
        return minHeap.size();
    }

    public class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
