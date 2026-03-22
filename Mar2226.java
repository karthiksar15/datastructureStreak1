import java.util.List;

public class Mar2226 {

    public static void main(String[] args) {
        Mar2226 mar = new Mar2226();
        List<String> str = List.of("Hello", "World");
        System.out.println(mar.encode(str));
    }

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            int len = str.length();
            StringBuilder sb = new StringBuilder(len);
            str.join("#", str.split(" "));
            result.append(sb);
        }
        return result.toString();
    }

}
