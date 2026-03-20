import java.util.Arrays;

public class Mar1926 {

    public static void main(String[] args) {
        String[] str = { "Karthik", "Nethra", "Nakshu", "Meeuchi" };
        sort(str);
        System.out.println(Arrays.toString(str));
    }

    public static void sort(String[] str) {
        int low = 0;
        int high = str.length - 1;
        sortString(low, high, 0, str);
    }

    public static void sortString(int low, int high, int d, String[] str) {
        if (low >= high)
            return;
        int R = 256;
        int[] count = new int[R + 2];
        String[] aux = new String[high - low + 1];
        for (int i = low; i <= high; i++)
            count[charAt(str[i], d) + 2]++;
        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];
        for (int i = low; i <= high; i++)
            aux[count[charAt(str[i], d) + 1]++] = str[i];
        for (int i = low; i <= high; i++)
            str[i] = aux[i - low];
        for (int r = 0; r < R; r++)
            sortString(low + count[r], low + count[r + 1] - 1, d + 1, str);

    }

    public static int charAt(String s, int d) {
        return (d < s.length()) ? s.charAt(d) : -1;
    }

}
