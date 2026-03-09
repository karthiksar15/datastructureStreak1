import java.util.Arrays;

public class Mar0926 {
    public static void main(String[] args) {
        Mar0926 mar = new Mar0926();
        int[] nums = { 3, 2, 6, 4, 8, 9, 1 };
        Arrays.stream(mar.sortArray(nums)).forEach(System.out::println);
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
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
