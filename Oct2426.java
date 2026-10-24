public class Oct2426 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, -3, 5 };
        Oct2426 oct = new Oct2426();
        System.out.println("maxPrdt--->" + oct.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int res = nums[0];
        int maxPrdt = 1, minPrdt = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int tmp = maxPrdt * nums[i];
            maxPrdt = Math.max(tmp, Math.max(minPrdt * nums[i], nums[i]));
            minPrdt = Math.min(tmp, Math.min(minPrdt * nums[i], nums[i]));
            res = Math.max(maxPrdt, res);
        }
        return res;
    }

}
