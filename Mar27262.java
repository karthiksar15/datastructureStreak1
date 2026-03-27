public class Mar27262 {

    public static void main(String[] args) {
        int[] nums = { 2, -1, 1, 2 };
        int k = 2;
        // int[] nums = { -1, -1, 1 };
        // int k = 0;
        Mar27262 mar = new Mar27262();
        System.out.println("subarray--->" + mar.subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        int sum = 0;
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum > k) {
                sum -= nums[ptr];
                ptr++;
            }
            if (sum == k) {
                count++;
            }
        }

        while (ptr < n) {
            sum -= nums[ptr];
            if (sum == k && ptr != n - 1) {
                count++;
            }
            ptr++;
        }
        return count;
    }

}
