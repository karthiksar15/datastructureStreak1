import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Mar01261 {

    public static void main(String[] args) {
        Mar01261 mar = new Mar01261();
        int[] nums = { 3, 4, 5, 6 };
        int target = 7;
        Arrays.stream(mar.twoSum(nums, target)).forEach(System.out::println);
    }

    /**
     * One-pass hash map approach for Two Sum.
     * - Time: O(n), Space: O(n)
     * - Avoids same-index pairing by checking complement before storing current
     * element.
     * - Early exits on first valid pair found.
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            Integer j = seen.get(complement);
            if (j != null) {
                // j was stored earlier, so j < i and j != i guaranteed
                return new int[] { j, i };
            }
            // Store after check to prevent pairing element with itself
            seen.put(nums[i], i);
        }
        // No solution found - return empty array (or throw exception if guaranteed to
        // have solution)
        return new int[0];
    }

}
