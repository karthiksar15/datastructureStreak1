public class Jun24262 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, -3, 5 };
        Jun24262 jun = new Jun24262();
        System.out.println("maxPrdt--->" + jun.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMax = 1, currMin = 1;
        for (int i = 0; i < nums.length; i++) {
            int temp = currMax * nums[i];
            currMax = Math.max(nums[i], Math.max(currMin * nums[i], temp));
            currMin = Math.min(nums[i], Math.min(currMin * nums[i], temp));
            res = Math.max(res, currMax);
        }
        return res;
    }

}
