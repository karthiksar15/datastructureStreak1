import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Mar20262 {

    public static void main(String[] args) {
        Mar20262 mar = new Mar20262();
        int[] nums = { 1, 2, 2, 3, 3, 3 };
        int k = 2;
        int[] res = mar.topKFrequent(nums, k);
        System.out.println(Arrays.toString(res));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 1) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll(); // guaranteed order
        }
        return result;
    }
}
