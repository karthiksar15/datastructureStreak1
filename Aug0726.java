import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Aug0726 {

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        Aug0726 aug = new Aug0726();
        List<Interval> intervals = Arrays.asList(
                aug.new Interval(0, 30),
                aug.new Interval(5, 10),
                aug.new Interval(15, 20));
        System.out.println("canAttend--->" + aug.canAttendMeetings(intervals));
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty())
            return false;
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        int prevEnd = 0;
        for (Interval interval : intervals) {
            if (interval.start < prevEnd)
                return false;
            prevEnd = interval.end;
        }
        return true;
    }
}
