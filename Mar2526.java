import java.util.Arrays;

public class Mar2526 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 6 };
        Mar2526 mar = new Mar2526();
        System.out.println("product----" + Arrays.toString(mar.productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] results = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 1;
        suffix[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            results[i] = prefix[i] * suffix[i];
        }
        return results;
    }

}
