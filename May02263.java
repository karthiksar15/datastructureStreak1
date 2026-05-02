public class May02262 {

    public static void main(String[] args) {
        int target = 7;
        // int[] nums = { 2, 1, 5, 1, 5, 3 };
        int[] nums = { 7, 3, 1, 1, 1, 1, 1, 1 };
        May02262 may = new May02262();
        System.out.println("subarraylen-->" + may.minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                min = Math.min(r - l + 1, min);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
