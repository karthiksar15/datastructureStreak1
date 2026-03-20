import java.util.Arrays;

public class Mar2026 {

    public static void main(String[] args) {
        int[] nums = { 10, 9, 1, 1, 1, 2, 3, 1 };
        Mar2026 mar = new Mar2026();
        mar.sortArray(nums);
        System.out.println("sorted--->" + Arrays.toString(nums));
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low >= high)
            return;
        int partitionIdx = median(nums, low, low + (high - low) / 2, high);
        swap(nums, partitionIdx, high);
        int p = partition(nums, low, high);
        quickSort(nums, low, p - 1);
        quickSort(nums, p + 1, high);
    }

    public int median(int[] arr, int low, int mid, int high) {
        if (arr[mid] > arr[low] && arr[mid] < arr[high])
            return mid;
        if (arr[low] > arr[mid] && arr[low] < arr[high])
            return low;
        return high;
    }

    public int partition(int[] nums, int low, int high) {
        int temp = nums[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] <= temp) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, high);
        return i + 1;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
