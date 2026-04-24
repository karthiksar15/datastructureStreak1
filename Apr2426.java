import java.util.Arrays;

public class Apr23261 {

    public static void main(String[] args) {
        Apr23261 apr = new Apr23261();
        // int[] people = { 5, 1, 4, 2 };
        // int limit = 6;
        int[] people = { 1, 3, 2, 3, 2 };
        int limit = 3;
        System.out.println("boats--->" + apr.numRescueBoats(people, limit));
    }

    public int numRescueBoats(int[] people, int limit) {
        int l = 0, r = people.length - 1;
        int count = 0;
        Arrays.sort(people);
        while (l <= r) {
            int rem = limit - people[r];
            if (rem >= people[l]) {
                l++;
            }
            count++;
            r--;

        }
        return count;
    }

}
