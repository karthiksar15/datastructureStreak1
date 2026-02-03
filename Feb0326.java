import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Feb0326 {

    public static void main(String[] args) {
        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        String target = "0202";
        Feb0326 feb = new Feb0326();
        System.out.println("openLock--->" + feb.openLock(deadends, target));
    }

    public int openLock(String[] deadends, String target) {
        String src = "0000";
        Set<String> dict = new HashSet<>(Arrays.asList(deadends));
        if (dict.contains(target))
            return -1;
        Deque<String> queue = new LinkedList<>();
        queue.add(src);
        Set<String> visited = new HashSet<>();
        visited.add(src);
        visited.addAll(dict);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (temp.equals(target)) {
                    return level;
                }
                for (int s = 0; s < temp.length(); s++) {
                    for (int sign : List.of(1, -1)) {
                        int oldNum = temp.charAt(s) - '0';
                        int newNum = (oldNum + sign + 10 % 10);
                        String newWord = temp.substring(0, s) + newNum + temp.substring(s + 1);
                        if (visited.add(newWord))
                            queue.add(newWord);
                    }
                }

            }
            level++;
        }
        return -1;
    }

}
