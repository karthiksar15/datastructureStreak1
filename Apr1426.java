import java.util.Arrays;

public class Apr1426 {

    public static void main(String[] args) {
        int[] nums1 = { 10, 20, 20, 40, 0, 0 };
        int m = 4;
        int[] nums2 = { 1, 2 };
        int n = 2;
        Apr1426 apr = new Apr1426();
        apr.merge(nums1, m, nums2, n);
        System.out.println("result-->" + Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        int i = m - 1, j = n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[last--] = nums1[i--];
            } else {
                nums1[last--] = nums2[j--];
            }
        }
    }

}
