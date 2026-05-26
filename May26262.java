public class May26262 {

    public static void main(String[] args) {
        May26262 may = new May26262();
        // int[] nums = { 3, 4, 5, 6, 1, 2 };
        int[] nums = { 4, 5, 6, 7, 8, 0, 1, 2 };
        int target = 0;
        System.out.println("search--->" + may.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int minIdx = 0;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        minIdx = l;
        // 2. Determine which sorted half to search
        l = 0;
        r = nums.length - 1;

        if (target >= nums[minIdx] && target <= nums[r]) {
            l = minIdx; // Search the right half
        } else {
            r = minIdx - 1; // Search the left half
        }

        // 3. Standard Binary Search on the chosen half
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

}
