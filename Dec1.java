import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The Dec1 class provides methods to reverse a string using two different
 * approaches:
 * a traditional iterative method and a method utilizing Java Streams.
 * 
 * <p>
 * The main method demonstrates both approaches by reversing a sample string.
 * </p>
 * 
 * <ul>
 * <li>{@link #reverse(char[])}: Reverses a character array using a two-pointer
 * technique.</li>
 * <li>{@link #reverseStreams(char[])}: Reverses a character array using Java
 * Streams.</li>
 * </ul>
 */

public class Dec1 {

    public static void main(String[] args) {

        String name = "karthik";
        reverse(name.toCharArray());
        System.out.println("using streams--->" + reverseStreams((name.toCharArray())));

    }

    public static String reverse(char[] nameArray) {
        int i = 0;
        int j = nameArray.length - 1;
        while (i != j) {
            char temp = nameArray[i];
            nameArray[i] = nameArray[j];
            nameArray[j] = temp;
            i++;
            j--;
        }
        System.out.print("without streams-->");
        for (int in = 0; in < nameArray.length; in++) {
            System.out.print(nameArray[in]);
        }
        System.out.println("");
        return String.copyValueOf(nameArray);
    }

    public static String reverseStreams(char[] nameArray) {
        List<Character> reversedList = IntStream.range(0, nameArray.length)
                .mapToObj(i -> nameArray[i]).collect(Collectors.toList());
        Collections.reverse(reversedList);
        return reversedList.stream().map(String::valueOf).collect(Collectors.joining());
    }

}
