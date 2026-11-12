public class Nov122620 {

    public static void main(String[] args) {
        int[] nums = { -2, 4, -5, 4, -5, 9, 4 };
        Nov122620 nov = new Nov122620();
        System.out.println("max--->" + nov.maxSubarraySumCircular(nums));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int globMax = nums[0];
        int globMin = nums[0];
        int currMax = 0;
        int currMin = 0;
        int total = 0;
        for (int n : nums) {
            currMax = Math.max(currMax + n, n);
            currMin = Math.min(currMin + n, n);
            total += n;
            globMax = Math.max(globMax, currMax);
            globMin = Math.min(globMin, currMin);
        }
        return globMax > 0 ? Math.max(globMax, total - globMin) : globMax;
    }

}
