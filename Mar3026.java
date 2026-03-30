class Mar3026 {

    public static void main(String[] args) {
        int[] nums = { -1, 0, 2, 4, 6, 8 };
        int target = 4;
        Mar3026 mar = new Mar3026();
        System.out.println("target---->" + mar.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;

    }

}
