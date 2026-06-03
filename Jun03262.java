import java.util.Arrays;

public class Jun03262 {

    public static void main(String[] args) {
        Jun03262 jun = new Jun03262();
        int[] people = { 5, 1, 4, 2 };
        int limi = 6;
        System.out.println("numRescueBoats--->" + jun.numRescueBoats(people, limi));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        int min = 0;
        while (l <= r) {
            int rem = limit - people[r];
            if (rem >= people[l]) {
                l++;
            }
            min++;
            r--;
        }
        return min;
    }

}
