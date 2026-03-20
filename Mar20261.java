import java.util.Arrays;

public class Mar20261 {

    public static void main(String[] args) {
        Mar20261 mar = new Mar20261();
        int[] nums = { 1, 0, 1, 2 };
        mar.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int max = 2;
        int[] count = new int[max + 1];
        for (int i : nums)
            count[i]++;
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] out = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            out[--count[nums[i]]] = nums[i];
        }
        System.arraycopy(out, 0, nums, 0, nums.length);
    }

}
