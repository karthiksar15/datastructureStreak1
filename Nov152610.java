public class Nov152610 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, -3, 5 };
        Nov152610 nov = new Nov152610();
        System.out.println("maxPrdt---" + nov.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxPrdt = 1, minPrdt = 1;
        int res = nums[0];
        for (int i = 0; i < n; i++) {
            int tmp = maxPrdt * nums[i];
            maxPrdt = Math.max(Math.max(tmp, minPrdt * nums[i]), nums[i]);
            minPrdt = Math.min(Math.min(tmp, minPrdt * nums[i]), nums[i]);
            if (maxPrdt > res)
                res = maxPrdt;
        }
        return res;
    }

}
