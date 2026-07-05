public class Jul0426 {
    public int maxProduct(int[] nums) {
        int currMax = 1, currMin = 1;
        int res = nums[0];
        for (int n : nums) {
            int temp = currMax * n;
            currMax = Math.max(Math.max(temp, currMin * n), n);
            currMin = Math.min(Math.min(temp, currMin * n), n);
            res = Math.max(currMax, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 4, -3, 5 };
        Jul0426 jul = new Jul0426();
        System.out.println("maxPrdt--->" + jul.maxProduct(nums));
    }
}
