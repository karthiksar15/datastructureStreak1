import java.util.Arrays;

public class Jun0526 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int k = 4;
        Jun0526 jun = new Jun0526();
        jun.rotate(nums, k);
        System.out.println("rotate--->" + Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            temp[(k + i) % n] = nums[i];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }

}
