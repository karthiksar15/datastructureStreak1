import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Apr0726 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 3 };
        int k = 2;
        // int[] nums = { 1, 2, 1, 3, 4 };
        // int k = 3;
        Apr06263 apr = new Apr06263();
        System.out.println("subarrays---->" + apr.subarraysWithKDistinct(nums, k));
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            freq.merge(nums[right], 1, Integer::sum); // increment count
            // Shrink window until we have at most k distinct
            while (freq.size() > k) {
                freq.merge(nums[left], -1, Integer::sum);
                if (freq.get(nums[left]) == 0)
                    freq.remove(nums[left]);
                left++;
            }

            // All subarrays ending at right with left..right as leftmost valid start
            count += right - left + 1;
        }

        return count;
    }
}
