import java.util.Arrays;

public class Mar1426 {
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
        int mid = low + (high - low) / 2;
        sort(arr, 0, mid);
        sort(arr, mid + 1, high);
        mergeSort(arr, low, mid, high);
    }

    public static void mergeSort(int[] arr, int low, int mid, int high) {
        int i = low, j = mid + 1;
        int[] aux = Arrays.copyOf(arr, high + 1);
        for (int k = low; k <= high; k++) {
            if (i > mid)
                arr[k] = aux[j++];
            else if (j > high)
                arr[k] = aux[i++];
            else if (aux[i] <= aux[j])
                arr[k] = aux[i++];
            else
                arr[k] = aux[j++];
        }

    }

}
