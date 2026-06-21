import java.util.HashMap;
import java.util.Map;

public class Jun1726 {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2 };
        int target = 4;
        Jun1726 jun = new Jun1726();
        System.out.println("combi--->" + jun.combinationSum4(nums, target));
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
