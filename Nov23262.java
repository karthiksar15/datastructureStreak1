public class Nov23262 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, -3, 5 };
        Nov23262 nov = new Nov23262();
        System.out.println("maxPrdt-->" + nov.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int maxPrd = 1, minPrdt = 1;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i] * maxPrd;
            maxPrd = Math.max(Math.max(temp, minPrdt * nums[i]), nums[i]);
            minPrdt = Math.min(Math.min(temp, minPrdt * nums[i]), nums[i]);
            res = Math.max(maxPrd, res);
        }
        return res;
    }

}
