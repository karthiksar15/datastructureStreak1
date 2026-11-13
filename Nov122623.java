import java.util.LinkedList;
import java.util.Queue;

public class Nov122623 {

    public static void main(String[] args) {
        Nov122623 nov = new Nov122623();
        String s = "00110010";
        int minJump = 2, maxJump = 4;
        System.out.println("CanREach-->" + nov.canReach(s, minJump, maxJump));
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> q = new LinkedList();
        q.add(0);
        int farthest = 0;
        int n = s.length();
        while (!q.isEmpty()) {
            int i = q.poll();
            int start = Math.max(i + minJump, farthest + 1);
            for (int j = start; j < Math.min(i + maxJump + 1, n); j++) {
                if (s.charAt(j) == '0') {
                    q.add(j);
                    if (j == n - 1)
                        return true;
                }
            }
            farthest = i + maxJump;
        }
        return false;
    }

}
