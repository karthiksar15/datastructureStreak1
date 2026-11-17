public class Nov17267 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, -3, 5 };
        Nov17267 nov = new Nov17267();
        System.out.println("maxPrdt-->" + nov.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxPdt = 1, minPrdt = 1;
        int res = nums[0];
        for (int i = 0; i < n; i++) {
            int temp = maxPdt * nums[i];
            maxPdt = Math.max(Math.max(temp, minPrdt * nums[i]), nums[i]);
            minPrdt = Math.min(Math.min(temp, minPrdt * nums[i]), nums[i]);
            res = Math.max(maxPdt, res);
        }
        return res;
    }

}
