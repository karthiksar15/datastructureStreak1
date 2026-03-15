import java.util.Arrays;

public class Mar1326 {

    private static int[] aux;

    public static void main(String[] args) {
        Mar1326 mar = new Mar1326();
        int[] arr = { 4, 2, 5, 7, 1, 3, 9 };
        mar.sort(arr);
        System.out.println("sorted arr--->" + Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        aux = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int low, int high) {
        if (low <= high)
            return;
        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        mergeSort(arr, low, mid, high);
    }

    public void mergeSort(int[] arr, int low, int mid, int high) {

        for (int k = low; k <= high; k++) {
            aux[k] = arr[k];
        }
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (aux[i] <= aux[j])
                arr[k] = aux[i++];
            else if (aux[j] <= aux[i])
                arr[k] = aux[j++];
            else if (i > mid)
                arr[k] = aux[i++];
            else
                arr[k] = aux[mid++];
        }
    }

}
