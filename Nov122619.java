public class Nov122619 {

    public static void main(String[] args) {
        int[] nums = { 2, -3, 4, -2, 2, 1, -1, 4 };
        Nov122619 nov = new Nov122619();
        System.out.println("maxSubArray-->" + nov.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

}
