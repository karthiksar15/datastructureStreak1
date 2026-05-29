public class May2926 {

    public static void main(String[] args) {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3 };
        May2926 may = new May2926();
        System.out.println("findMedianSortedArrays--->" + may.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int half = (total + 1) / 2;
        if (n < m) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int l = 0, r = nums1.length;
        while (l <= r) {
            int i = l + (r - l) / 2;
            int j = half - i;
            int aleft = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int aright = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
            int bleft = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int bright = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;
            if (aleft <= bright && bleft <= aright) {
                if (total % 2 != 0) {
                    return Math.max(aleft, bleft);
                }
                return (Math.max(aleft, bleft) + Math.max(aright, bright)) / 2.0;
            } else if (aleft > bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return -1;
    }

}
