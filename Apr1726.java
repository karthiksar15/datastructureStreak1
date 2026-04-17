import java.util.Arrays;

public class Apr1726 {

    public static void main(String[] args) {
        Apr1726 apr = new Apr1726();
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        apr.rotate(nums, k);
        System.out.println("rotate--->" + Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // while (k > 0) {
        // int temp = nums[n - 1];
        // for (int i = n - 1; i > 0; i--) {
        // nums[i] = nums[i - 1];
        // }
        // nums[0] = temp;
        // k--;
        // }
        k %= n;
        int count = 0;

        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int nextIdx = (current + k) % n;
                int temp = nums[nextIdx];
                nums[nextIdx] = prev;
                prev = temp;
                current = nextIdx;
                count++;
            } while (start != current);
        }
    }

}
