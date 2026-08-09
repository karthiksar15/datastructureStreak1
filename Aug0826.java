import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Aug0826 {

    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Aug0826 aug = new Aug0826();
        List<Interval> intervals = Arrays.asList(aug.new Interval(0, 40),
                aug.new Interval(5, 10),
                aug.new Interval(15, 20));
        System.out.println("minMeeting--->" + aug.minMeetingRooms(intervals));

    }

    public int minMeetingRooms(List<Interval> intervals) {
        List<int[]> time = new ArrayList<>();
        for (Interval i : intervals) {
            time.add(new int[] { i.start, 1 });
            time.add(new int[] { i.end, -1 });
        }
        time.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int res = 0, count = 0;
        for (int[] t : time) {
            count += t[1];
            res = Math.max(res, count);
        }
        return res;
    }

}
