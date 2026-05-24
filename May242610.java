import java.util.Arrays;

public class May242610 {

    public static void main(String[] args) {
        int[] nums = { 9, 1, 4, 2, 3, 3, 7 };
        May242610 may = new May242610();
        System.out.println("lengthOfLIS---->" + may.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
        }
        return Arrays.stream(LIS).max().getAsInt();
    }

}
