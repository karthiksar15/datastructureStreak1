import java.util.Arrays;

public class Jun0326 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int k = 4;
        Jun0326 jun = new Jun0326();
        jun.rotate(nums, k);
        System.out.println("jun--->" + Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++)
            temp[(k + i) % n] = nums[i];
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

}
