public class May24266 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, -3, 4 };
        May24266 may = new May24266();
        System.out.println("maxPrdt--->" + may.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1, curMax = 1;
        for (int num : nums) {
            int tmp = curMax * num;
            curMax = Math.max(Math.max(tmp, curMin * num), num);
            curMin = Math.min(Math.min(tmp, num * curMin), num);
            res = Math.max(res, curMax);
        }
        return res;
    }

}
