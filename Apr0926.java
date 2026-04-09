import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Apr0926 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 0, 4, 2, 6 };
        int k = 3;
        Apr0826 apr = new Apr0826();
        System.out.println("max--->" + Arrays.toString(apr.maxSlidingWindow(nums, k)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // int[] result = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        int left = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() == k) {
                list.add(queue.peek());
                queue.remove(nums[left]);
                left++;
            }
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        // return result;
    }

}
