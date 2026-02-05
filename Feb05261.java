import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Feb05261 {
    public static void main(String[] args) {
        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        String target = "0202";
        Feb0426 feb = new Feb0426();
        System.out.println("find loack-->" + feb.openLock(deadends, target));
    }

    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        visited.addAll(Arrays.asList(deadends));
        String start = "0000";
        if (visited.contains(target) || visited.contains(start))
            return -1;

        Queue<String> q = new LinkedList<>();
        q.add(start);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                String temp = q.poll();
                if (temp.equals(target))
                    return res;
                // char[] chars = temp.toCharArray();
                for (int i = 0; i < temp.length(); i++) {
                    // char original = chars[i];
                    for (int j : List.of(1, -1)) {
                        int oldNum = (temp.charAt(i) + j + 10) % 10;
                        String newString = temp.substring(0, i) + oldNum + temp.substring(i + 1);
                        if (visited.add(newString)) {
                            q.add(newString);
                        }
                    }
                    // chars[i] = original;
                }
                res++;
            }
        }
        return -1;

    }

}
