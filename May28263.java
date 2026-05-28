public class May28263 {

    public static void main(String[] args) {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3 };
        May28263 may = new May28263();
        System.out.println("findmedian-->" + may.findMedianSortedArrays(nums1, nums2));
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
        int l = 0;
        int r = nums1.length;
        while (l <= r) {

            int mid = l + (r - l) / 2;
            int j = half - mid;
            int aleft = mid > 0 ? nums1[mid - 1] : Integer.MIN_VALUE;
            int aright = mid < nums1.length ? nums1[mid] : Integer.MAX_VALUE;
            int bleft = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int bright = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;
            if (aleft <= bright && bleft <= aright) {
                if (total % 2 != 0) {
                    return Math.max(aleft, bleft);
                }
                return (Math.max(aleft, bleft) + Math.min(aright, bright)) / 2.0;
            } else if (aleft > bright) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

}
