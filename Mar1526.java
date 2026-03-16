import java.util.Arrays;

public class Mar1526 {

    public static void main(String[] args) {
        int[] arr = { 4, 2, 5, 7, 1, 3, 9 };
        sort(arr);
        System.out.println("sorted arr--->" + Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int pivot = medianOfThree(arr, low, low + (high - low) / 2, high);
        swap(arr, pivot, high);
        int p = partition(arr, low, high);
        sort(arr, low, p - 1);
        sort(arr, p + 1, high);
    }

    public static int partition(int[] arr, int low, int high) {
        int key = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= key) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int medianOfThree(int[] arr, int low, int mid, int high) {
        if (arr[mid] > arr[low] && arr[mid] < arr[high])
            return mid;
        if (arr[low] > arr[mid] && arr[low] < arr[high])
            return low;
        return high;
    }

}
