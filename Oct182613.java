
import java.util.Arrays;

public class Oct182613 {

    public static void main(String[] args) {
        int[] nums = { 9, 1, 4, 2, 3, 3, 7 };
        Oct182613 oct = new Oct182613();
        System.out.println("lengthOfLIS--->" + oct.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                // LIS[i] = LIS[i + 1];
                if (nums[i] < nums[j]) {
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
        }
        return LIS[0];
    }

}
