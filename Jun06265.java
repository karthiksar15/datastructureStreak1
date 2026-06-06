import java.util.Arrays;

public class Jun06265 {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 3 };
        Jun06265 jun = new Jun06265();
        System.out.println("rob--->" + jun.rob(nums));
    }

    public int rob(int[] nums) {
        int[][] memo = new int[nums.length][2];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return Math.max(dfs(nums, memo, 1, 0), dfs(nums, memo, 0, 1));
    }

    public int dfs(int[] nums, int[][] memo, int i, int flag) {
        if (i >= nums.length || (flag == 1 && i == nums.length - 1)) {
            return 0;
        }
        if (memo[i][flag] != -1) {
            return memo[i][flag];
        }
        memo[i][flag] = Math.max(dfs(nums, memo, i + 1, flag),
                nums[i] + dfs(nums, memo, i + 2, (flag == 1 || i == 0) ? 1 : 0));
        return memo[i][flag];
    }

}
