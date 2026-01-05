import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Jan0526 {

    public static void main(String[] args) {
        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        String target = "0202";
        Jan0526 jan = new Jan0526();
        System.out.println("find loack-->" + jan.openLock(deadends, target));
    }

    public int openLock(String[] deadends, String target) {

        Set<String> seen = new HashSet<>();
        String start = "0000";
        for (String deadend : deadends) {
            seen.add(deadend);
        }
        if (seen.contains(start) || seen.contains(target))
            return -1;
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(new Vertex(start, 0));
        seen.add(start);
        while (!queue.isEmpty()) {
            Vertex temp = queue.poll();
            String currLabel = temp.label;
            Integer currCount = temp.count;
            if (target.equals(currLabel))
                return currCount;
            for (String combi : findNeighbours(currLabel)) {
                if (!seen.contains(combi)) {
                    queue.add(new Vertex(combi, currCount + 1));
                }
            }
        }
        return -1;
    }

    public List<String> findNeighbours(String combi) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < combi.length(); i++) {
            int num = combi.charAt(i) - '0';
            for (int change : new int[] { 1, -1 }) {
                int x = (num + change + 10) % 10;
                ans.add(combi.substring(0, i) + x + combi.substring(i + 1));
            }
        }
        return ans;
    }

    class Vertex {
        String label;
        Integer count;

        public Vertex(String label, Integer count) {
            this.label = label;
            this.count = count;
        }
    }

}
