public class Nov19265 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, -3, 5 };
        Nov19265 nov = new Nov19265();
        System.out.println("maxPrdt-->" + nov.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxPrdt = 1, minPrdt = 1;
        int res = nums[0];
        for (int i = 0; i < n; i++) {
            int temp = maxPrdt * nums[i];
            maxPrdt = Math.max(Math.max(temp, minPrdt * nums[i]), nums[i]);
            minPrdt = Math.min(Math.min(temp, minPrdt * nums[i]), nums[i]);
            res = Math.max(maxPrdt, res);
        }
        return res;
    }
}
