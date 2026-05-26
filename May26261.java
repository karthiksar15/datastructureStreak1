public class May26261 {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 6, 1, 2 };
        May26261 may = new May26261();
        System.out.println("findmin--->" + may.findMin(nums));
    }

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[r];
    }

}
