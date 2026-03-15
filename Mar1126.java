import java.util.Arrays;

public class Mar1126 {

    public static void main(String[] args) {
        int[] arr = { 4, 2, 5, 7, 1, 3, 9 };
        sort(arr);
        System.out.println("sorted arr--->" + Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int low, int high) {
        for (int i = low; i < high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

}
