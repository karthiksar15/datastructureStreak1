public class Oct182611 {

    public static void main(String[] args) {
        Oct182611 oct = new Oct182611();
        int[] nums = { 2, 4, -3, 5 };
        System.out.println("maxPrd--->" + oct.maxProduct(nums));
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
