import java.util.Arrays;

public class Mar2126 {

    public static void main(String[] args) {
        String[] str = { "Ki", "Ka", "Ri", "Ra" };
        Mar2126 mar = new Mar2126();
        mar.sort(str);
        System.out.println(Arrays.toString(str));
    }

    public void sort(String[] str) {
        sortMSB(str, 0, str.length - 1, 0);
    }

    public void sortMSB(String[] str, int low, int high, int bucket) {
        if (low >= high)
            return;
        int[] count = new int[256 + 2];
        for (String word : str) {
            count[findChar(word, bucket) + 2]++;
        }
        for (int i = 0; i < 257; i++) {
            count[i + 1] += count[i];
        }
        String[] aux = new String[high - low + 1];
        for (int i = low; i <= high; i++) {
            aux[count[findChar(str[i], bucket) + 1]++] = str[i];
        }
        for (int i = low; i <= high; i++) {
            str[i] = aux[i - low];
        }
        for (int r = 0; r < 258; r++) {
            sortMSB(str, low + count[r], low + count[r + 1] - 1, bucket + 1);
        }
    }

    public int findChar(String str, int bucket) {
        return (bucket < str.length()) ? str.charAt(bucket) : -1;
    }

}
