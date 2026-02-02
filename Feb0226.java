import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Feb0226 {

    public static void main(String[] args) {
        String[] deadends = { "8888" };
        String target = "0009";
        Feb0226 feb = new Feb0226();
        System.out.println("open lock---->" + feb.openLock(deadends, target));
    }

    public int openLock(String[] deadends, String target) {
        Set<String> dict = new HashSet<>(Arrays.asList(deadends));
        if (dict.contains(target))
            return -1;
        String start = "0000";
        Set<String> visited = new HashSet<>();
        visited.add(start);
        visited.addAll(dict);
        Deque<String> queue = new LinkedList<>();
        queue.add(start);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String lock = queue.poll();
                if (lock.equals(target))
                    return result;
                for (String s : findNeigh(lock, visited)) {
                    queue.add(s);
                }
            }
            result++;
        }
        return -1;
    }

    public List<String> findNeigh(String src, Set<String> visited) {
        List<String> newNeihgs = new ArrayList<>();
        for (int i = 0; i < src.length(); i++) {
            int temp = src.charAt(i) - '0';
            for (int sign : List.of(1, -1)) {
                int soln = temp + (sign + 10) % 10;
                String newWord = src.substring(0, i) + soln + src.substring(i + 1);
                if (visited.add(newWord)) {
                    newNeihgs.add(newWord);
                }
            }
        }
        return newNeihgs;
    }

}
