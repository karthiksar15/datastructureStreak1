public class Apr06261 {

    public static void main(String[] args) {
        Apr06261 apr = new Apr06261();
        int[] nums = { 10, 5, 2, 6 };
        int k = 100;
        System.out.println("num subarray--->" + apr.numSubarrayProductLessThanK(nums, k));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int ans = 0;
        int left = 0;
        int curr = 1;

        for (int right = 0; right < nums.length; right++) {
            curr *= nums[right];
            while (curr >= k) {
                curr /= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }

}
