import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dec2 {

    /**
     * The main method of the Dec2 class contains a sample scenario for
     * demonstrating the sortedSquares method. It creates an array of integers
     * and prints the array of squares of the integers in sorted order to the
     * console.
     */
    public static void main(String[] args) {

        int[] nums = { -4, -1, 0, 3, 10 };
        int[] result = sortedSquares(nums);
        int[] resultStreams = sortedSquaresUsingStreams(nums);
        String resultString = Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(","));
        String resultStreamsString = Arrays.stream(resultStreams).mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(resultString);
        System.out.println(resultStreamsString);
    }

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int index = nums.length - 1;
        while (i != j) {
            int prd1 = nums[i] * nums[i];
            int prd2 = nums[j] * nums[j];
            if (prd1 > prd2) {
                result[index] = prd1;
                i++;
            } else {
                result[index] = prd2;
                j--;
            }
            index--;
        }
        return result;
    }

    public static int[] sortedSquaresUsingStreams(int[] nums) {
        return Arrays.stream(nums).map(x -> x * x).sorted().toArray();
    }

}
