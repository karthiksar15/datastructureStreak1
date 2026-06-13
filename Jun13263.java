public class Jun13263 {

    public static void main(String[] args) {
        int[] nums = { 2, -3, 4, -2, 2, 1, -1, 4 };
        Jun13263 jun = new Jun13263();
        System.out.println("maxSubArr--->" + jun.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int maxEnding = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tot = maxEnding + nums[i];
            maxEnding = Math.max(nums[i], tot);
            res = Math.max(maxEnding, res);
        }
        return res;
    }

}
