public class Apr0126 {

    public static void main(String[] args) {
        Apr0126 apr = new Apr0126();
        int[] nums = { -1, 0, 2, 4, 6, 8 };
        int target = 5;
        System.out.println("search at--->" + apr.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int res = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

}
