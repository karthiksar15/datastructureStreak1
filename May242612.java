import java.util.HashMap;
import java.util.Map;

public class May242612 {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2 };
        int target = 4;
        May242612 may = new May242612();
        System.out.println("combinationSum4--->" + may.combinationSum4(nums, target));
    }

    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int total = 1; total <= target; total++) {
            dp.put(total, 0);
            for (int num : nums) {
                dp.put(total, dp.get(total) + dp.getOrDefault(total - num, 0));
            }
        }
        return dp.get(target);
    }
}
