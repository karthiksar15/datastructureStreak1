import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class May2126 {

    PriorityQueue<int[]> freq;
    Map<Integer, Integer> map;
    private int index;

    public May2126() {
        freq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? Integer.compare(b[0], a[0]) : Integer.compare(b[1], a[1]));
        map = new HashMap<>();
        index = 0;
    }

    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        freq.offer(new int[] { map.get(val), index++, val });
    }

    public int pop() {
        int[] top = freq.poll();
        int val = top[2];
        map.put(val, map.get(val) - 1);
        return val;
    }
}
