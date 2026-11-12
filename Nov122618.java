public class Nov122618 {

    public static void main(String[] args) {
        int[] bills = { 5, 10, 5, 5, 20 };
        Nov122618 nov = new Nov122618();
        System.out.println("lemonde--->" + nov.lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for (int b : bills) {
            if (b == 5) {
                five++;
            } else if (b == 10) {
                ten++;
                five--;
            } else if (ten > 0) {
                ten--;
                five--;
            } else {
                five -= 5;
            }
            if (five < 0)
                return false;

        }

        return true;
    }

}
