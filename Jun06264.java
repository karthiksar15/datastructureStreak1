import java.util.Arrays;

public class Jun06264 {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 3, 3 };
        Jun06264 jun = new Jun06264();
        System.out.println("rob--->" + jun.rob(nums));
    }

    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(nums, memo, 0);
    }

    public int dfs(int[] nums, int[] memo, int i) {
        if (i >= nums.length)
            return 0;
        if (memo[i] != -1)
            return memo[i];
        memo[i] = Math.max(nums[i], nums[i] + dfs(nums, memo, i + 2));
        return memo[i];
    }

}
