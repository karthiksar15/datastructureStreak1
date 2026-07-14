public class Jul1326 {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 3 };
        Jul1326 jul = new Jul1326();
        System.out.println("rob---->" + jul.rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = nums[1];
        dp[1][1] = nums[0];

        for(int i=)
    }

}
