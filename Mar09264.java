import java.util.Arrays;
import java.util.Random;

public class Mar0926 {
    private final Random rng = new Random();

    public static void main(String[] args) {
        Mar0926 mar = new Mar0926();
        int[] nums = { 3, 2, 6, 4, 8, 9, 1 };
        System.out.println(Arrays.toString(mar.sortArray(nums)));
    }

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) return nums;
        // Early exit if already sorted (non-decreasing)
        if (isSorted(nums)) return nums;
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) return false;
        }
        return true;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        // Randomized pivot: move a random index in [left, right] to the end
        int pivotIndex = left + rng.nextInt(right - left + 1);
        swap(nums, pivotIndex, right);
        int p = partition(nums, left, right); // pivot index after partition
        quickSort(nums, left, p - 1); // left side
        quickSort(nums, p + 1, right);
    }

    // Lomuto partition: pivot is arr[high]
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low; // place for next smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high); // put pivot in its final place
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
