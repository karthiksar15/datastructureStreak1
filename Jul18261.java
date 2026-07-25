import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Jul18261 {

    public static void main(String[] args) {
        Jul18261 jul = new Jul18261();
        List<Interval> intervals = List.of(jul.new Interval(5, 10), jul.new Interval(15, 20));
        System.out.println("canAttendMeeting--->" + jul.canAttendMeetings(intervals));
    }

    public boolean canAttendMeetings(List<Interval> intervals) {

        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
        for (int i = 1; i < intervals.size(); i++) {
            Interval i1 = intervals.get(i - 1);
            Interval i2 = intervals.get(i);
            if (i1.end > i2.start)
                return false;
        }
        return true;
    }

    public class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
