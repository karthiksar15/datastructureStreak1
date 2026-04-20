import java.util.Arrays;

public class Apr1926 {

    public static void main(String[] args) {
        int[] people = { 1, 3, 2, 3, 2 };
        int limit = 3;
        // int[] people = { 5, 1, 4, 2 };
        // int limit = 6;
        Apr1926 apr = new Apr1926();
        System.out.println("rescue boats--->" + apr.numRescueBoats(people, limit));
    }

    public int numRescueBoats(int[] people, int limit) {
        int i = 0;
        int j = people.length - 1;
        Arrays.sort(people);
        int res = 0;
        while (i <= j) {
            int remain = limit - people[j--];
            res++;
            if (i <= j && remain >= people[i]) {
                i++;
            }
        }

        return res;
    }

}
