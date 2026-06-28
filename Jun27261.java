import java.util.HashMap;
import java.util.Map;

public class Jun27261 {

    public static void main(String[] args) {
        int[] hand = { 1, 2, 4, 2, 3, 5, 3, 4 };
        int groupSize = 4;
        Jun27261 jun = new Jun27261();
        System.out.println("isNStraight--->" + jun.isNStraightHand(hand, groupSize));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : hand) {
            int start = num;
            while (map.getOrDefault(start - 1, 0) > 0)
                start--;
            while (start <= num) {
                while (map.getOrDefault(start, 0) > 0) {
                    for (int i = start; i < start + groupSize; i++) {
                        if (map.getOrDefault(i, 0) == 0)
                            return false;
                        map.put(i, map.get(i) - 1);
                    }
                }
                start++;
            }
        }
        return true;
    }

}
