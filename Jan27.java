import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Pair {
    String node;
    int steps;
    Pair(String node, int steps) {
        this.node = node;
        this.steps = steps;
    }
}

public class Lock {

    public static void main(String[] args) {
        Lock lock=new Lock();
        System.out.println("locks---"+lock.openLock(new String[]{"2345","4356","7753","7755"}, "7754"));
    }
    public int openLock(String[] deadends, String target) {
        Queue<Pair> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        
        for (String s: deadends) {
            if (s.equals("0000")) {
                return -1;
            }
            seen.add(s);
        }
        
        queue.add(new Pair("0000", 0));
        seen.add("0000");

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            String node = pair.node;
            int steps = pair.steps;
            if (node.equals(target)) {
                System.out.println("found--"+node);
                return steps;
            }
            
            for (String neighbor: neighbors(node)) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    queue.add(new Pair(neighbor, steps + 1));
                }
            }
        }
        
        return -1;
    }
    
    public List<String> neighbors(String node) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int num = (node.charAt(i) - '0');
            for (int change: new int[]{-1, 1}) {
                int x = (num + change + 10) % 10;
                ans.add(node.substring(0, i) + ("" + x) + node.substring(i + 1));
            }
        }
        System.out.println("outputs-----"+ans);
        return ans;
    }
}
