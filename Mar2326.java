import java.util.Arrays;

public class Mar2326 {

    public static void main(String[] args) {
        String[] arr = { "Nakshu", "Neni", "Karthik", "Krithik" };
        Mar2326 mar = new Mar2326();
        mar.sortByMSB(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sortByMSB(String[] names) {
        sort(names, 0, names.length - 1, 0);
    }

    public void sort(String[] names, int low, int high, int bucket) {
        if (low >= high)
            return;
        int R = 256;
        int[] count = new int[R + 2];
        for (int i = low; i <= high; i++) {
            count[findChar(names[i], bucket) + 2]++;
        }
        for (int i = 0; i <= R; i++) {
            count[i + 1] += count[i];
        }
        String[] aux = new String[high - low + 1];
        for (int i = low; i <= high; i++) {
            aux[count[findChar(names[i], bucket) + 1]++] = names[i];
        }
        for (int i = low; i <= high; i++) {
            names[i] = aux[i - low];
        }
        for (int i = 0; i < R; i++) {
            sort(names, low + count[i], low + count[i + 1] - 1, bucket + 1);
        }
    }

    public int findChar(String str, int bucket) {
        int c = str.charAt(bucket);
        return str.length() < bucket ? -1 : c;
    }

}
