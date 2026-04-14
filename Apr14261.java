import java.util.Arrays;

public class Apr14261 {

    public static void main(String[] args) {
        int[] nums1 = { 10, 20, 20, 40, 0, 0 };
        int m = 4;
        int[] nums2 = { 1, 2 };
        int n = 2;
        Apr14261 apr = new Apr14261();
        apr.merge(nums1, m, nums2, n);
        System.out.println("result-->" + Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else if (j >= 0) {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }
    }

}
