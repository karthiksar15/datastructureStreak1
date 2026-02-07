import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Feb0726 {

    public static void main(String[] args) {
        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        String target = "0202";
        Feb0726 feb = new Feb0726();
        System.out.println("find loack-->" + feb.openLock(deadends, target));
    }

    public int openLock(String[] deadends, String target) {
        Set<String> dict = new HashSet<>(Arrays.asList(deadends));
        String start = "0000";
        if (dict.contains(start) || dict.contains(target))
            return -1;
        Deque<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        visited.addAll(dict);
        int res = 0;
        // Map<String,Double> ratioMap=new HashMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (temp.equals(target))
                    return res;
                for (int j = 0; j < temp.length(); j++) {
                    for (int k : List.of(1, -1)) {
                        int oldChar = temp.charAt(j) - '0';
                        int newChar = (oldChar + k + 10) % 10;
                        String newWord = temp.substring(0, j) + newChar + temp.substring(j + 1);
                        if (visited.add(newWord)) {
                            queue.add(newWord);
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
