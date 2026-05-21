public class May21263 {

    public static void main(String[] args) {
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2, 4 };
        May21263 may = new May21263();
        System.out.println("findMedianSortedArrays--->" + may.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;

        if (nums2.length < nums1.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int l = nums1.length;
        int r = nums2.length;
        while (l <= r) {
            int i = (l + r) / 2;
            int j = half - i;

            int Aleft = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int Aright = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int Bright = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 != 0) {
                    return Math.max(Aleft, Bleft);
                }
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }

        }
        return -1;
    }

}
