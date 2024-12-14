import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Set;

public class Dec12 {

    public static void main(String[] args) {
        int[] nums = { 5, 7, 3, 9, 4, 9, 8, 3, 1 };
        System.out.println(largetNumber(nums));
    }

    public static int largetNumber(int[] nums) {

        // solution:1
        var map = new HashMap<Integer, Integer>();
        int max = -1;
        for (int num : nums) {
            map.computeIfAbsent(num, k -> 0);
            map.put(num, map.get(num) + 1);
        }
        for (Entry<Integer, Integer> set : map.entrySet()) {
            if (set.getKey() > max && set.getValue() == 1) {
                max = Math.max(max, set.getKey());
            }
        }

        return max;

    }

}
