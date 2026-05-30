import java.lang.reflect.Array;
import java.util.Arrays;

public class May30265 {

    private int[] memo;

    public static void main(String[] args) {
        int[] nums = { 1, 1, 3, 3 };
        May30265 may = new May30265();
        System.out.println("rob--->" + may.rob(nums));
    }

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(nums, 0);
    }

    public int dfs(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        memo[i] = Math.max(dfs(nums, i + 1), nums[i] + dfs(nums, i + 2));
        return memo[i];
    }

}
