import java.util.Arrays;

public class Mar0426 {

    public static void main(String[] args) {
        Mar0426 mar = new Mar0426();
        // int[] nums = { 5, 5, 1, 1, 1, 5, 5 };
        int[] nums = { 3, 3, 4 };
        System.out.println("maj--->" + mar.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int[] results = new int[2];
        int n = nums.length;
        int majority = n / 2;
        int prev = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (prev != nums[i]) {
                validateMax(cnt, prev, majority, results);
                cnt = 1;
            } else {
                cnt++;
            }
            prev = nums[i];
        }
        return validateMax(cnt, prev, majority, results);
    }

    private int validateMax(int cnt, int prev, int majority, int[] results) {
        if (cnt > results[0]) {
            results[0] = cnt;
            results[1] = prev;
        }
        if (results[0] > majority) {
            return results[1];
        }
        return 1;
    }
}
