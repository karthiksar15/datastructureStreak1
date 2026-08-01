import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Jul2826 {

    public class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Jul2826 jul = new Jul2826();
        List<Interval> intervals = new ArrayList<>(
                List.of(jul.new Interval(0, 30), jul.new Interval(5, 10), jul.new Interval(15, 20)));
        System.out.println("canAttend--->" + jul.canAttendMeetings(intervals));
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

}
