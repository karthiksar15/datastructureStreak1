public class Oct27262 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, -3, 5 };
        Oct27262 oct = new Oct27262();
        System.out.println("maxPrdt--->" + oct.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int minPrdt = 1, maxPrdt = 1;
        int n = nums.length, res = nums[0];
        for (int i = 0; i < n; i++) {
            int tmp = maxPrdt * nums[i];
            maxPrdt = Math.max(Math.max(tmp, minPrdt * nums[i]), nums[i]);
            minPrdt = Math.min(Math.min(tmp, minPrdt * nums[i]), nums[i]);
            res = Math.max(res, maxPrdt);
        }
        return res;
    }

}
