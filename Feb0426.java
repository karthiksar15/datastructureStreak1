import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Feb0426 {

    public static void main(String[] args) {
        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        String target = "0202";
        Feb0426 feb = new Feb0426();
        System.out.println("find loack-->" + feb.openLock(deadends, target));

    }

    public int openLock(String[] deadends, String target) {
        Set<String> dict = new HashSet<>();
        dict.addAll(Arrays.asList(deadends));
        String start = "0000";
        if (dict.contains(target) || dict.contains(start))
            return -1;
        int count = 0;
        Set<String> visited = new HashSet<>();
        visited.add(start);
        visited.addAll(dict);
        Deque<String> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String oldStr = queue.poll();
                if (oldStr.equals(target))
                    return count;
                for (int i = 0; i < oldStr.length(); i++) {
                    for (int j : List.of(1, -1)) {
                        int charChange = oldStr.charAt(i) - '0';
                        int newNum = (charChange + j + 10) % 10;
                        String newWord = oldStr.substring(0, i) + newNum + oldStr.substring(i + 1);
                        if (visited.add(newWord)) {
                            queue.add(newWord);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
