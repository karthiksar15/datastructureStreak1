import java.util.Arrays;

public class Mar1226 {

    public static void main(String[] args) {
        Mar1226 mar = new Mar1226();
        int[] arr = { 4, 2, 5, 7, 1, 3, 9 };
        mar.sort(arr);
        System.out.println("sorted arr--->" + Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int pivot = median(arr, low, low + (high - low) / 2, high);
        swap(arr, pivot, high);
        int p = partition(arr, low, high);
        sort(arr, low, p - 1);
        sort(arr, p + 1, high);
    }

    public int partition(int[] arr, int low, int high) {
        int key = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= key) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    public int median(int[] arr, int low, int mid, int high) {
        // Return index of median of three values
        int a = arr[low], b = arr[mid], c = arr[high];
        if ((a <= b && b <= c) || (c <= b && b <= a))
            return mid;
        if ((b <= a && a <= c) || (c <= a && a <= b))
            return low;
        return high;
    }

}
