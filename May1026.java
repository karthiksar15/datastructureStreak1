public class May1026 {

    public static void main(String[] args) {
        int[] nums = { -1, 0, 2, 4, 6, 8 };
        int target = 5;
        May1026 may = new May1026();
        System.out.println("serach--->" + may.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        int res = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }

}
