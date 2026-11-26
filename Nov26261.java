
import java.util.LinkedList;
import java.util.Queue;

public class Nov26261 {

    public static void main(String[] args) {
        Nov26261 nov = new Nov26261();
        String s = "00110010";
        System.out.println("canReaqch--->" + nov.canReach(s, 2, 4));
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int farthest = 0;
        int n = s.length();
        while (!queue.isEmpty()) {
            int i = queue.poll();
            int start = Math.max(i + minJump, farthest + 1);
            for (int j = start; j < Math.min(i + maxJump + 1, n); j++) {
                if (s.charAt(j) == '0') {
                    queue.add(j);
                    if (j == n - 1)
                        return true;
                }
            }
            farthest = i + maxJump;
        }
        return false;
    }

}
