import java.util.Arrays;

public class Jun06261 {

    public static void main(String[] args) {
        int[] people = { 5, 1, 4, 2 };
        int limit = 6;
        Jun06261 jun = new Jun06261();
        System.out.println("numRescue--->" + jun.numRescueBoats(people, limit));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int l = 0, r = people.length - 1;
        while (l < r) {
            int diff = people[r] - people[l];
            if (diff <= limit) {
                l++;
            }
            r--;
            count++;
        }
        return count;
    }

}
