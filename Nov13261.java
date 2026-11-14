import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Nov13261 {

    public static void main(String[] args) {
        Nov13261 nov = new Nov13261();
        int[] hand = { 1, 2, 4, 2, 3, 5, 3, 4 };
        int groupSize = 4;
        System.out.println("isNStraight-->" + nov.isNStraightHand(hand, groupSize));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int h : hand) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }
        Queue<Integer> q = new LinkedList<>();
        int lastNum = -1, openGroups = 0;
        for (int num : map.keySet()) {
            if ((openGroups > 0 && num > lastNum + 1) || openGroups > map.get(num)) {
                return false;
            }
            q.add(map.get(num) - openGroups);
            lastNum = num;
            openGroups = map.get(num);
            if (q.size() == groupSize) {
                openGroups -= q.poll();
            }
        }
        return openGroups == 0;
    }

}
