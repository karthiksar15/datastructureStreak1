public class Jun0926 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, -3, 5 };
        Jun0926 jun = new Jun0926();
        System.out.println("maxPrdct--->" + jun.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMin = 1, currMax = 1;
        for (int n : nums) {
            int tmp = currMax * n;
            currMax = Math.max(Math.max(tmp, currMin * n), n);
            currMin = Math.min(Math.min(tmp, currMin * n), n);
            res = Math.max(res, currMax);
        }
        return res;
    }

}
