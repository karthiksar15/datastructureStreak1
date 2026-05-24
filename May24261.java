public class May24261 {

    int[][] memo;

    public static void main(String[] args) {
        int[] nums = { 2, 9, 8, 3, 6 };
        May24261 may = new May24261();
        System.out.println("robber circle--->" + may.rob(nums));
    }

    public int rob(int[] nums) {
        memo = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            memo[i][0] = -1;
            memo[i][1] = -1;
        }
        return Math.max(dfs(0, 0, nums), dfs(0, 1, nums));
    }

    public int dfs(int i, int flag, int[] nums) {
        if (i >= nums.length || (flag == 1 && i == nums.length - 1))
            return 0;
        if (memo[i][flag] != -1)
            return memo[i][flag];
        memo[i][flag] = Math.max(dfs(i + 1, flag, nums), nums[i] + dfs(i + 2, flag | (i == 0 ? 1 : 0), nums));
        return memo[i][flag];
    }

}
