public class Jul11261 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, -3, 5 };
        Jul11261 jul = new Jul11261();
        System.out.println("maxPrdt--->" + jul.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int maxPrdt = 1, minPrdt = 1;
        int res = nums[0];
        for (int n : nums) {
            int temp = maxPrdt * n;
            maxPrdt = Math.max(n, Math.max(temp, minPrdt * n));
            minPrdt = Math.min(n, Math.min(temp, minPrdt * n));
            res = Math.max(maxPrdt, res);
        }
        return res;
    }

}
