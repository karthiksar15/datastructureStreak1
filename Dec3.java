import java.math.BigDecimal;
import java.math.RoundingMode;

public class Dec3 {
    public static void main(String[] args) {
        int[] nums = { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        double avg = findAverage(nums, k);
        System.out.println("avg found--" + avg);
    }

    public static double findAverage(int[] nums, int k) {
        double max = 0;
        int left = 0;
        int right = k;
        double sum = 0;
        while (right <= nums.length) {
            sum = 0;
            for (int i = left; i < right; i++) {
                sum = sum + nums[i];
            }
            double avgTemp = sum / k;
            if (avgTemp > max) {
                max = avgTemp;
                System.out.println("inside left-->" + left);
            }
            left++;
            right = left + k;
        }
        return max;

    }

}
