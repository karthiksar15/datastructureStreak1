
import java.util.Arrays;
import java.util.Collections;

public class Nov07261 {

    public static void main(String[] args) {
        Nov07261 nov = new Nov07261();
        int[] matchsticks = { 1, 3, 4, 2, 2, 4 };
        System.out.println("makeSquare--->" + nov.makesquare(matchsticks));
    }

    public boolean makesquare(int[] matchsticks) {
        int tot = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            tot += matchsticks[i];
        }
        if (tot % 4 != 0)
            return false;
        int len = tot / 4;
        int[] sticks = new int[4];
        Arrays.stream(matchsticks).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);
        return backtrack(matchsticks, sticks, 0, len);
    }

    public boolean backtrack(int[] matchSticks, int[] sticks, int index, int length) {
        if (index == matchSticks.length)
            return true;
        for (int i = 0; i < 4; i++) {
            if (sticks[i] + matchSticks[index] <= length) {
                sticks[i] += matchSticks[index];
                if (backtrack(matchSticks, sticks, index + 1, length))
                    return true;
                sticks[i] -= matchSticks[index];
            }
            if (sticks[i] == 0)
                break;
        }
        return false;
    }

}
